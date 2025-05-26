# Write your MySQL query statement below
select sd.student_id, sd.student_name, sb.subject_name, count(ex.subject_name) as attended_exams
from Students sd
cross join Subjects sb
left join Examinations ex on sd.student_id = ex.student_id and sb.subject_name = ex.subject_name
group by student_id, subject_name
order by student_id, subject_name
;