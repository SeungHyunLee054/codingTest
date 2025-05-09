-- 코드를 입력하세요
WITH RECURSIVE hours AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1 FROM hours WHERE hour < 23
)
SELECT h.hour as 'HOUR', count(o.DATETIME) as 'COUNT'
from hours h
left join ANIMAL_OUTS o
on hour(o.DATETIME) = h.hour
group by h.hour
order by h.hour
;