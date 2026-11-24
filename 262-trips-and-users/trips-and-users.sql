WITH unbanned_user_trips AS (
    SELECT t.*
    FROM Trips t
    INNER JOIN Users c
        ON t.client_id = c.users_id
        AND c.banned = 'No'
        AND c.role = 'client'
    INNER JOIN Users d
        ON t.driver_id = d.users_id
        AND d.banned = 'No'
        AND d.role = 'driver'
)
SELECT
    request_at AS Day,
    ROUND(
        SUM(IF(status = 'cancelled_by_driver' OR status = 'cancelled_by_client', 1, 0)) / COUNT(*),
        2
    ) AS "Cancellation Rate"
FROM unbanned_user_trips
WHERE request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY request_at;