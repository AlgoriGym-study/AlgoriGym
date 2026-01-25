WITH user_events AS (
    SELECT
        user_pseudo_id,
        event_timestamp_kst,
        LAG(event_timestamp_kst) OVER (PARTITION BY user_pseudo_id ORDER BY event_timestamp_kst) AS prev_event_timestamp
    FROM ga
    WHERE user_pseudo_id = 'S3WDQCqLpK'
),
     marked_sessions AS (
         SELECT
             user_pseudo_id,
             event_timestamp_kst,
             CASE
                 WHEN prev_event_timestamp IS NULL OR event_timestamp_kst >= prev_event_timestamp + INTERVAL 1 HOUR
    THEN 1 ELSE 0
END AS new_session
    FROM user_events
),
session_groups AS (
    SELECT
        user_pseudo_id,
        event_timestamp_kst,
        SUM(new_session) OVER (PARTITION BY user_pseudo_id ORDER BY event_timestamp_kst) AS session_id
    FROM marked_sessions
)
SELECT
    user_pseudo_id,
    MIN(event_timestamp_kst) AS session_start,
    MAX(event_timestamp_kst) AS session_end
FROM session_groups
GROUP BY user_pseudo_id, session_id
ORDER BY session_start;