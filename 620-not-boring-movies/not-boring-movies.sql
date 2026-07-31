# Write your MySQL query statement below
SELECT *
FROM Cinema
WHERE id%2 !=0 and description != "boring" and description is not null order by rating desc;