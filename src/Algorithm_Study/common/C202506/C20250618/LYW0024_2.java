package Algorithm_Study.common.C202506.C20250618;

import java.util.*;

public class LYW0024_2 {
	private int[][] users;
    private int[] emoticons;
    private int[] discount = {10, 20, 30, 40};
    private int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        int[] rates = new int[emoticons.length];

        btr(rates, 0);

        return answer;
    }

    private void btr(int[] rates, int depth) {
        if (depth == rates.length) {
            checkOptimalAnswer(rates);
            return;
        }

        for (int i = 0; i < discount.length; i++) {
            rates[depth] = discount[i];
            btr(rates, depth + 1);
        }
    }

    private void checkOptimalAnswer(int[] rates) {
        int[] result = new int[2];

        for (int i = 0; i < users.length; i++) {
            int totalPurchase = 0;

            for (int j = 0; j < emoticons.length; j++) {
                if (users[i][0] <= rates[j]) {
                    totalPurchase += emoticons[j] * (100 - rates[j]) / 100;
                }
            }

            if (totalPurchase >= users[i][1]) {
                result[0] += 1; // 가입자 수 증가
            } else {
                result[1] += totalPurchase; // 총 구매액 증가
            }
        }

        if (result[0] > answer[0]) {
            answer[0] = result[0];
            answer[1] = result[1];
        }

        if (result[0] == answer[0] && result[1] > answer[1]) {
            answer[0] = result[0];
            answer[1] = result[1];
        }
    }
}

