# Write your MySQL query statement below
select round(avg(case when order_date = customer_pref_delivery_date then 1 else 0 end) * 100.00, 2) immediate_percentage
from Delivery d
join (select customer_id, min(order_date) as first_order_date from Delivery group by customer_id) fo
on d.customer_id = fo.customer_id and d.order_date = fo.first_order_date
;