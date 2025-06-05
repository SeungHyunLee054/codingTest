# Write your MySQL query statement below
select s.product_id, s.year as first_year, s.quantity, s.price
from Sales s
join (select product_id, min(year) as first_year from Sales group by product_id) sf
on s.product_id = sf.product_id and s.year = sf.first_year
;