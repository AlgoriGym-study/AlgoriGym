package Algorithm_Study.common.C202507.C20250709;

public class SJG00031_2 {
    static int readytime, recoverySec, recoveryBonus;
    static int hp, currHp;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        readytime = bandage[0];
        recoverySec = bandage[1]; 
        recoveryBonus = bandage[2];
        hp = currHp = health;
        
        int currTime = 0;
        int castTime = 0;
        int atkIdx = 0;
        
        while (atkIdx < attacks.length) {
            int nextAtk = attacks[atkIdx][0];
            
            // 회복 구간 계산
            int recoveryTime = nextAtk - currTime - 1;
            if (recoveryTime > 0) {
                currHp = Math.min(hp, currHp + recoveryTime * recoverySec);
                
                // 보너스 회복 계산
                int bonusCount = (castTime + recoveryTime) / readytime;
                currHp = Math.min(hp, currHp + bonusCount * recoveryBonus);
                
                castTime = (castTime + recoveryTime) % readytime;
            }
            
            // 공격 처리
            currTime = nextAtk;
            currHp -= attacks[atkIdx][1];
            if (currHp <= 0) return -1;
            
            castTime = 0;
            atkIdx++;
        }
        
        return currHp;
    }
}
