package Algorithm_Study.common.C202508.C20250806;

import java.util.*;

public class SJG0039_2 {
    
    public static Map<Integer, Integer> countBlocks(int[][] logs, int K) {
        // 1) 시간, 그 다음 userId로 정렬 (O(N log N))
        Arrays.sort(logs, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        Map<Integer, Integer> blocks = new HashMap<>();
        Map<Integer, Deque<Integer>> windows = new HashMap<>();

        for (int[] log : logs) {
            int t = log[0];
            int uid = log[1];

            Deque<Integer> dq = windows.computeIfAbsent(uid, k -> new ArrayDeque<>());

            // 2) 윈도우 밖 제거: [t-59, t]만 유지
            while (!dq.isEmpty() && dq.peekFirst() < t - 59) {
                dq.pollFirst();
            }

            // 3) 현재 시도 처리
            if (dq.size() >= K) {
                // 이미 K회가 창 안에 있으면 현재 시도는 차단
                blocks.merge(uid, 1, Integer::sum);
                // 차단된 시도는 창에 넣지 않음
            } else {
                // 허용
                dq.offerLast(t);
            }
        }
        return blocks;
    }

    // 간단 검증
    public static void main(String[] args) {
        int K = 3;
        int[][] logs = {
            {1, 1}, {10, 1}, {20, 1}, {30, 1}, {59, 1}, {60, 1}, {61, 1},
            {5, 2}, {65, 2}, {66, 2}, {67, 2}
        };
        System.out.println(countBlocks(logs, K)); // 예시 출력 확인용
    }

}
