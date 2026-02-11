package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2026_02_10 {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 1) 이름 -> 인덱스
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(friends[i], i);

        // 2) give[i][j] = i가 j에게 준 횟수
        int[][] give = new int[n][n];

        // 3) 준 총합 / 받은 총합
        int[] given = new int[n];
        int[] received = new int[n];

        for (String g : gifts) {
            int sp = g.indexOf(' ');
            String a = g.substring(0, sp);
            String b = g.substring(sp + 1);

            int from = map.get(a);
            int to = map.get(b);

            give[from][to]++;
            given[from]++;
            received[to]++;
        }

        // 선물 지수
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = given[i] - received[i];
        }

        // 4) 다음 달에 받을 선물 수
        int[] nextReceive = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ij = give[i][j];
                int ji = give[j][i];

                if (ij > ji) {
                    nextReceive[i]++;
                } else if (ji > ij) {
                    nextReceive[j]++;
                } else {
                    // 주고받은 기록이 없거나(둘다 0 포함) / 횟수 같으면 선물지수 비교
                    if (score[i] > score[j]) nextReceive[i]++;
                    else if (score[j] > score[i]) nextReceive[j]++;
                    // 같으면 아무도 증가 X
                }
            }
        }

        int ans = 0;
        for (int v : nextReceive) ans = Math.max(ans, v);
        return ans;
    }
}
