# Write your MySQL query statement below
select q.person_name
from Queue q
join Queue jq
on q.turn >= jq.turn
group by q.person_id, q.person_name, q.turn
having sum(jq.weight) <= 1000
order by q.turn desc
limit 1
;