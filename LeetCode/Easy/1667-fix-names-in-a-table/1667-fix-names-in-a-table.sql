# Write your MySQL query statement below
select user_id, concat(upper(left(name, 1)), lower(substring(name, 2))) as name
from Users
;