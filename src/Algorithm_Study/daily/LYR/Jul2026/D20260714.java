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
    public int solution(int num, int n) {
        if(num % n == 0)
            return 1;
        else
            return 0;
    }
}
