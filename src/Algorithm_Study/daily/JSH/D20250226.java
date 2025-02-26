class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        for (int i = 0; i < count; i++) {
            answer += price + price * i;
        }

        if (money > answer) {
            answer = 0;
        } else {
            answer = answer - money;
        }
        return answer;
    }
}