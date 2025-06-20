# Write your MySQL query statement below
select
 id,
 case
  when id % 2 = 1 and lead(id) over (order by id) is not null then lead(student) over(order by id)
  when id % 2 = 0 then lag(student) over(order by id)
  else student
 end as student
from Seat
order by id
;