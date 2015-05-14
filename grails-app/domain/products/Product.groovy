package products


import grails.converters.JSON


class Product {
	String sku
	String name
	String description
	String size
	String contentsAndStorage
	String url
	String editedBy
	String lang
	//String regulatoryStatement
	String path
	Integer version
	Date lastUpdated
	static hasOne  =[translation:Translation]
	static hasMany =[prices:Price]
	
	
	static searchable = {
		except = ["version", "lastUpdated"]
		name boost: 2.0
        translation component: true
	}
		
  static mapping = {
    table "products"
	sku index:'product_sku_Idx',length: 20
	name type: 'text',index:'product_name_Idx'
	description type: 'text'
	contentsAndStorage type: 'text'
	size type:'text'
	path type: 'text'
	url type: 'text'
	id type: Long
	lastUpdated type:'timestamp'
	translation cascade:"all"
  }	
  
  
  static constraints = {
    sku blank: false
    name blank: false
	//translation unique: true
	translation nullable:true
	contentsAndStorage nullable:true
	size nullable:true
	description nullable:true
	path nullable:true
	url nullable:true
  }

  def dump() {
	  JSON.use('deep')
	  return new JSON(this)
  }
  
  def Product() {
	  translation = new Translation()
  }
  
  def lastPrice() {
	  if (prices == null ) return null
	  else prices?.isEmpty() ? null : prices.last()
  }
 }
