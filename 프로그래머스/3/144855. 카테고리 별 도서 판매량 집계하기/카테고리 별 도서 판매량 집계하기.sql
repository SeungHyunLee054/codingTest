-- 코드를 입력하세요
SELECT b.CATEGORY, sum(bs.SALES) as TOTAL_SALES
from BOOK b
join BOOK_SALES bs
on b.BOOK_ID = bs.BOOK_ID
where year(bs.SALES_DATE) = '2022' and month(bs.SALES_DATE) = '01'
group by b.CATEGORY
order by b.CATEGORY
;