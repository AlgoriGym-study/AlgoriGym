package Algorithm_Study.common.C202507.C20250716;

import java.util.*;

public class YHS0033 {
    static class Pos {
        int priority; // 우선순위
        int idx;      // 원래 인덱스

        public Pos(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }

    public int solution(int[] priorities, int location) {
        PriorityQueue<Pos> pq = new PriorityQueue<>((p1, p2) -> p2.priority - p1.priority); // 우선순위 높은 순
        Deque<Pos> dq = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            Pos curr = new Pos(priorities[i], i);
            pq.offer(curr);
            dq.offer(curr);
        }

        int ans = 0;
        while (!dq.isEmpty()) {
            Pos now = dq.poll();
            if (now.priority == pq.peek().priority) {
                pq.poll();
                ans++;
                if (now.idx == location) return ans;
            } else {
                dq.add(now); // 다시 맨 뒤로
            }
        }

        return ans;
    }
}
