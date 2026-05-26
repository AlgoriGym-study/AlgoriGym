package Algorithm_Study.daily.KMR;

import java.util.*;

public class D20260517_PRO_더맵게_Lv2 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s: scoville) {
            pq.offer(s);
        }

        int count = 0;
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;

            int x = pq.poll();
            int y = pq.poll();
            pq.offer(x + 2 * y);
            count++;
        }

        return count;
    }
}
