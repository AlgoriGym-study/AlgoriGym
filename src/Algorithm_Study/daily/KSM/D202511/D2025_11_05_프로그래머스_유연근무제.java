package D202511;
// schedules : 출근 희망 시각
// timelogs[직원][일수] : 실제 출근 시각
// startday : 이벤트 시작일 (1 ~ 7) -> 단, 주말은 제외
// 월1, 화2, 수3, 목4, 금5, 토6, 일7

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int N = schedules.length;
        int[] cnt = new int[N + 1];
        
        int hol1 = 6 - (startday - 1);
        int hol2 = 7 - (startday - 1);
        if (hol1 == 0) {
            hol1 = 7;
        }
        
        calculateLimit(schedules, N);
        // for (int i = 0; i < N; i++) {
        //     System.out.print(schedules[i] + " ");
        // }
        // System.out.println();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == hol1 - 1 || j == hol2 - 1) continue;
                if (timelogs[i][j] <= schedules[i]) cnt[i]++;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (cnt[i] == 5) {
                answer++;
                // System.out.println(i);
            }
        }
        return answer;
    }
    
    public void calculateLimit(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            int min = arr[i] % 100;
            int hour = arr[i] / 100;
            
            if (min + 10 >= 60) {
                hour++;
                min = (min + 10) % 60;
            } else {
                min += 10;
            }
            arr[i] = hour * 100 + min;
        }
    }
}