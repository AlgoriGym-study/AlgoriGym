package Algorithm_Study.daily.CSY.April;

public class D20250423_부족한금액계산하기 {

    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(int i = 1; i <= count; i++){
            sum += price * i;
        }

        answer = (sum > money) ? sum - money : 0;

        return answer;
    }
}
