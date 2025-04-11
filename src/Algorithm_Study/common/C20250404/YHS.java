package Algorithm_Study.common.C20250404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class YHS {

    static class Node implements Comparable<Node> {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost); // 비용(여물) 오름차순 정렬
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<List<Node>> graph;
    static int[] dist;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(); //인접 리스트
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Node>()); //Node 클래스 (정점,비용) 을 담을 리스트
        }

        dist = new int[N + 1]; //비용을 저장할 그래프
        check = new boolean[N + 1]; 

        Arrays.fill(dist, INF); //모든 정점의 비용을 최댓값으로 초기화
        dist[1] = 0; //시작점의 비용 0으로 초기화

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, cost));
            graph.get(e).add(new Node(s, cost)); //무향 그래프
        }

        dijkstra();
        System.out.println(dist[N]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐, 비용 오름차순
        pq.add(new Node(1, dist[1]));

        while (!pq.isEmpty()) {
            int currIdx = pq.poll().idx;
            check[currIdx] = true;

            for (Node next : graph.get(currIdx)) {
                if (!check[next.idx] && dist[next.idx] > dist[currIdx] + next.cost) { // 해당 정점에 대해 가장 적은 비용으로 초기화 과정 반복
                    dist[next.idx] = dist[currIdx] + next.cost;

                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}