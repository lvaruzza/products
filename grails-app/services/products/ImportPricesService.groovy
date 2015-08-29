package products

import grails.converters.*

import java.text.*

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest
import org.hibernate.FlushMode
import org.hibernate.SessionFactory

class ImportPricesService {
	static transactional = false
	static scope = "singleton"

	def getSession() {
		def s=GrailsWebRequest.lookup().currentRequest.getSession()
		return s
	}

	def nf=NumberFormat.getNumberInstance(new Locale("pt","BR"));
	def nfbrl=NumberFormat.getNumberInstance(new Locale("pt","BR"));

	def createPrice(sku,ncm,name,size,usd,brl_no_ipi,brl,legenda,lineno) {
		try {
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
			//println("SKU '${sku}'")
			//println(product as JSON)
			def s=getSession()
			s.putValue('import_sku',sku)
			s.putValue('import_lineno',lineno)

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
				product.save(failOnError:true,flush:true	)
			}
			price.save(failOnError:true,flush:true)
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

		} catch(Exception e) {
			e.printStackTrace()

		}

	}
	def insertGeneral(line,lineno) {
		def lst = line.split("\t")
		if (lst.length >= 13) {
			def sku = lst[0].trim()
			def ncm = lst[2].trim()
			def name = lst[1].trim()
			def size = lst[8].trim()
			def usd = lst[9].trim()
			def brl_no_ipi = lst[10].trim()
			def brl = lst[12].trim()
			def legenda = lst[3].trim()
			createPrice(sku,ncm,name,size,usd,brl_no_ipi,brl,legenda,lineno)
		} else {
			println "Skipping line: '$line'"
		}
	}

	def insertPlastic(line,lineno) {
		def lst = line.split("\t")
		if (lst.length >= 13) {
			def sku = lst[0].trim()
			def ncm = ""
			def name = lst[1].trim()
			def size = lst[2].trim()
			def usd = null
			def brl_no_ipi = null
			def brl = lst[6].trim()
			def legenda = ""
			createPrice(sku,ncm,name,size,usd,brl_no_ipi,brl,legenda,lineno)
		} else {
			println "Skipping line: '$line'"
		}
	}

	def insertNanodrop(String line) {
	}

	def process(String type,File file) {
		println("Process1 Session ${getSession()}")
		nf.applyPattern("\$###,###.##")
		nfbrl.applyPattern("R\$ ###,###.##")

		println "Processing '${type}': $file"
		switch(type) {
			case "general":
				process(file,this.&insertGeneral)
				break;
			case "plastics":
				process(file,this.&insertPlastics)
				break;
			case "nanodrop":
				process(file,this.&insertNanodrop)
				break;
		}
	}
	def process(File file,inserter) {
		Price.withSession { session ->
			session.setFlushMode(FlushMode.COMMIT)
			file.withReader { reader ->
				def header = reader.readLine().split("\t")
				header.eachWithIndex { x,i ->
					println "${i}: $x"
				}
				reader.eachLine { line,lineno ->
					Price.withTransaction { status ->
						inserter(line,lineno)
					}
					if (lineno%100==0) {
						println "Flushing..."
						session.flush()
						println line
					}
				} // Each Line
				session.clear()
				println "Reindexing..."
				Product.reindex()
			}
			println "\nfinished"
		}
	}
}