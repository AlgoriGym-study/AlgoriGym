package Algorithm_Study.daily.LYR.Jan2026;

public class D20260122 {
    public int solution(int num) {
        long number = (long) num;
        int answer = 0;
        if(number == 1)
            return 0;
        while(true){
            if(number % 2 == 0){
                number /= 2;
            } else {
                number *= 3;
                number += 1;
            }
            answer++;
            if(number == 1)
                return answer;
            if(answer >= 500)
                return -1;
        }
    }
}
