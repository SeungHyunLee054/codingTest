-- 코드를 입력하세요
SELECT extract(hour from DATETIME) as HOUR, count(time(DATETIME)) as 'COUNT'
from ANIMAL_OUTS
where extract(hour from DATETIME)>=9 and extract(hour from DATETIME)<20
group by HOUR
order by HOUR
;