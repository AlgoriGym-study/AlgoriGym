package Algorithm_Study.daily.PJE.D202601;
import java.util.*;

public class D20260119 {
    public int[] solution(int[] fees, String[] records) {
        // 1. 입차 기록을 관리할 Map (차량번호 : 입차시간)
        Map<String, Integer> inMap = new HashMap<>();
        // 2. 누적 주차 시간을 관리할 Map (차량번호 : 누적분) - 차량번호순 정렬을 위해 TreeMap 사용
        Map<String, Integer> totalTimeMap = new TreeMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            int time = getMinutes(split[0]);
            String carNum = split[1];
            String status = split[2];

            if (status.equals("IN")) {
                inMap.put(carNum, time);
            } else {
                int inTime = inMap.remove(carNum);
                int parkedTime = time - inTime;
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkedTime);
            }
        }

        // 3. 출차 기록이 없는 차량 처리 (23:59 출차 간주)
        for (String carNum : inMap.keySet()) {
            int inTime = inMap.get(carNum);
            int parkedTime = getMinutes("23:59") - inTime;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkedTime);
        }

        // 4. 누적 시간을 바탕으로 요금 계산
        int[] answer = new int[totalTimeMap.size()];
        int idx = 0;
        for (int totalTime : totalTimeMap.values()) {
            answer[idx++] = calculateFees(totalTime, fees);
        }

        return answer;
    }

    int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    int calculateFees(int totalTime, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int cutTime = fees[2];
        int cutFee = fees[3];

        if (totalTime <= basicTime) {
            return basicFee;
        } else {
            return basicFee + (int) Math.ceil((double) (totalTime - basicTime) / cutTime) * cutFee;
        }
    }
}
