package Algorithm_Study.daily.KMR;

import java.util.*;

public class D20260517_PRO_기능개발_Lv2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            day[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day[i]++;
            }
        }

        int before = day[0];
        int count = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < day.length; i++) {
            if (before < day[i]) {
                list.add(count);
                count = 1;
                before = day[i];
            } else {
                count++;
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
