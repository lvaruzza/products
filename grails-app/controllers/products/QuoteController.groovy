package products

import grails.plugin.springsecurity.annotation.Secured

class QuoteController {
	
	@Secured(['ROLE_QUOTE'])
	def index() {
		render(view:"downloads")
	}
}
