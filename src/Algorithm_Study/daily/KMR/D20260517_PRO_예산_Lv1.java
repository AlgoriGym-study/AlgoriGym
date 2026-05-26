package Algorithm_Study.daily.KMR;

import java.util.*;

public class D20260517_PRO_예산_Lv1 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < d.length; i++) {
            list.add(d[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < d.length; i++) {
            if (answer + list.get(i) > budget) break;
            answer += list.get(i);
            result++;
        }
        return result;
    }
}
