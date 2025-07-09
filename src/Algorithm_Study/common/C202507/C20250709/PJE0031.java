package Algorithm_Study.common.C202507.C20250709;

//프로그래머스 붕대 감기
class PJE0031 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량

        int maxHealth = health; // 최대 체력 (초기 체력 = 최대 체력)
        int currentHealth = health;
        int continuous = 0; // 연속 성공 시간
        int time = 0; // 현재 시간
        int attackIndex = 0;

        // 마지막 공격 시간
        int lastAttackTime = attacks[attacks.length - 1][0];

        // 1초부터 마지막 공격 시간까지 시뮬레이션
        for (time = 1; time <= lastAttackTime; time++) {
            // 공격이 있는 시간인 경우
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                currentHealth -= attacks[attackIndex][1]; // 공격 피해 적용
                if (currentHealth <= 0) return -1; // 캐릭터 사망 시 -1 리턴
                continuous = 0; // 연속 회복 초기화
                attackIndex++; // 다음 공격으로
            } else {
                // 회복
                currentHealth += x;
                continuous++;

                // 연속 성공 시간 충족 시 추가 회복
                if (continuous == t) {
                    currentHealth += y;
                    continuous = 0;
                }

                // 체력이 최대 체력을 넘지 않도록 조정
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
        }

        return currentHealth;
    }
}
