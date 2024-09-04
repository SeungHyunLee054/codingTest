-- 코드를 작성해주세요
select emp.EMP_NO,
emp.EMP_NAME,
(case
 when AVG(SCORE)>=96 then 'S'
 when AVG(SCORE)>=90 then 'A'
 when AVG(SCORE)>=80 then 'B'
 else 'C'
 end) as GRADE,
(case
 when AVG(SCORE)>=96 then emp.SAL * 0.2
 when AVG(SCORE)>=90 then emp.SAL * 0.15
 when AVG(SCORE)>=80 then emp.SAL * 0.1
 else 0
 end) as BONUS
from HR_EMPLOYEES emp
inner join HR_GRADE grd
on emp.EMP_NO = grd.EMP_NO
group by emp.EMP_NO
order by emp.EMP_NO;