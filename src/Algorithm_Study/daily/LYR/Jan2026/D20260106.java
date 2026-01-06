package Algorithm_Study.daily.LYR.Jan2026;

public class D20260106 {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Long.toString(n,k);
        String[] numList = s.split("0");
        for(String num : numList){
            if(num.length() == 0)
                continue;
            if(isPrime(Long.parseLong(num)))
                answer++;
        }
        return answer;
    }

    private boolean isPrime(long n){
        if(n == 1)
            return false;
        long nsqrt = (long)Math.sqrt(n);
        for(long i=2;i<=nsqrt;i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
