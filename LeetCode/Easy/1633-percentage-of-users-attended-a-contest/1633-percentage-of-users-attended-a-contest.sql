# Write your MySQL query statement below
select r.contest_id, round(count(r.user_id) / t.total * 100.00, 2) as percentage
from Register r
join (select count(*) as total from Users) t
group by r.contest_id
order by percentage desc, r.contest_id
;