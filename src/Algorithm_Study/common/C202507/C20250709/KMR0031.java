package Algorithm_Study.common.C202507.C20250709;

public class KMR0031 {
    static int t, x, y;
    static int health; // 최대 체력

    public int solution(int[] bandage, int health, int[][] attacks) {
        t = bandage[0]; //회복기술 시간 -> 이상 넘으면 y를 추가
        x = bandage[1]; // 초당 회복량
        y = bandage[2]; // 추가 회복량
        this.health = health; // 최대 체력

        int len = attacks.length;
        int count = 0;
        int curHealth = health;
        int now = 0;

        while (count < len && curHealth > 0) {
            int time = attacks[count][0];
            int damage = attacks[count][1];

            // 회복
            curHealth = cure(curHealth, time - now - 1);

            // 공격
            curHealth = attack(curHealth, damage);
            now = time;

            count++;
        }

        return curHealth;
    }

    private static int cure(int curHealth, int dt) {
        if (dt < t) {
            int newHealth = curHealth + dt * x;
            if (newHealth < health) {
                return newHealth;
            }
            return health;
        }
        //dt >= t
        int newHealth = curHealth + dt * x + y * (dt / t);
        if (newHealth < health) return newHealth;
        return health;

    }

    private static int attack(int curHealth, int damage) {
        curHealth -= damage;
        if(curHealth > 0) return curHealth;
        return -1;
    }
}
