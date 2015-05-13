package products



class Translation {
	String sku
	String name
	String description
	String size
	String contentsAndStorage
	//String regulatoryStatement
	Date lastUpdated
	Integer version
	String editedBy
	String lang
	
	static searchable = [except: ['sku','lang','editedBy','version','lastUated']]
	
  static mapping = {
    table "translations"
	description type: 'text'
	name type: 'text'
	size type: 'text'
	id type: Long
	
	contentsAndStorage type: 'text'
  }	
  
  static constraints = {
    sku blank: false
    name blank: false
    editedBy blank: false
    version blank: false
	description nullable: true
	size nullable: true
	contentsAndStorage nullable: true
  }
  
  static belongsTo = [product:Product]
  
 /*static search = {
	  name index: 'tokenized'
	  description index: 'tokenized'
  }*/	

}
