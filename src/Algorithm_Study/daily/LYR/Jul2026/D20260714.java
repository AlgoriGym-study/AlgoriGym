package Algorithm_Study.daily.LYR.Jul2026;

public class D20260714 {
    public int solution(int a, int b, boolean flag) {
        int answer = 0;
        if(flag)
            answer = a + b;
        else
            answer = a - b;
        return answer;
    }
}
