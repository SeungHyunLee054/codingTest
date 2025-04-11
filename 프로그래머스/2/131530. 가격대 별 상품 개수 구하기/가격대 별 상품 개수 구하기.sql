-- 코드를 입력하세요
SELECT case
when PRICE >= 0 and PRICE < 10000 then 0
when PRICE >= 10000 and PRICE < 20000 then 10000
when PRICE >= 20000 and PRICE < 30000 then 20000
when PRICE >= 30000 and PRICE < 40000 then 30000
when PRICE >= 40000 and PRICE < 50000 then 40000
when PRICE >= 50000 and PRICE < 60000 then 50000
when PRICE >= 60000 and PRICE < 70000 then 60000
when PRICE >= 70000 and PRICE < 80000 then 70000
when PRICE >= 80000 and PRICE < 90000 then 80000
when PRICE >= 90000 and PRICE < 100000 then 90000
end PRICE_GROUP, count(PRODUCT_ID) as PRODUCTS
from PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP
;