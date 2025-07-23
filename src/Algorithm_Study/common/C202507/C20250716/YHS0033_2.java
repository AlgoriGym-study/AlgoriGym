package Algorithm_Study.common.C202507.C20250716;

import java.util.Collections;
import java.util.PriorityQueue;

public class YHS0033_2 {
    public int solution(int[] priorities, int location) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : priorities) {
            pq.offer(num);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    pq.poll();
                    ans++;
                    if (i == location) {
                        return ans;
                    }
                }
            }
        }

        return ans;
    }
}
