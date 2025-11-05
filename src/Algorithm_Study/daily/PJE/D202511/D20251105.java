package Algorithm_Study.daily.PJE.D202511;
import java.util.*;

// 프로그래머스 유연근무제
public class D20251105 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        //schedules : i+1 직원이 설정한 출근 희망 시각  
        //timelogs : i+1 직원이 j+1일차에 출근한 시각
        //startday : 1 월, 2 화 ... 에 시작했음
      
        int answer = 0;

        for(int i = 0; i < timelogs.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            int day = startday;

            // 1) 요일-출근시간 매핑 저장
            for(int j = 0; j < timelogs[i].length; j++){
                if(day > 7) day = day % 7 == 0 ? 1 : day % 7; // 1~7 순환
                map.put(day, timelogs[i][j]);
                day++;
            }

            // 2) 비교 기준 시간 (희망출근 + 10분)
            int limit = toMin(schedules[i]) + 10;

            // 3) 평일(1~5)만 검사
            boolean ok = true;
            for(int d = 1; d <= 5; d++){
                int logTime = map.getOrDefault(d, -1); 
                if(logTime == -1) continue; // 데이터 없으면 넘김 (일부 테스트 케이스 대비)

                int logMin = toMin(logTime);
                if(logMin > limit) { // 하루라도 지각 → 탈락
                    ok = false;
                    break;
                }
            }

            if(ok) answer++;
        }

        return answer;
    }

    // HHMM → 분 변환
    private int toMin(int time){
        return (time / 100) * 60 + (time % 100);
    }
}
