package Algorithm_Study.daily.LYR;

public class D20251203 {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(i%2==0)
                answer += i;
        }
        return answer;
    }
}
