package Algorithm_Study.common.C202510.C20251001;

import java.util.*;

public class KMR0048 {

    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);

        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
            min = Math.min(min, list.get(i));
        }
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }

}
