package Algorithm_Study.daily.LYR.Feb2026;

import java.util.Arrays;

public class D20260206 {
    public String solution(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr);
        String answer = "";
        for(int i=arr.length-1;i>=0;i--){
            answer += arr[i];
        }
        return answer;
    }

    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for(int i=1;i<=count;i++){
            sum += i * price;
        }
        answer = sum - money;
        if(answer <= 0)
            return 0;
        return answer;
    }
}
