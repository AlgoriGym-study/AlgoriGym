package Algorithm_Study.daily.KMR;

public class D20260607_PRO_기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
            }
            if (limit < count) answer += power;
            else answer += count;
        }

        return answer;
    }
}
