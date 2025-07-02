package Algorithm_Study.common.C202507.C20250702;

import java.util.*;

// 개인정보 수집 유효기간
public class KMR0028 {
    static Map<String, Integer> term;
    static int todayDate;

    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. privacies -> 만료날짜 계산하기 : 유효기간 더하기 & 1일 빼기
        // 2. today와 비교하여 유효하지 않은 것

        // terms -> Map에 저장하기
        term = new HashMap<String, Integer>();
        for (String str : terms) {
            String unit = str.substring(0, 1);
            int time = Integer.parseInt(str.substring(2));
            term.put(unit, time);
        }

        int year = Integer.parseInt(today.substring(0, 4));
        int month = Integer.parseInt(today.substring(5, 7));
        int day = Integer.parseInt(today.substring(8, 10));

        todayDate = year * 10000 + month * 100 + day;

        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (String privacy : privacies) {
            count++;
            boolean trash = calculate(
                    Integer.parseInt(privacy.substring(0, 4)),
                    Integer.parseInt(privacy.substring(5, 7)),
                    Integer.parseInt(privacy.substring(8, 10)),
                    privacy.substring(11)
            );
            if (trash) {
                result.add(count);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    // 만료날짜 더하기: terms + privacies
    static boolean calculate(int year, int month, int day, String termUnit) {
        day--;
        if (day == 0) {
            month--;
            day = 28;
        }

        month += term.get(termUnit);
        while (month > 12) {
            month -= 12;
            year++;
        }
        int total = year * 10000 + month * 100 + day;

        int result = todayDate - total;
        if (result > 0) return true;
        else return false;
    }
}
