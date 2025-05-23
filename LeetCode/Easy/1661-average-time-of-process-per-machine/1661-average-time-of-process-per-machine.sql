# Write your MySQL query statement below
with process_times as (select machine_id,
                              process_id,
                              max(case when activity_type = 'end' then timestamp end) -
                              max(case when activity_type = 'start' then timestamp end) as duration_seconds
                       from Activity
                       group by machine_id, process_id)

select machine_id, round(avg(duration_seconds), 3) as processing_time
from process_times
group by machine_id
;