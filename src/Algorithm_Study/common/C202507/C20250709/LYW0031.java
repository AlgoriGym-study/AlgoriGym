package Algorithm_Study.common.C202507.C20250709;

public class LYW0031 {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int t = bandage[0];   // 연속 시전 시간
        int x = bandage[1];   // 1초당 회복량
        int y = bandage[2];   // t초 성공 시 추가 회복량

        int hp = health;                 // 현재 체력
        int combo = 0;                   // 연속 시전 시간
        int atkIdx = 0;                  // attacks 배열 인덱스
        int lastTime = attacks[attacks.length - 1][0];  // 마지막 공격 시각

        // 1초씩 진행(게임 시간은 1초부터)
        for (int time = 1; time <= lastTime; time++) {

            // 1. 이번 초에 몬스터가 공격하면
            if (atkIdx < attacks.length && attacks[atkIdx][0] == time) {
                hp -= attacks[atkIdx][1];   // 피해 입음
                if (hp <= 0) return -1;     // 사망
                combo = 0;                  // 연속 시전 초기화
                atkIdx++;                   // 다음 공격으로 이동
            }
            // 2. 공격이 없으면 붕대 감기 진행
            else {
                combo++;        // 1초 성공
                hp += x;        // 초당 회복

                if (combo == t) { // t초 연속 성공
                    hp += y;     // 추가 회복
                    combo = 0;   // 연속 시전 초기화
                }

                if (hp > health) hp = health; // 최대 체력 초과 방지
            }
        }

        return hp;  // 모든 공격 직후 남은 체력
    }
}
