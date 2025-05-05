package Algorithm_Study.daily.PJE;
import java.util.Arrays;

class D20250505 {
    //입국심사 기다리는 인원 n, 각 심사관이 한명 심사하는데 걸리는 시간 배열 times
    public long solution(int n, int[] times) {
        long left = 1;
        long right =  (long) Arrays.stream(times).max().getAsInt() * n; // 최악의 시간 계산
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2; // 추측한 총 심사시간
            long count = 0;
            
            //mid 시간동안 몇 명 심사? 
            for (int time : times) {
                count += mid / time;
            }

            if (count >= n) { // 만약 심사시간이 충분하다면 더 적은 시간도 가능할지 확인 
                answer = mid;
                right = mid - 1;
            } else { // 심사 시간이 충분하지 않으면 시간 늘려야 함
                left = mid + 1;
            }
        }

        return answer;
    }
}
