-- 코드를 입력하세요
SELECT round(avg(DAILY_FEE)
             # over(partition by CAR_TYPE)
            ) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR
where CAR_TYPE = 'SUV'
# group by CAR_TYPE
;