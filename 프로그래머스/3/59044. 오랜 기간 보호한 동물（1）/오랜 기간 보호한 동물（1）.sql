-- 코드를 입력하세요
SELECT NAME, DATETIME
from ANIMAL_INS 
where ANIMAL_ID not in (select ANIMAL_ID from ANIMAL_OUTS)
order by DATETIME
limit 3