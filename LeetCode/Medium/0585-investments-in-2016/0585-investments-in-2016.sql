# Write your MySQL query statement below
select round(sum(tiv_2016), 2) as tiv_2016
from Insurance i
join (
    select tiv_2015
    from Insurance
    group by tiv_2015
    having count(*) > 1
) it
on i.tiv_2015 = it.tiv_2015
join (
    select lat, lon
    from Insurance
    group by lat, lon
    having count(*) = 1
) il
on i.lat = il.lat and i.lon = il.lon
;