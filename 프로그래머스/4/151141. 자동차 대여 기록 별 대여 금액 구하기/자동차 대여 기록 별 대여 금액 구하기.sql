-- 코드를 입력하세요
SELECT h.HISTORY_ID,
       round(c.DAILY_FEE * (datediff(h.END_DATE, h.START_DATE) + 1) * (100 - ifnull(d.DISCOUNT_RATE, 0)) / 100) as FEE
from CAR_RENTAL_COMPANY_CAR c
         join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
              on c.CAR_ID = h.CAR_ID
         left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
                   on c.CAR_TYPE = d.CAR_TYPE and d.DURATION_TYPE = (case
                                                                         when datediff(h.END_DATE, h.START_DATE) + 1 >= 90
                                                                             then '90일 이상'
                                                                         when datediff(h.END_DATE, h.START_DATE) + 1 >= 30
                                                                             then '30일 이상'
                                                                         when datediff(h.END_DATE, h.START_DATE) + 1 >= 7
                                                                             then '7일 이상'
                                                                         else null
                       end)
where c.CAR_TYPE = '트럭'
group by h.HISTORY_ID
order by FEE desc, h.HISTORY_ID desc
;