# Write your MySQL query statement below
select round(count(distinct case when a.event_date = aj.first_join + interval 1 day then a.player_id end)  / count(distinct a.player_id), 2) as fraction
from Activity a
left join (select player_id, min(event_date) as first_join from Activity group by player_id) aj
on a.player_id = aj.player_id
;