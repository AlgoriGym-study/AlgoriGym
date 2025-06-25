package Algorithm_Study.common.C20250625;

import java.util.*;

public class KMR0027 {
    static int N;
    static int M;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        System.out.println(dijkstra());

        sc.close();
    } // main

    static int dijkstra() {
        int[] time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[N] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{N, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curX = cur[0];
            int curT = cur[1];

            if(curT > time[curX]) continue;
            if(curX == M) break;

            // 한 칸 앞으로
            int nextX = curX + 1;
            int nextT = curT + 1;
            if(nextX <= 100000 && time[nextX] > nextT) {
                time[nextX] = nextT;
                pq.offer(new int[]{nextX, nextT});
            }

            // 한 칸 뒤로
            nextX = curX - 1;
            if(nextX >= 0 && time[nextX] > nextT) {
                time[nextX] = nextT;
                pq.offer(new int[]{nextX, nextT});
            }

            // 순간이동
            nextX = 2 * curX;
            nextT = curT;
            if(nextX > 0 && nextX <= 100000 && time[nextX] > nextT) {
                time[nextX] = nextT;
                pq.offer(new int[]{nextX, nextT});
            }
        }// while
        return time[M];

    } //다익스트라
}
