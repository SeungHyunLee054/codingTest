-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(p.PRICE*o.SALES_AMOUNT) as SALES
from PRODUCT p
join OFFLINE_SALE o
on p.PRODUCT_ID = o.PRODUCT_ID
group by PRODUCT_CODE
order by sum(p.PRICE*o.SALES_AMOUNT) desc, p.PRODUCT_CODE
;