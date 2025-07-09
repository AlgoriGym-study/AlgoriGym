package Algorithm_Study.common.C202507.C20250709;

import java.util.*;

class YHS0031 {
    static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int successCount = 0;
        int lastAttack = attacks[attacks.length-1][0];
        int time = 1;
        int answer = 0;
        Map<Integer, Integer> attackInfo = new HashMap<>();

        //contains를 활용하기 위해 map 에 삽입
        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
        }

        while (time <= lastAttack) {
            if (attackInfo.containsKey(time)) {
                health -= attackInfo.get(time);
                if (health <= 0) {
                    answer = -1;
                    return answer;
                }
                successCount = 0;
            } else {
                health += bandage[1];
                successCount++;
                if (successCount == bandage[0]) {
                    health += bandage[2];
                    successCount = 0;
                }

                if (health > maxHealth)
                    health = maxHealth;
            }

            time++;
        }

        answer = health;
        return answer;
    }

    public static void main(String[] args) {
        int[] bandage = {5,1,5};
        int health = 30;
        int[][] attacks = {{2,10},{9,15},{10,5},{11,5}};

        int result = solution(bandage, health, attacks);
        System.out.println(result);
    }
}
