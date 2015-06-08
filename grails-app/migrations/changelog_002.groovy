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
create view last_price a
select distinct on (sku) sku,price_USD,price_BRL,price_BRL_no_IPI,updated_on
from price
order by sku,updated_on  desc;""")
	}

	changeSet(author: "varuzza", id: "1431559468404-10") {
	       sql("""
drop view IF EXISTS last_price;
create view last_price as
select distinct on (sku) id,sku,price_USD,price_BRL,price_BRL_no_IPI,updated_on
from price
order by sku,updated_on  desc;""")
	}


	changeSet(author: "varuzza", id: "1431559468404-11") {
	       sql("""
Create view proforma_view as
 select lp.*,
 	j.product_prices_id  as product_id,
	t.name,
	t.description
from last_price as lp
left join products_price as j  on (lp.id=j.price_id)
left join translations as t on (t.product_id=j.product_prices_id);
""")
     }
     changeSet(author: "varuzza", id: "1431559468404-12") {
       sql("grant select on proforma_view to odbc")
       
     }
}
