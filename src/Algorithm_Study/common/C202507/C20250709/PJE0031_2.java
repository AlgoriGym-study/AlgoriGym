package Algorithm_Study.common.C202507.C20250709;

// 프로그래머스 붕대감기
class PJE0031_2 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; //연속 시전 시간
        int x = bandage[1]; //1초당 회복량
        int y = bandage[2]; //추가 회복량
        
        int hp = health; // 현재 체력
        int combo = 0;   // 연속 시전 시간
        int attackIdx = 0; // attacks 배열 인덱스
        int lastTime = attacks[attacks.length - 1][0]; // 마지막 공격 시간 
        
        for(int time = 1; time<= lastTime; time++){
            //몬스터가 공격할 때 
            if(attackIdx < attacks.length && attacks[attackIdx][0] == time){
                hp -= attacks[attackIdx][1]; 
                if(hp <= 0) return -1; 
                combo = 0;
                attackIdx++;
            }
            
            //공격이 없을때 -> 붕대감기
            else{
                combo++;    //1초 성공
                hp += x;    //초당 회복
                
                if(combo == t){
                    hp += y;    //추가 회복
                    combo = 0;  //연속 회복 초기화
                }
                
                if(hp > health) hp = health;
                
            }
        }
        return hp;
    }
}
