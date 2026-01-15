package Algorithm_Study.daily.YHS.D202601;

import java.util.*;

public class D20260113_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        // 차량 입차 시간을 저장하는 Map (현재 주차 중인 차량)
        Map<String, Integer> inMap = new HashMap<>();
        // 차량별 누적 주차 시간을 저장하는 Map
        Map<String, Integer> accMap = new HashMap<>();

        // 주차 기록 순회
        for (String record : records) {
            // 공백 기준으로 시간, 차량번호, 입/출차 상태 분리
            String[] s = record.split("\\s+");
            // 시간을 "분" 단위로 변환
            int m = toMinutes(s[0]);
            String car = s[1];
            String io = s[2];

            // 입차(IN)인 경우 -> 입차 시각 기록
            if (io.equals("IN")) {
                inMap.put(car, m);
                // 출차(OUT)인 경우 -> 누적 주차 시간 계산 후 제거
            } else {
                // Map에서 제거하면서 입차 시각 변환
                int min = inMap.remove(car);
                // (출차 시각 - 입차 시각)을 누적 주차 시간에 더함
                accMap.put(car, accMap.getOrDefault(car, 0) + (m - min));
            }
        }

        // 출차하지 않은 차량 처리 (23:59 기준으로 정산)
        for (Map.Entry<String, Integer> e : inMap.entrySet()) {
            String car = e.getKey();
            int in = e.getValue();
            // 23:59(=1439분)까지 주차한 것으로 계산
            accMap.put(car, accMap.getOrDefault(car, 0) + (1439 - in));
        }

        // 차량 번호 기준 오름차순 정렬
        List<String> cars = new ArrayList<>(accMap.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];

        // 각 차량별 최종 요금 계산
        for (int i = 0; i < cars.size(); i++) {
            // 총 주차 시간(분)
            int minutes = accMap.get(cars.get(i));

            // 기본 시간 이하라면 기본 요금만 부과
            if (minutes <= fees[0]) {
                answer[i] = fees[1];
                continue;
            }

            // 초과한 시간 계산
            int extra = minutes - fees[0];
            // 단위 시간
            int unitT = fees[2];
            // 단위 요금
            int unitC = fees[3];

            // 추가 단위 계산
            // ex) 단위시간 10분, 초과시간 11분 -> (11 + 10 - 1) / 10 = 2단위
            int units = (extra + unitT - 1) / unitT;
            // 총 요금 = 기본 요금 + (단위 요금 * 단위수)
            int total = fees[1] + units * unitC;

            answer[i] = total;
        }

        // 차량번호 오름차순으로 계산된 요금 배열 반환
        return answer;
    }

    // "HH:MM" 형태의 시간을 "분" 단위로 변환하는 메서드
    private int toMinutes(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);

        return hour * 60 + minute;
    }
}
