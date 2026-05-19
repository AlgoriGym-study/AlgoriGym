package Algorithm_Study.daily.LYR.May2026;

public class D20250519 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            answer += n/a*b;
            n = n - (n/a)*a + (n/a)*b;
        }
        return answer;
    }
}
