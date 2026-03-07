package Algorithm_Study.daily.LYR.Mar2026;

import java.util.Arrays;

public class D20260304 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int money : d){
            if(money <= budget){
                answer++;
                budget -= money;
            }
        }
        return answer;
    }
}
