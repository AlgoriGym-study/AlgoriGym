SELECT today, next_day, pm10, next_pm10
FROM (
         SELECT
             measured_at as today,
             LEAD(measured_at) OVER (ORDER BY measured_at) as next_day,
             pm10,
             LEAD(pm10) OVER (ORDER BY measured_at) as next_pm10
         FROM measurements
     ) t
WHERE next_pm10 > pm10