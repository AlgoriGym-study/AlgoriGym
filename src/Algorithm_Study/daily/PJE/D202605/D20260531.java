package Algorithm_Study.daily.PJE.D202605;
import java.util.*;
public class D20260531 {
public int solution(int[] elements) {
        int n = elements.length;
        int[] prefix = new int[n * 2 + 1];

        // 누적합 배열 생성
        for (int i = 0; i < n * 2; i++) {
            prefix[i + 1] = prefix[i] + elements[i % n];
        }

        Set<Integer> set = new HashSet<>();

        // 길이 1부터 n-1까지의 연속 부분합을 모두 집합에 추가
        for (int len = 1; len < n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = prefix[start + len] - prefix[start];
                set.add(sum);
            }
        }

        return set.size() + 1;  // 길이 n 전체 합은 마지막에 +1 보정
    }
}
