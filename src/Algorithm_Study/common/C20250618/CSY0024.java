package Algorithm_Study.common.C20250618;

import java.util.*;

public class CSY0024 {
    int[] discountRates = {10, 20, 30, 40}; // 이모티콘 할인율
    int maxSubscribers = 0;
    int maxRevenue = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length]; // 각 이모티콘에 대한 할인율 조합 저장
        dfs(0, discounts, users, emoticons); // 모든 할인율 조합 탐색
        return new int[]{maxSubscribers, maxRevenue};
    }

    // 할인율 조합 완전탐색(재귀)
    private void dfs(int depth, int[] discounts, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) { // 이모티콘 수대로 다 보면
            evaluate(discounts, users, emoticons); // 계산
            return;
        }

        for (int rate : discountRates) {
            discounts[depth] = rate; // 각 이모티콘 별로 4개의 할인율 적용한 것을 dfs로 탐색
            dfs(depth + 1, discounts, users, emoticons);
        }
    }

    // 현재 할인율 조합에 대한 가입자 수와 매출 계산
    private void evaluate(int[] discounts, int[][] users, int[] emoticons) {
        int subscriberCount = 0;
        int revenue = 0;

        for (int[] user : users) {
            int userDiscountThreshold = user[0]; // 최소 할인율 조건
            int userSpendingLimit = user[1];     // 구독 전환 기준
            int totalSpent = 0;

            for (int i = 0; i < emoticons.length; i++) {
                int rate = discounts[i];
                if (rate >= userDiscountThreshold) {
                    totalSpent += emoticons[i] * (100 - rate) / 100;
                }
            }

            if (totalSpent >= userSpendingLimit) {
                subscriberCount++;
            } else {
                revenue += totalSpent;
            }
        }

        // 조건에 맞게 최대 가입자 수, 최대 매출 갱신
        if (subscriberCount > maxSubscribers) {
            maxSubscribers = subscriberCount;
            maxRevenue = revenue;
        } else if (subscriberCount == maxSubscribers) {
            maxRevenue = Math.max(maxRevenue, revenue);
        }
    }
}

