-- 코드를 입력하세요
SELECT year(o.SALES_DATE)                                                                                 as YEAR,
       month(o.SALES_DATE)                                                                                as MONTH,
       count(distinct u.USER_ID)                                                                          as PURCHASED_USERS,
       round(count(distinct u.USER_ID) / (select count(*) from USER_INFO where year(JOINED) = '2021'),
             1)                                                                                           as PURCHASED_RATIO
from USER_INFO u
         join ONLINE_SALE o
              on u.USER_ID = o.USER_ID
where year(u.JOINED) = '2021'
group by YEAR, MONTH
order by YEAR, MONTH
;