package Algorithm_Study.common.C20250625;

import java.util.*;
// 백준 숨바꼭질3
public class PJE0027_2 {
    static final int MAX = 100_001;
    
    static class Node implements Comparable<Node> {
        int pos; //위치
        int time;//시간

        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return this.time - other.time; // 시간 오름차순
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치

        int[] dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.pos] < cur.time) continue;

            // 0초짜리 이동: 순간이동
            int teleport = cur.pos * 2;
            if (teleport < MAX && cur.time < dist[teleport]) {
                dist[teleport] = cur.time;
                pq.offer(new Node(teleport, cur.time));
            }

            // 1초짜리 이동: X-1
            int left = cur.pos - 1;
            if (left >= 0 &&  cur.time + 1 < dist[left]) {
                dist[left] = cur.time + 1;
                pq.offer(new Node(left, cur.time + 1));
            }

            // 1초짜리 이동: X+1
            int right = cur.pos + 1;
            if (right < MAX && cur.time + 1 < dist[right]) {
                dist[right] = cur.time + 1;
                pq.offer(new Node(right, cur.time + 1));
            }
        }

        System.out.println(dist[K]);
    }


}
