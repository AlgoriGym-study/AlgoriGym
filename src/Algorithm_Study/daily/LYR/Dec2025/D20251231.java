package Algorithm_Study.daily.LYR.Dec2025;

public class D20251231 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0;i<n;i++){
            if(i==0)
                answer[i] = x;
            else
                answer[i] = answer[i-1] + x;
        }
        return answer;
    }
}
