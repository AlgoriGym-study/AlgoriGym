package Algorithm_Study.common.C202506.C20250618;
import java.util.*;

public class KMR0024 {
    static int n, m;
    static int[] standard = new int[]{10, 20, 30, 40};
    static List<int[]> percents;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0, 0};

        n = users.length;
        m = emoticons.length;
        percents = new ArrayList<int[]>();

        permutation(0, new int[m]); // 할인율 중복 순열

        for (int i = 0; i < percents.size(); i++) {
            int[] percent = percents.get(i);
            int[] newEmoticons = new int[m];

            for(int j = 0; j < m; j++) {
                newEmoticons[j] = emoticons[j] * (100 - percent[j]) / 100;
            }

            int signUp = 0;
            int total = 0;
            int[] price = new int[n]; // 사용자별 구매 금액

            for(int j = 0; j < n; j++) {
                int[] user = users[j];

                for(int k = 0; k < m; k++) {
                    if(percent[k] >= user[0]) {
                        price[j] += newEmoticons[k];
                    }
                } // 이모티콘 할인율 비교

                // 이모티콘 가격 비교: 금액보다 크면 플러스 가입
                if (price[j] >= user[1]) {
                    signUp++;
                    price[j] = 0;
                }

                total += price[j];
            }// 모든 user

            if (answer[0] < signUp) {
                answer[0] = signUp;
                answer[1] = total;
            } else if (answer[0] == signUp && answer[1] < total) {
                answer[1] = total;
            }

        }//모든 할인율 경우의 수

        return answer;
    }

    static void permutation(int pIdx, int[] percent) {
        if(pIdx == m) {
            percents.add(percent.clone());
            return;
        }

        for(int i = 0; i < 4; i++) {
            percent[pIdx] = standard[i];
            permutation(pIdx + 1, percent);
        }

    }// 중복 순열

}
