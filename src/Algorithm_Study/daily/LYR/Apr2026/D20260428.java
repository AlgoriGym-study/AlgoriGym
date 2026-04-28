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
}
