# Write your MySQL query statement below
select employee_id
from Employees e
where salary < 30000 and manager_id is not null and (select employee_id from Employees where employee_id = e.manager_id) is null
order by employee_id
;