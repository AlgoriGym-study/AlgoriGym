package Algorithm_Study.common.C202507.C20250716;

import java.util.*;

// 프로그래머스 프로세스
public class PJE0033_2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 우선순위 높은 순으로 정렬 (우선순위 큐 내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 1. 모든 문서의 우선순위를 큐에 삽입
        for (int p : priorities) {
            pq.add(p);
        }

        // 2. 우선순위 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            // 3. 문서 배열 순회, 실제로 출력되는 문서 찾기
            for (int i = 0; i < priorities.length; i++) {
                // 현재 문서가 가장 높은 우선순위와 같으면 출력
                if (priorities[i] == pq.peek()) {
                    pq.poll();       // 출력했으므로 큐에서 제거
                    answer++;        // 출력 순서 증가

                    if (i == location) {
                        // 찾는 문서(location)가 출력된 경우
                        return answer;
                    }
                }
            }
        }

        return answer; // fallback (실제로는 이 줄까지 도달하지 않음)
    }
}
