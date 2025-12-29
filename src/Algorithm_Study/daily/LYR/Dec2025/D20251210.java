package Algorithm_Study.daily.LYR.Dec2025;

public class D20251210 {
    public int solution(int n) {
        int answer = 0;
        for(int i=2;i<n;i++){
            if(n%i == 1){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
