# Write your MySQL query statement below
with ranked_employees as
(
    select *
        , rank() over (partition by departmentId order by salary desc) as r
    from employee
)
select d.name as Department
    , re.name as Employee
    , re.salary
from ranked_employees as re
inner join department d on (re.departmentId=d.id)
where r=1