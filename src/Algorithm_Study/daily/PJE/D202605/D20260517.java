package Algorithm_Study.daily.PJE.D202605;
public class D20260517 {
    public int solution(int n) {
        // n번째가지 필요하므로 크기 n+1로 저장
        int [] dp = new int [n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i<= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}
