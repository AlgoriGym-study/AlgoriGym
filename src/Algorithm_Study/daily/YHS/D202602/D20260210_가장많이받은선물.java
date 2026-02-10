package Algorithm_Study.daily.YHS.D202602;

import java.util.*;

public class D20260210_가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        int len = friends.length;

        for (int i = 0; i < len; i++) {
            map.put(friends[i], i);
        }

        int[][] table = new int[len][len];

        int[] giftScore = new int[len];

        for (String gift : gifts) {
            String[] name = gift.split(" ");
            String giver = name[0];
            String getter = name[1];

            giftScore[map.get(giver)]++;
            giftScore[map.get(getter)]--;
            table[map.get(giver)][map.get(getter)]++;
        }

        int[] giftCount = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (table[i][j] > table[j][i]) giftCount[i]++;
                else if (table[i][j] == table[j][i]) {
                    if (giftScore[i] > giftScore[j]) giftCount[i]++;
                }

                answer = Math.max(answer, giftCount[i]);
            }
        }

        return answer;
    }
}

