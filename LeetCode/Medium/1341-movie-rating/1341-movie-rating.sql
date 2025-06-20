# Write your MySQL query statement below
(select name as results
 from Users
 left join MovieRating using(user_id)
 group by user_id
 order by count(rating) desc, name
 limit 1)
union all
(select title as results
 from Movies
 join MovieRating using(movie_id)
 where created_at between '2020-02-01' and '2020-02-29'
 group by movie_id
 order by avg(rating) desc, title
 limit 1)
;