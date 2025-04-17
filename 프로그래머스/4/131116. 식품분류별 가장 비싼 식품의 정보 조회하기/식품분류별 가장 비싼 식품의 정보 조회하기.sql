-- 코드를 입력하세요
SELECT CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where (CATEGORY, PRICE)
in (select CATEGORY, MAX(PRICE)
   from FOOD_PRODUCT
   group by CATEGORY)
and CATEGORY
in ('과자', '국', '김치', '식용유')
order by PRICE DESC
;