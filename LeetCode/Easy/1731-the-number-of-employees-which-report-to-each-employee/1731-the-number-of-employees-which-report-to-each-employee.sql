# Write your MySQL query statement below
select e.employee_id, e.name, ej.reports_count, ej.average_age
from Employees e
join (select count(reports_to) as reports_count, reports_to, round(avg(age)) as average_age from Employees group by reports_to) ej
on e.employee_id = ej.reports_to
order by e.employee_id
;