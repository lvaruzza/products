package products

import static grails.async.Promises.*

class PriceController {
	def importPricesService
	
	def index() {
		render view:"index"
	}

	def upload() {
		def uploadedFile = request.getFile('price_list')

		if(!uploadedFile.empty){
			println "Class: ${uploadedFile.class}"
			println "Name: ${uploadedFile.name}"
			println "OriginalFileName: ${uploadedFile.originalFilename}"
			println "Size: ${uploadedFile.size}"
			println "ContentType: ${uploadedFile.contentType}"
			
			File tmp = File.createTempFile("products_price",".csv")
			tmp.deleteOnExit()
			println "Temp file ${tmp.absolutePath}"
			uploadedFile.transferTo(tmp)
			importPricesService.process(tmp,session)
			//def t=task{
			//Product.withNewSession {
			//}
			//}
			println t.getClass()
			render view:"index"
		} else {
			render view:"index"
		}
	}
	
	def progress() {
		render session['import_sku']
	}
}
