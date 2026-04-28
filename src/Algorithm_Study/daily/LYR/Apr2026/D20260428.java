package Algorithm_Study.daily.LYR.Apr2026;

public class D20260428 {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int a : array){
            if(height < a)
                answer++;
        }
        return answer;
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int n=1; n<=number; n++){
            int divisor = 0;
            for(int i=1;i<=Math.sqrt(n);i++){
                if(n % i == 0){
                    divisor++;
                    if(i*i != n)
                        divisor++;
                }
            }
            if(divisor <= limit)
                answer += divisor;
            else
                answer += power;
        }
        return answer;
    }
}
