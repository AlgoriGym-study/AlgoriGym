package Algorithm_Study.daily.LYR.Jun2026;

import java.util.ArrayList;
import java.util.List;

public class D20260630 {
    public int solution(String message) {
        int answer = 0;
        answer = message.length() * 2;
        return answer;
    }

    public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();
        for(int num : numlist){
            if(num % n == 0)
                list.add(num);
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public int solution(int n, int t) {
        int answer = n;
        for(int i=1;i<=t;i++){
            answer = answer*2;
        }
        return answer;
    }
}
