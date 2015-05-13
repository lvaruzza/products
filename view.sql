create view last_price as
select distinct on (sku) sku,price_USD,updated_on
from price
order by sku,updated_on  desc;


