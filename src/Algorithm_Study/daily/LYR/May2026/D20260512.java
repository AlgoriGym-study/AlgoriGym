package Algorithm_Study.daily.LYR.May2026;

public class D20260512 {
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        for(int n : numbers){
            sum += n;
        }
        answer = sum / numbers.length;
        return answer;
    }

    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money / 5500;
        answer[1] = money % 5500;
        return answer;
    }
}
