-- 프로그래머스 월별 잡은 물고기 수 구하기
select 
count(*) as FISH_COUNT,
month(TIME) as MONTH
from
FISH_INFO
group by
MONTH
order by
MONTH ASC
