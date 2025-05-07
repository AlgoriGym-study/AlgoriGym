package Algorithm_Study.daily.CSY.May;

import java.util.Arrays;

public class D20250507_피보나치수 {
    public static void main(String[] args) {

    }
    static int[] memo;

    public int solution(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        int answer = fibo(n) % 1234567;
        return answer;
    }

    public int fibo(int n){
        if(memo[n] == -1){
            memo[n] = (fibo(n-2) + fibo(n-1)) % 1234567;
        }
        return memo[n];
    }
}
