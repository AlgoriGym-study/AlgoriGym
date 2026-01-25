SELECT name
FROM records r
         JOIN athletes a ON a.id = r.athlete_id
         JOIN games g ON g.id = r.game_id
WHERE medal IS NOT NULL
          AND year >= 2000
GROUP BY a.id
HAVING COUNT(DISTINCT team_id) >= 2
ORDER BY name