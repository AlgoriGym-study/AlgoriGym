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
}
