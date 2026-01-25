WITH sub AS (
    SELECT category, sub_category, SUM(sales) AS sales_sub_category
    FROM records
    GROUP BY category, sub_category
),
     base AS (
         SELECT category, sub_category, sales_sub_category,
                SUM(sales_sub_category) OVER (PARTITION BY category) AS sales_category,
             SUM(sales_sub_category) OVER () AS sales_total
         FROM sub
     )
SELECT
    category,
    sub_category,
    ROUND(sales_sub_category, 2) as sales_sub_category,
    ROUND(sales_category, 2) as sales_category,
    ROUND(sales_total, 2) as sales_total,
    ROUND(100 * sales_sub_category / sales_category, 2) AS pct_in_category,
    ROUND(100 * sales_sub_category / sales_total, 2) AS pct_in_total
FROM base