-- 코드를 작성해주세요
select three.ID 
from ECOLI_DATA as three
inner join ECOLI_DATA as two
on three.PARENT_ID = two.ID
inner join ECOLI_DATA as one
on two.PARENT_ID = one.ID
where one.PARENT_ID is null
order by ID;
