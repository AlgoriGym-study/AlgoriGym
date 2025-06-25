package Algorithm_Study.common.C202506.C20250618;

import java.util.*;

public class LYW0024 {
    static int[] saleRates = {10, 20, 30, 40}; // 가능한 할인율
    static int maxSubscriber = 0;
    static int maxRevenue = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];
        dfs(0, users, emoticons, discounts);

        return new int[]{maxSubscriber, maxRevenue};
    }

    // 이모티콘마다 할인율을 설정하는 DFS
    void dfs(int depth, int[][] users, int[] emoticons, int[] discounts) {
        if (depth == emoticons.length) {
            evaluate(users, emoticons, discounts);
            return;
        }

        for (int rate : saleRates) {
            discounts[depth] = rate;
            dfs(depth + 1, users, emoticons, discounts);
        }
    }

    // 현재 할인율 조합에 따라 사용자들의 반응을 평가
    void evaluate(int[][] users, int[] emoticons, int[] discounts) {
        int subscriberCount = 0;
        int totalRevenue = 0;

        for (int[] user : users) {
            int minDiscount = user[0];
            int limitPrice = user[1];
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= minDiscount) {
                    int discountedPrice = emoticons[i] * (100 - discounts[i]) / 100;
                    sum += discountedPrice;
                }
            }

            if (sum >= limitPrice) {
                subscriberCount++;
            } else {
                totalRevenue += sum;
            }
        }

        if (subscriberCount > maxSubscriber || 
           (subscriberCount == maxSubscriber && totalRevenue > maxRevenue)) {
            maxSubscriber = subscriberCount;
            maxRevenue = totalRevenue;
        }
    }
}

