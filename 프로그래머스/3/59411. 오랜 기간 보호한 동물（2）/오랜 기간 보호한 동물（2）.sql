-- 코드를 입력하세요
SELECT io.ANIMAL_ID, io.NAME
from (select o.ANIMAL_ID, o.NAME, o.DATETIME-i.DATETIME
        from ANIMAL_OUTS o
        join ANIMAL_INS i
        on i.ANIMAL_ID = o.ANIMAL_ID
        order by o.DATETIME-i.DATETIME desc) io
limit 2
;