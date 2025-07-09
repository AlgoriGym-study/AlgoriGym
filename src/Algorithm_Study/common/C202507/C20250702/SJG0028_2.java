package Algorithm_Study.common.C202507.C20250702;

import java.util.HashMap;
import java.util.Map;

public class SJG0028_2 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // today를 연, 월, 일로 분리
        String[] todayInfo = today.split("\\.");
        int ty = Integer.parseInt(todayInfo[0]); // 오늘 연도
        int tm = Integer.parseInt(todayInfo[1]); // 오늘 월
        int td = Integer.parseInt(todayInfo[2]); // 오늘 일

        // 약관 종류별 유효기간(개월) 저장
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] ti = term.split(" ");
            map.put(ti[0], Integer.parseInt(ti[1]));
        }

        int n = privacies.length;
        int[] counts = new int[n + 1];  // 만료 여부 플래그 (1: 만료, 0: 유효)
        int idx = 1;  // privacies 인덱스

        // privacies 순회하며 만료일 계산 및 비교
        for (String privacy : privacies) {
            String[] pi = privacy.split(" ");
            // 수집일을 연,월,일로 파싱
            String[] di = pi[0].split("\\.");
            int y = Integer.parseInt(di[0]); // 수집 연도
            int m = Integer.parseInt(di[1]); // 수집 월
            int d = Integer.parseInt(di[2]); // 수집 일

            // 약관 개월 수만큼 월 더하기
            m += map.get(pi[1]);
            // 월이 12 초과하면 연도로 전환
            y += (m - 1) / 12;
            m = (m - 1) % 12 + 1;

            // 보관 마지막 날: 수집일 - 1일
            d -= 1;
            if (d == 0) {
                d = 28;
                m -= 1;
                if (m == 0) {
                    m = 12;
                    y -= 1;
                }
            }

            // 만료일 < 오늘이면 파기 대상
            if (y < ty || (y == ty && (m < tm || (m == tm && d < td)))) {
                counts[idx] = 1;
            }
            idx++;
        }

        // 파기 대상 개수 세기
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (counts[i] == 1) total++;
        }

        // 결과 인덱스 배열 생성
        int[] answer = new int[total];
        idx = 0;
        for (int i = 1; i <= n; i++) {
            if (counts[i] == 1) {
                answer[idx++] = i;
            }
        }
        return answer;
    }
}