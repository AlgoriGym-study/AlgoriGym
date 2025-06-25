package Algorithm_Study.common.C202504.C20250404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class CSY {

        static class Edge implements Comparable<Edge> {
            int to, cost;

            public Edge(int to, int cost) {
                this.to = to;
                this.cost = cost;
            }

            @Override
            public String toString() {
                return "Edge [to=" + to + ", cost=" + cost + "]";
            }

            @Override
            public int compareTo(Edge o) {
                return Integer.compare(this.cost, o.cost);
            }
        }

        static int N, M;
        static int INF = Integer.MAX_VALUE;
        static List<Edge>[] adjList;
        static int[] dist;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[N+1];

            for(int i = 0; i < N+1; i++)
                adjList[i] = new ArrayList<>();
            dist = new int[N+1];
            Arrays.fill(dist, INF); // 거리 배열에 무한대로 채우기

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                adjList[s].add(new Edge(e, cost));
                adjList[e].add(new Edge(s, cost));
            }// 간선 입력 받기 끝!

            dijkstra(1); // 함수 꼬

            // 쳌쳌
//		System.out.println(Arrays.toString(dist));
            //[2147483647, 0, 1, 5, 1, 4, 5]

            System.out.println(dist[N]);

        }

        static void dijkstra(int start) {
            // 우선순위 큐 생성
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N+1]; // 방문 배열
            dist[start] = 0; // 출발지의 거리는 0

            pq.add(new Edge(start, 0));
            while(!pq.isEmpty()) {
                Edge curr = pq.poll();

                if(visited[curr.to]) continue; // 체크할 필요 없으면 패스
                visited[curr.to] = true;

                for(Edge node : adjList[curr.to]) {
                    // 방문 배열 체크
                    // 지금까지 체크한 dist보다 더 짧은 길이 있으면 갱신
                    if(!visited[node.to] && dist[node.to] > dist[curr.to] + node.cost) {
                        dist[node.to] = dist[curr.to] + node.cost;
                        pq.add(new Edge(node.to, dist[node.to]));
                    }
                }
            }


        }


}
