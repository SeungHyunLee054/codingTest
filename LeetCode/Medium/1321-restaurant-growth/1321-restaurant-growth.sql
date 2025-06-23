# Write your MySQL query statement below
with daily_totals as (
    select
     visited_on,
     sum(amount) as daily_total
    from Customer
    group by visited_on
),
moving_data as (
    select
     visited_on,
     sum(daily_total) over (
        order by visited_on
        rows between 6 preceding and current row
     ) as total_amount,
     row_number() over (order by visited_on) as rn
    from daily_totals
)
select visited_on, total_amount as amount, round(total_amount / 7.0, 2) as average_amount
from moving_data
where rn >= 7
order by visited_on
;