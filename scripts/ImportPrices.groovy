import java.text.*

import grails.converters.*


includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsBootstrap")
includeTargets << grailsScript("_GrailsClasspath")

target(importPrices: "The description of the script goes here!") {
	depends( configureProxy, packageApp, classpath, loadApp, configureApp)
	loadApp()
	configureApp()

	def priceClass = grailsApp.getClassForName("products.Price")
	def productClass = grailsApp.getClassForName("products.Product")
	def nf=NumberFormat.getNumberInstance(new Locale("pt","BR"));
	nf.applyPattern("\$###,###.##")

	def nfbrl=NumberFormat.getNumberInstance(new Locale("pt","BR"));
	nfbrl.applyPattern("R\$ ###,###.##")

	def inputFile=argsMap.input	
	println "Importing prices from '${inputFile}'"
	def file=new File(inputFile)
	file.withReader { reader ->
		header = reader.readLine().split("\t")
		header.eachWithIndex { x,i -> println "${i}: $x" }
		priceClass.withSession { session ->
			reader.eachLine {  line,lineno ->
				priceClass.withTransaction { status ->

					def lst = line.split("\t")
					try {
						if (lst.length >= 13) {
							def sku = lst[0].trim()
							def ncm = lst[2].trim()
							def name = lst[1].trim()
							def size = lst[8].trim()
							def usd = lst[9].trim()
							def brl_no_ipi = lst[10].trim()
							def brl = lst[12].trim()


							def price = priceClass.newInstance()
							price.sku = sku
							price.ncm = ncm
							price.size = size
							price.name = name.trim()
							price.price_USD = (usd == "\$-") ?  null : nf.parse(usd)
							price.price_BRL = (brl == "R\$ -") ?  null : nfbrl.parse(brl)
							price.price_BRL_no_IPI = (brl_no_ipi == "R\$ -") ?  null : nfbrl.parse(brl_no_ipi)
							price.updated_on = new Date()
							//price.save(failOnError: true)

							def product = productClass.findBySku(sku)
							//println("SKU '${sku}'")
							//println(product as JSON)
							if (product != null) {
							} else {
								product = productClass.newInstance();
								product.sku = sku
								product.name = "not defined"
								product.translation.name = name
								product.translation.sku = sku
								product.translation.lang = "pt_BR"
								product.translation.editedBy="PRICE"								
								product.editedBy="PRICE"
								product.lang="en_US"								
							}
							product.addToPrices(price)
							product.save(failOnError:true,flush:true)
						}
					} catch(Exception e) {
						status.setRollbackOnly()
						println "line $lineno"
						lst.eachWithIndex { x,i -> println "${i}: $x" }
						e.printStackTrace()
					}
				}
			}
			println "\nfinished"
			session.clear();
		}
	}
}


setDefaultTarget(importPrices)
