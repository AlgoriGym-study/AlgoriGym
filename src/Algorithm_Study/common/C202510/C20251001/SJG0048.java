package Algorithm_Study.common.C202510.C20251001;

import java.util.StringTokenizer;

public class SJG0048 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            if (val < min) min = val;
            if (val > max) max = val;
        }
        return min + " " + max;
    }
}
