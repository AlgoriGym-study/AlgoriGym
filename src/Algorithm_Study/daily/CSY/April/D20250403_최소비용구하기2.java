package Algorithm_Study.daily.CSY.April;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class D20250403_최소비용구하기2 {


        static class Edge implements Comparable<Edge> {
            int to, cost;

            public Edge(int to, int cost) {
                super();
                this.to = to;
                this.cost = cost;
            }

            @Override
            public int compareTo(Edge o) {
                return Integer.compare(this.cost, o.cost);
            }

        }

        static int INF = Integer.MAX_VALUE;
        static int N, M;
        static List<Edge>[] adj;
        static int[] dist;
        static int[] prev; // 경로 출력을 위한 배열

        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine()); // 도시의 개수
            M = Integer.parseInt(br.readLine()); // 버스의 개수

            adj = new ArrayList[N+1];
            dist = new int[N+1];
            prev = new int[N+1];

            Arrays.fill(dist, INF); // 거리 배열 무한대로 채워넣기.

            for(int i = 0; i < N+1; i++)
                adj[i] = new ArrayList<>(); // 객체 생성

            StringTokenizer st;
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()); // 출발
                int e = Integer.parseInt(st.nextToken()); // 도착
                int w = Integer.parseInt(st.nextToken()); // 가중치(버스 비용)

                adj[s].add(new Edge(e, w));
            }// 간선 입력 받기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발지
            int end = Integer.parseInt(st.nextToken()); // 도착지

            djikstra(start);
            System.out.println(dist[end]);
            List<Integer> path = new ArrayList<>();
            int curr = end;
            while(curr != -1) {
                path.add(curr);
                curr = prev[curr];
            }
            System.out.println(path.size());
            for(int i = path.size()-1; i >=0; i--) {
                System.out.print(path.get(i) + " ");
            }
        }

        static void djikstra(int start) {
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N+1];
            dist[start] = 0; // 출발지는 0으로!
            prev[start] = -1; // 처음은 없으니까

            pq.add(new Edge(start, 0));

            while(!pq.isEmpty()) {
                Edge curr = pq.poll(); // 탐색할 정점 꺼내기

                if(visited[curr.to]) continue; // 이미 방문했으면 패스
                visited[curr.to] = true; // 지금부터 탐색할 곳 왔다고 표시하기

                for(Edge node : adj[curr.to]) { // 탐색할 곳과 연결되어 있는 곳들 탐색
                    // 방문한 적이 없고
                    // 새 노드까지의 거리가 지금까지의 계산해온 거리와 비교했을 때
                    // 더 크면 갱신.. => A - B (1) - C (1) 이어서 총 거리가 2라고 가정
                    // A-C(3)이면 2로 갱신. 1이면 1로..!!
                    if(!visited[node.to] && dist[node.to] > dist[curr.to] + node.cost) {
                        dist[node.to] = dist[curr.to] + node.cost;
                        prev[node.to] = curr.to; // 현재 탐색할 곳의 이전 장소를 저장 (최단 경로로)
                        pq.add(new Edge(node.to, dist[node.to]));
                    }
                }
            }
        }


}
