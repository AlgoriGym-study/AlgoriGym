package Algorithm_Study.daily.LYR;

import java.util.StringTokenizer;

public class D20251204 {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num > max)
                max = num;
            if(min > num)
                min = num;
        }
        String answer = min + " " + max;
        return answer;
    }
}
