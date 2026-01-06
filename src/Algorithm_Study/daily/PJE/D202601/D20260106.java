package Algorithm_Study.daily.PJE.D202601;
import java.util.*;

public class D20260106 {
    public int solution(int n, int k) {
        int answer = 0;
        
        // n을 k진수로 바꾸기 
        String changed = Integer.toString(n, k); 
        
        // 0 기준으로 나누기
        String[] parts = changed.split("0");
        
        for (String s : parts) {
            if (s.equals("")) continue;
            
            // 숫자 롱으로 바꾸기
            long num = Long.parseLong(s);
            
            // 그 숫자가 소수인지 확인하기 & 소수면 cnt
            if (isPrime(num)) {
                answer++;
            }
        }
        
        // 리턴하기
        return answer;
    }
  
    // 소수 판별
    public boolean isPrime(long n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
