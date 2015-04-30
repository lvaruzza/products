package products

class Price {
	String sku
	String ncm
	String size
	String name
	BigDecimal price_USD
	BigDecimal price_BRL_no_IPI
	BigDecimal price_BRL
	Date updated_on
	
    static constraints = {
		sku blank: false
		name nullable:true,blank:true
		price_USD nullable:true,blank:true
		price_BRL nullable:true,blank:true
		price_BRL_no_IPI nullable:true,blank:true
	}
}
