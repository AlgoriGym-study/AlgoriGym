package Algorithm_Study.daily.PJE.D202509;
import java.util.*;

public class D20250917 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1L;                                   // 최소 시간
        long right = (long) times[times.length - 1] * n;  // 최악: 가장 느린 심사관이 전원 처리
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2; // mid 시간 안에 n명 처리 가능한가?

            long processed = 0L;
            for (int t : times) {
                processed += mid / t;
                if (processed >= n) break; // 오버플로우/불필요한 합 방지
            }

            if (processed >= n) {
                // mid 시간으로 충분히 처리 가능 → 더 줄여보기
                answer = mid;
                right = mid - 1;
            } else {
                // mid 시간으론 부족 → 늘리기
                left = mid + 1;
            }
        }

        return answer;
    }
}
