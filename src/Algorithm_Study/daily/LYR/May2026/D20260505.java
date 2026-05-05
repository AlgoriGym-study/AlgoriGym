package Algorithm_Study.daily.LYR.May2026;

public class D20260505 {
    public int solution(int num1, int num2) {
        int answer = num1 + num2;
        return answer;
    }

    public int solution(int n) {
        int answer = 0;
        if(n % 7 == 0)
            answer = n/7;
        else
            answer = n/7 + 1;
        return answer;
    }
}
