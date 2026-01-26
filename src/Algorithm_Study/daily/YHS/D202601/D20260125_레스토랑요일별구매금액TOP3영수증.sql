SELECT day, time, sex, total_bill
FROM (
    SELECT *,
    ROW_NUMBER() OVER (PARTITION BY day ORDER BY total_bill DESC) rnk
    FROM tips
    ) t
WHERE rnk <= 3

