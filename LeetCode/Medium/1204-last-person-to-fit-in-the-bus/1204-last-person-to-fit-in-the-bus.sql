# Write your MySQL query statement below
SELECT person_name
FROM (
  SELECT person_name,
         (SELECT SUM(weight) FROM Queue q2 WHERE q2.turn <= q1.turn) AS cum_weight,
         turn
  FROM Queue q1
) t
WHERE cum_weight <= 1000
ORDER BY turn DESC
LIMIT 1
;