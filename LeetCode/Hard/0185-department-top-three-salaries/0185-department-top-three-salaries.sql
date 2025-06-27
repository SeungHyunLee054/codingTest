# Write your MySQL query statement below
with ranked_employees as (
    select d.name as Department, e.name as Employee, e.salary as Salary, dense_rank() over(partition by e.departmentId order by e.salary desc) as salary_rank
    from Employee e
    join Department d
    on e.departmentId = d.id
)

select Department, Employee, Salary
from ranked_employees
where salary_rank <= 3
;