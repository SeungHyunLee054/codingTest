-- 코드를 입력하세요
with recursive hours as (
    select 0 as hour
    union
    select hour + 1 
    from hours 
    where hour < 23
)
SELECT h.hour as 'HOUR', count(o.DATETIME) as 'COUNT'
from hours h
left join ANIMAL_OUTS o
on hour(o.DATETIME) = h.hour
group by h.hour
order by h.hour
;