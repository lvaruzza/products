package products

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

class ProductsController {
	//def searchableService
	//def springSecurityService
	
    def index() { 
		redirect(action: "list", params: params)
	}
	
	def list(String query) {
		if (query==null) query=""

		int off = params.int( "offset") ?: 0
		int max = Math.min(params.int("max") ?: 50,100)
		session["query"]=query
		session["max"]=max
		session["offset"]=off
		def list=[]
		def total=0;
		
		if (query==null || query=="") {
			list=Product.list(sort: "sku",offset:off,max:max)
			total=Product.count
		} else { 
			total=Product.countHits(query,escape:true)
			def r=Product.search(query,[escape:true,max:max,offset:off])
			list=r.results
		}		
		[query: query,results:list,total: total,max:max]
	}
	
	def canEdit() {
		return SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN,ROLE_EDITOR')
	}
	
	def show(Integer id) {
		def prod=Product.get(id)
		[product: prod]
	}

	def save() {
		println "************************************************************"
		println "Save:"
		println params
		def product = new Product(params)
		product.lang = product.lang ?: "en_US"
		product.url =  product.url ?: "undefined"
		println "product id: ${product.id}"
		println product.dump();
		updateOrSave(product,true)
	}
	
	def update(int id) {
		def product=Product.get(id)
		//product.translation = product.translation ?: new Translation()
		println "--------------------------------------------------"
		println params.translation.dump()
		//bindData(product,params)
		//bindData(product.translation,params,prefix:"tranlation")
		
		product.properties = params
		product.translation = product.translation ?: new Translation(params.translation)
		
		println "--------------------------------------------------"
		println product.dump()
		println "--------------------------------------------------"
		updateOrSave(product,false)
	}	
	
	def updateOrSave(Product product,boolean create) {
		if (canEdit()) {
			product.name = product.name ?: ""
			product.translation.name= product.translation.name ?: ""
			println "sku: ${product.sku}"
			println "translation: ${product.translation}"
			product.translation.sku = product.sku
			def user = getAuthenticatedUser()
			
			product.translation.editedBy =user.initials
			product.editedBy = user.initials
			product.translation.lang = "pt_BR"
			
			
			//product.translation.update = new Date().toTimestamp()
			//println(params.keySet())
			//Translation translation = new Translation(params);
			//product.setTranslation(translation)

			//product.translation.save(flush:true)
			println product.dump();
			if (!product.save(flush: true)) {
				product.errors.each { println it }
				def canEdit = canEdit()
				def readOnly = canEdit ? "false" : "readonly"

				render(view: "edit", model: [product: product,readonly:readOnly,canEdit:canEdit])
				return
			}
			println product.dump();
		}
		redirect (action: "list",params:[query:session["query"],
			offset:session["offset"],
			max:session["max"]])
	}

	def editOrCreate(Product product,boolean create) {
		if (product.translation == null) {
			product.translation = new Translation()
			product.translation.name = product.name
			product.translation.description = product.description
			product.translation.contentsAndStorage = product.contentsAndStorage
			//product.translation.regulatoryStatement = product.regulatoryStatement
			product.translation.size = product.size
			product.translation.editedBy = "SYS"
			product.translation.lang="en_US"
			product.translation.sku = product.sku
			//product.save(flush:true,failOnError:true);
		}
		def canEdit = canEdit()
		def readOnly = canEdit ? "false" : "readonly"
		println "CE ${canEdit} RO ${readOnly}"
		[product: product,readonly: readOnly, canEdit: canEdit,create:create]
	}
	
	def edit(Integer id) {
		def product=Product.get(id)
		product.properties = params
		editOrCreate(product,false);
	}

	def create() {
		def product = new Product();
		def p = editOrCreate(product,true);
		render(view:"edit",model:p)
	}
}
