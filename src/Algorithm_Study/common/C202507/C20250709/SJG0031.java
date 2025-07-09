package Algorithm_Study.common.C202507.C20250709;

import java.util.LinkedList;
import java.util.Queue;

public class SJG0031 {
    static int readytime, recoverySec, recoveryBonus;   // 붕대 정보
    static int hp, currHp;                               // 최대 체력, 현재 체력

    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage, 체력 세팅
        readytime     = bandage[0];
        recoverySec   = bandage[1];
        recoveryBonus = bandage[2];
        hp     = health;
        currHp = health;

        // 공격 스케줄 큐에 담기
        Queue<Integer> atkTime = new LinkedList<>();
        Queue<Integer> atkDam  = new LinkedList<>();
        for (int[] a : attacks) {
            atkTime.offer(a[0]);
            atkDam .offer(a[1]);
        }

        // 시간 변수 분리
        int currTime = 0;  // 시뮬레이션 시간
        int castTime = 0;  // 연속 붕대 감기 시전된 초

        // 시뮬처리
        while (!atkTime.isEmpty()) {
            int nextAtk = atkTime.peek();  // 다음 공격 시각

            // 회복
            while (currTime + 1 < nextAtk) {
                currTime++;

                // 초당 회복
                currHp = Math.min(hp, currHp + recoverySec);

                // 연속 시전 보너스 체크
                if (++castTime == readytime) {
                    currHp = Math.min(hp, currHp + recoveryBonus);
                    castTime = 0;
                }
            }

            // 공격 처리
            currTime = nextAtk;
            atkTime.poll();
            int damage = atkDam.poll();
            currHp -= damage;
            if (currHp <= 0) {
                return -1;
            }
            // 공격받으면 붕대 시전 연속이 끊김
            castTime = 0;
        }

        return currHp;
    }
}
