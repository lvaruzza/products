package products

import static grails.async.Promises.*
import grails.converters.JSON

import javax.servlet.http.HttpSession

class PriceController {
	def importPricesService
	
	def index() {
		render view:"index"
	}

	def upload() {
		def uploadedFile = request.getFile('file')
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
			importPricesService.process(params.type,tmp)
			flash.message="Upload finished"	
			render view:"index"
		} else {
			flash.message="Empty File"
			 redirect(action:"index")
		}
	}
	
	def progress() {
		render ([session['import_sku'],
				session['import_lineno']] as JSON)
	}
	
}
