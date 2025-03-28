-- 코드를 입력하세요
SELECT CAR_TYPE, count(CAR_TYPE) as CARS
from CAR_RENTAL_COMPANY_CAR
where locate('통풍시트', OPTIONS) > 0 or locate('열선시트', OPTIONS) > 0 or locate('가죽시트', OPTIONS) > 0
group by CAR_TYPE
order by CAR_TYPE
;