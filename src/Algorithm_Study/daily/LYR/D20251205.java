package Algorithm_Study.daily.LYR;

public class D20251205 {
    public double solution(int[] arr) {
        double answer = 0;
        double sum = 0;
        for(int a : arr){
            sum += a;
        }
        answer = sum / arr.length;
        return answer;
    }
}
