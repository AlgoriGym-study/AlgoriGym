package Algorithm_Study.common.C202507.C20250702;

import java.util.*;

public class LYW0028 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // 약관 유효기간 저장
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }

        // 오늘 날짜를 일수로 변환
        int todayDays = convertToDays(today);

        // 개인정보 순회
        for (int i = 0; i < privacies.length; i++) {
            String[] info = privacies[i].split(" ");
            String date = info[0];
            String type = info[1];

            int startDays = convertToDays(date);
            int validDays = termMap.get(type) * 28;
            int expiryDays = startDays + validDays - 1;

            if (expiryDays < todayDays) {
                result.add(i + 1); // 인덱스는 1부터 시작
            }
        }

        // 리스트를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }

    // 날짜를 총 일수로 변환
    private int convertToDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}
