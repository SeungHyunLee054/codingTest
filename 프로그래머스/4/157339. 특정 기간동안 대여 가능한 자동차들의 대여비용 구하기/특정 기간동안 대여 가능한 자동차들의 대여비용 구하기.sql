-- 코드를 입력하세요
SELECT c.CAR_ID, c.CAR_TYPE, round(c.DAILY_FEE * (100 - d.DISCOUNT_RATE) / 100 * 30) as FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY r
on c.CAR_ID = r.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
on c.CAR_TYPE = d.CAR_TYPE
where c.CAR_ID not in (select CAR_ID
                       from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                       where END_DATE >= '2022-11-01' and START_DATE <= '2022-11-30')
and d.DURATION_TYPE = '30일 이상'
group by c.CAR_ID
having c.CAR_TYPE in ('세단', 'SUV')
and (FEE >= 500000 and FEE < 2000000)
order by FEE desc, CAR_TYPE, CAR_ID
;