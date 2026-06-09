package Algorithm_Study.daily.LYR.Jun2026;

public class D20260609 {
    public int solution(int n, int k) {
        int answer = 0;
        answer = n * 12000 + k * 2000 - n/10 * 2000;
        return answer;
    }

    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        int idx = 0;
        for(int i=num1;i<=num2;i++){
            answer[idx++] = numbers[i];
        }
        return answer;
    }
}
