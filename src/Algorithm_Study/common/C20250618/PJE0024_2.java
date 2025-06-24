package Algorithm_Study.common.C20250618;

import java.util.*;
// 프로그래머스 이모티콘 할인 행사
public class PJE0024_2 {
    int[][] users;
    int[] emoticons;
    int[] discountRates = {10, 20, 30, 40};

    int plusBuyers = 0;
    int totalSum = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        int[] discounts = new int[emoticons.length];
        dfs(0, discounts);

        return new int[]{plusBuyers, totalSum};
    }

    void dfs(int depth, int[] discounts) {
        if (depth == emoticons.length) {
            check(discounts);
            return;
        }

        for (int rate : discountRates) {
            discounts[depth] = rate;
            dfs(depth + 1, discounts);
        }
    }

    void check(int[] discounts) {
        int cnt = 0; // 플러스 가입자 수
        int sum = 0; // 총 이모티콘 판매액

        for (int[] user : users) {
            int discountLimit = user[0]; // 사용자 할인 기준
            int priceLimit = user[1];    // 사용자 플러스 가입 기준

            int userSum = 0; // 해당 사용자의 구매 총액

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= discountLimit) { //구매하는 경우
                    double discountedPrice = emoticons[i] * (1 - discounts[i] / 100.0); 
                    userSum += discountedPrice; //할인된 가격으로 총 구매액 구하기
                }
            }

            if (userSum >= priceLimit) { // 구매 총액이 가입기준을 넘으면
                cnt++; // 플러스 서비스 가입
            } else {
                sum += userSum; // 가입 X, 판매액 누적시키기
            }
        }

        // 조건-> 플러스 가입자 최대로 만들기, 가입자가 같다면 판매액 최대로 만들기
        // 전역변수에 업데이트
        if (cnt > plusBuyers || (cnt == plusBuyers && sum > totalSum)) {
            plusBuyers = cnt;
            totalSum = sum;
        }
    }
}


