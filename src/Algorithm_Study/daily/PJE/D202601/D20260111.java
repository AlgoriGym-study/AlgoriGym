package Algorithm_Study.daily.PJE.D202601;
import java.util.*;

public class D20260111 {
    public int solution(int n, int k) {
        int answer = 0;
        // n을 k 진수로 바꾸기
        String num = Integer.toString(n,k);
        // 바꾼후 0을 기준으로 나눠주기
        // 0+로 끊어주면 0이 하나 이상으로 연속된 것을 기준으로 분리함
        String [] arr = num.split("0+");
        
        // 소수의 개수 구하기
        for(String s : arr){
            if(isPrime(Long.parseLong(s)))
                answer++;
        }
        return answer;
    }
    // 소수 찾기
    boolean isPrime(long num){
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0)  return false;
        }   
        return true;
    }
}
