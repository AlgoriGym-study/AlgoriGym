package Algorithm_Study.common.C202507.C20250716;

import java.util.*;

public class KMR0033_2 {

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            queue.offer(new int[]{i, priorities[i]}); // {인덱스, 우선순위}
        }

        int printOrder = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentIdx = current[0];
            int currentPriority = current[1];

            if (currentPriority == pq.peek()) {
                printOrder++;
                pq.poll();

                if (currentIdx == location) {
                    return printOrder;
                }
            } else {
                queue.offer(current);
            }
        }

        return printOrder;
    }
}
