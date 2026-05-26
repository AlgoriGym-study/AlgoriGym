package Algorithm_Study.daily.KMR;

public class D20260526_PRO_삼총사_Lv1 {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    int result = number[i] + number[j] + number[k];
                    if (result == 0) answer++;
                }
            }
        }

        return answer;
    }
}
