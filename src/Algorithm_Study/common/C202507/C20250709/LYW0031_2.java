package Algorithm_Study.common.C202507.C20250709;

public class LYW0031_2 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량

        int maxHealth = health; // 최대 체력
        int currentHealth = health;
        int continuous = 0; // 연속 성공 시간
        int time = 0; // 현재 시간
        int attackIndex = 0;

        int lastAttackTime = attacks[attacks.length - 1][0];

        for (time = 1; time <= lastAttackTime; time++) {
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                currentHealth -= attacks[attackIndex][1]; 
                if (currentHealth <= 0) return -1; 
                continuous = 0; 
                attackIndex++; 
            } else {
                currentHealth += x;
                continuous++;

                if (continuous == t) {
                    currentHealth += y;
                    continuous = 0;
                }

                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
        }

        return currentHealth;
    }
}
