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
	description type: 'text',nullable: true
	name type: 'text',nullable: true
	size type: 'text',nullable: true
	id type: Long
	
	contentsAndStorage type: 'text'
  }	
  
  static belongsTo = [product:Product]
  
 /*static search = {
	  name index: 'tokenized'
	  description index: 'tokenized'
  }*/	

  static constraints = {
    sku blank: false
    name blank: false
    editedBy blank: false
    version blank: false
  }
}
