databaseChangeLog = {

	changeSet(author: "varuzza (generated)", id: "1431559468404-1") {
		modifyDataType(columnName: "updated_on", newDataType: "date", tableName: "price")
	}

	changeSet(author: "varuzza (generated)", id: "1431559468404-2") {
		createIndex(indexName: "price_sku", tableName: "price") {
			column(name: "sku")
		}
	}

	changeSet(author: "varuzza (generated)", id: "1431559468404-3") {
		createIndex(indexName: "price_updated_on", tableName: "price") {
			column(name: "updated_on")
		}
	}

	changeSet(author: "varuzza", id: "1431559468404-4") {
	       sql("""
create view last_price as
select distinct on (sku) sku,price_USD,updated_on
from price
order by sku,updated_on  desc;""")
	}
}
