create view last_price as
select distinct on (sku) sku,price_USD,updated_on
from price
order by sku,updated_on  desc;

create view proforma_view as
 select lp.*,
 	j.product_prices_id,
	t.name,
	t.description as product_id
from last_price as lp
left join products_price as j  on (lp.id=j.price_id)
left join translations as t on (t.product_id=j.product_prices_id);

