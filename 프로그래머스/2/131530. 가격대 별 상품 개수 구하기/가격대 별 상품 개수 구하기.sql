-- 코드를 입력하세요
SELECT case
when PRICE >= 0 and PRICE < 10000 then 0
else truncate(PRICE, -4)
end PRICE_GROUP, count(PRODUCT_ID) as PRODUCTS
from PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP
;