package products

import grails.converters.*
import org.hibernate.FlushMode

import java.text.*

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsHttpSession
//import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest
//import org.springframework.web.context.request.RequestContextHolder

class ImportPricesService {
	def   sessionFactory
	//GrailsWebRequest request = RequestContextHolder.currentRequestAttributes()
	//GrailsHttpSession session = request.session

	def nf=NumberFormat.getNumberInstance(new Locale("pt","BR"));
	def nfbrl=NumberFormat.getNumberInstance(new Locale("pt","BR"));

	def createPrice(line) {
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
				def legenda = lst[3].trim()
				def price = new Price();
				price.sku = sku
				price.ncm = ncm
				price.size = size
				price.name = name.trim()
				price.price_USD = (usd == "\$-") ?  null : nf.parse(usd)
				price.price_BRL = (brl == "R\$ -") ?  null : nfbrl.parse(brl)
				price.price_BRL_no_IPI = (brl_no_ipi == "R\$ -") ?  null : nfbrl.parse(brl_no_ipi)
				price.updated_on = new Date()
				//price.save(failOnError: true)

				def product = Product.findBySku(sku,[lock:true])
				println("SKU '${sku}'")
				//println(product as JSON)
				if (product == null) {
					println "Creating product ${sku} ${name}"
					product = new Product();
					product.sku = sku
					product.name = "not defined"
					product.translation.name = (name != null || name != "") ? name : "not defined"
					product.translation.sku = sku
					product.translation.lang = "pt_BR"
					product.translation.editedBy="PRICE"
					product.translation.size = size
					product.editedBy="PRICE"
					product.lang="en_US"
					product.lastUpdated = new Date()
					product.save()
				}
				product.addToPrices(price)
				if (legenda=="D") {
					if (!product.deprecated) {
						println "Product ${sku} deprecated"
						product.deprecated = true
					}
				} else if (product.deprecated){
					product.deprecated=false
				}
				if (product.translation != null) {
					if (product.translation.name==null || product.translation.name=="") {
						product.translation.name = name
					}
				}
				product.save(failOnError:true,flush:true)
			}
		} catch(Exception e) {
			println "line $lineno"
			lst.eachWithIndex { x,i -> println "${i}: $x" }
			e.printStackTrace()

		}
	}

	def process(File file) {
		nf.applyPattern("\$###,###.##")

		nfbrl.applyPattern("R\$ ###,###.##")

		Price.withNewSession { hibernateSession->
			//sessionFactory.currentSession.clear()
			//Message.executeUpdate("delete Message where source='IMPORT_PRICE'")
			def count=0
			file.withReader { reader ->
				def header = reader.readLine().split("\t")
				header.eachWithIndex { x,i ->
					println "${i}: $x"
				}
				reader.eachLine { line,lineno ->
					Price.withTransaction { status -> createPrice(line) }
					if (count%100==0) {
							println line
					}
					count++
				} // Each Line

			}
			println "\nfinished"
		}
	}
}