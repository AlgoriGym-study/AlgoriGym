package Algorithm_Study.daily.PJE.D202601;
import java.util.*;

public class D20260112 {
    public int[] solution(int[] fees, String[] records) {
        // 1. 입차 시간 기록할 맵 (차번호, IN 시간)
        Map<String,Integer> inMap = new HashMap<>();        
        // 2. 누적 주차 시간을 기록할 맵(차번호, 누적시간)
        Map<String,Integer> answerMap = new TreeMap<>();
        
        // IN을 만나면 분으로 계산해서 inMap에 넣고 
        // OUT을 만나면 계산해서 answerMap에 넣기
        for(String record : records){
            String[] splitRecord = record.split(" ");
            int time = getMinutes(splitRecord[0]);
            String carNum = splitRecord[1];
            String status = splitRecord[2];
            
            if(status.equals("IN")){
                inMap.put(carNum,time);
            }else{
                // 주차 시간 구하기
               int inTime = inMap.remove(carNum); 
                int duration = time - inTime;
                
                // 기존 누적 시간에 더해주기 
                answerMap.put(carNum, answerMap.getOrDefault(carNum,0)+duration);
            }
            
        }
        
        // 3. 아직 나가지 않은 차 처리 
        int lastTime = getMinutes("23:59");
        for (String carNum : inMap.keySet()) {
            int inTime = inMap.get(carNum);
            int duration = lastTime - inTime;
            answerMap.put(carNum, answerMap.getOrDefault(carNum, 0) + duration);
        }
        
        // 4. 요금 계산 
        // fees 배열: [기본 시간, 기본 요금, 단위 시간, 단위 요금]
        int baseTime = fees[0];
        int baseFare = fees[1];
        int unitTime = fees[2];
        int unitFare = fees[3];
        
        // 결과배열
        int[] answer = new int[answerMap.size()];
        int idx = 0;

        for (int totalTime : answerMap.values()) {
            int fare = baseFare; // 기본 요금으로 시작

            // 추가 요금 계산
            if (totalTime > baseTime) {
                fare += Math.ceil((double)(totalTime - baseTime) / unitTime) * unitFare;
            }

            answer[idx++] = fare;
        }

        return answer;
    }
    
    
    int getMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
}
