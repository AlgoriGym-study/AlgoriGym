package Algorithm_Study.common.C202507.C20250702;

import java.util.*;

public class KMR0028_2 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            map.put(terms[i].substring(0, 1), Integer.valueOf(terms[i].substring(2)));
        }// 유효기간 저장

        int limit = Integer.parseInt(today.substring(0, 4) +today.substring(4, 6) +today.substring(6, 8));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String p = privacies[i];
            int date = Integer.parseInt(p.substring(0, 4)) * 10000
                    + Integer.parseInt(p.substring(5, 7)) * 100
                    + Integer.parseInt(p.substring(8, 10))
                    - 1;
            date += 100 * map.get(p.substring(11));
            if(date - limit > 0) continue;
            list.add(i + 1);
        }

        int size = list.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
