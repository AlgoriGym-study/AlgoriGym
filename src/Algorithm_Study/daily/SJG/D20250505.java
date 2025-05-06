package Algorithm_Study.daily.SJG;

import java.util.StringTokenizer;

public class D20250505 {
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
