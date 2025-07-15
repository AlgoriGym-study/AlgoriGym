package Algorithm_Study.common.C202507.C20250709;

public class KMR0031_2 {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int t = bandage[0];
            int x = bandage[1];
            int y = bandage[2];

            int now = 1;
            int nhealth = health;

            for (int i = 0; i < attacks.length; i++) {
                int attackTime = attacks[i][0];
                int damage = attacks[i][1];

                int dt = attacks[i][0] - now;
                nhealth += x * dt + y * (dt / t); // 회복

                if(nhealth > health) nhealth = health;

                nhealth -= damage;

                now = attackTime + 1;

                if(nhealth <= 0) {
                    return -1;
                }
            }

            return nhealth;
        }
    }
}
