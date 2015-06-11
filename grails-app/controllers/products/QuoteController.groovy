package products

import grails.plugin.springsecurity.annotation.Secured

class QuoteController {
	
	@Secured(['ROLE_PRICE'])
	def index() {
		render(view:"downloads")
	}
}
