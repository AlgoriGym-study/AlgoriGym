package Algorithm_Study.daily.PJE.D202601;
public class D20260127 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int currentServers = 0; // 현재 가동 중인 총 서버 수
        int[] expires = new int[24 + k]; // 각 시간에 만료될 서버 수 저장

        for (int i = 0; i < 24; i++) {
            // 1. 현재 시간에 수명이 다한 서버들을 제외함
            currentServers -= expires[i];

            // 2. 현재 시간 i에 필요한 서버 대수 계산
            int requiredServers = players[i] / m;

            // 3. 현재 서버가 부족하다면 증설 진행
            if (currentServers < requiredServers) {
                int addCount = requiredServers - currentServers; // 추가로 필요한 서버 수
                
                answer += addCount;         // 총 증설 횟수 누적
                currentServers += addCount; // 현재 가동 서버에 추가
                
                // 4. k시간 뒤에 만료되도록 기록 (i + k 시점에 addCount만큼 감소)
                expires[i + k] += addCount;
            }
        }
        
        return answer;
    }
}
