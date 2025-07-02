package Algorithm_Study.common.C202507.C20250702;

import java.util.*;

public class CSY0028 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();

        // 오늘 날짜 totalDays로 변환
        int todayTotal = change(today);

        // 약관 종류와 기간 저장
        Map<String, Integer> termMap = new HashMap<>(); // A = 6
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }

        // 개인정보마다 계산
        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            String date = p[0];
            String term = p[1];

            int startTotal = change(date);
            int termMonth = termMap.get(term);
            int expiredTotal = startTotal + (termMonth * 28) - 1;

            if (expiredTotal < todayTotal) {
                answerList.add(i + 1); // 해당 개인정보 인덱스 추가
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray(); // 리스트에서 배열로 반환
    }

    private int change(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}
