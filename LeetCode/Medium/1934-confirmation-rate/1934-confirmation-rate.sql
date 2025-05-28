# Write your MySQL query statement below
with confirmed as
         (select user_id, sum(action = 'confirmed') as confirmed_count, count(*) as total_count
          from Confirmations
          group by user_id)

select s.user_id,
       case
           when c.total_count is null or c.total_count = 0 then 0
           else round(ifnull(c.confirmed_count, 0) / ifnull(c.total_count, 0), 2)
           end as confirmation_rate
from Signups s
         left join confirmed c
                   on s.user_id = c.user_id
;