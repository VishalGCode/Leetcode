# Write your MySQL query statement below
with ranked_sales as
(
    select *
        , rank() over (partition by product_id order by year asc) as r
    from sales
)
select product_id
    , year as first_year
    , quantity
    , price
from ranked_sales
where r=1