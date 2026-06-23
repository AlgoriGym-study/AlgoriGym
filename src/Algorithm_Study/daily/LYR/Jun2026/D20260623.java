package Algorithm_Study.daily.LYR.Jun2026;

public class D20260623 {
    public int[] solution(int n) {
        int size = 0;
        if(n % 2 == 1)
            size = n/2 + 1;
        else
            size = n/2;
        int[] answer = new int[size];
        int idx = 0;
        for(int i=1;i<=n;i++){
            if(i % 2 == 1)
                answer[idx++] = i;
        }
        return answer;
    }
}
