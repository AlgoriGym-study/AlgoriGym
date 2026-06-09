package Algorithm_Study.daily.LYR.Jun2026;

public class D20260609 {
    public int solution(int n, int k) {
        int answer = 0;
        answer = n * 12000 + k * 2000 - n/10 * 2000;
        return answer;
    }
}
