databaseChangeLog = {

	changeSet(author: "varuzza (generated)", id: "1433781719464-1") {
		addColumn(tableName: "products") {
			column(name: "deprecated", type: "bool",defaultValue:false) {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "varuzza", id: "1433781719464-2") {
	       sql("""
drop view if exists proforma_view; 
Create view proforma_view as
 select lp.sku,
	lp.price_usd,
    lp.price_brl,
	lp.price_brl_no_ipi,
	lp.updated_on,
 	j.product_prices_id  as product_id,
	t.name,
	t.description,
	p.deprecated
from last_price as lp
left join products_price as j  on (lp.id=j.price_id)
left join products as p on (p.id=j.product_prices_id)
left join translations as t on (t.product_id=j.product_prices_id);
""")
     }
     changeSet(author: "varuzza", id: "1431559468404-12") {
       sql("grant select on proforma_view to odbc")
       
     }
}
