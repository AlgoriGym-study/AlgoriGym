package Algorithm_Study.common.C202506.C20250625;

import java.util.*;

public class LYW0026_2 {
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

            int nextX = curX + 1;
            int nextT = curT + 1;
            if(nextX <= 100000 && time[nextX] > nextT) {
                time[nextX] = nextT;
                pq.offer(new int[]{nextX, nextT});
            }

            nextX = curX - 1;
            if(nextX >= 0 && time[nextX] > nextT) {
                time[nextX] = nextT;
                pq.offer(new int[]{nextX, nextT});
            }

            nextX = 2 * curX;
            nextT = curT;
            if(nextX > 0 && nextX <= 100000 && time[nextX] > nextT) {
                time[nextX] = nextT;
                pq.offer(new int[]{nextX, nextT});
            }
        }
        return time[M];

    }
}