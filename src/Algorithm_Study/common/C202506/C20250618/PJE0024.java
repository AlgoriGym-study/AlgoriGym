package Algorithm_Study.common.C202506.C20250618;
import java.util.*;

// 프로그래머스 이모티콘 할인행사
class PJE0024 {
    int[][] users;
    int[] emoticons;

    int[] discountRates = {10, 20, 30, 40};

    int maxPlusBuyers = 0;
    int maxTotalSum = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        int[] discounts = new int[emoticons.length];
        dfs(0, discounts);
		int [] answer = new int[]{maxPlusBuyers,maxTotalSum};
        return answer;
    }

    private void dfs(int depth, int[] discounts) {
        if (depth == emoticons.length) { // 이모티콘 갯수만큼 할인율이 정해졌으면
            int plusBuyers = 0;
            int totalSum = 0;
			// 확인 시작
            for (int[] user : users) {
                int userDiscount = user[0]; // 한명당 할인 제한(반드시 넘겨야 구매) 
                int userLimit = user[1]; // 한명당 예산(넘기면 플러스 구매)

                double userSum = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i] >= userDiscount) {
                        userSum += emoticons[i] * (1 - discounts[i] / 100.0);
                    }
                }

                if (userSum >= userLimit) {
                    plusBuyers++;
                } else {
                    totalSum += (int) userSum;
                }
            }
 // 전역 변수 업데이트
            if (plusBuyers > maxPlusBuyers) {
                maxPlusBuyers = plusBuyers;
                maxTotalSum = totalSum;
            } else if (plusBuyers == maxPlusBuyers && totalSum > maxTotalSum) {
                maxTotalSum = totalSum;
            }

            return;
        }

        for (int rate : discountRates) {
            discounts[depth] = rate;
            dfs(depth + 1, discounts);
        }
    }
}
