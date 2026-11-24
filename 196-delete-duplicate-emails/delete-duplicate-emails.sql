# Write your MySQL query statement below
with ranked_person as
(
    select *
        , dense_rank() over (partition by email order by id) as dr
    from Person
)
DELETE from Person
where id in (select id from ranked_person where dr>1)