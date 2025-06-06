# Write your MySQL query statement below
select s.user_id, round(ifnull(avg(action = 'confirmed'), 0), 2) as confirmation_rate
from Signups s
left join Confirmations c on s.user_id = c.user_id
group by user_id
;