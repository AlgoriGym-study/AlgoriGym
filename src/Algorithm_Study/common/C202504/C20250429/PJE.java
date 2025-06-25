package Algorithm_Study.common.C202504.C20250429;
	import java.util.*;

	public class PJE {
	    static int N;
	    static int[][] map;
	    static int[][] dist;
	    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	    static int[] dc = {0, 0, -1, 1};

	    static class Node implements Comparable<Node> {
	        int r, c, cost;

	        Node(int r, int c, int cost) {
	            this.r = r;
	            this.c = c;
	            this.cost = cost;
	        }

	        @Override
	        public int compareTo(Node o) {
	            return this.cost - o.cost; // cost가 작은 순서대로
	        }
	    }

	    public static int dijkstra() {
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        dist[0][0] = 0;
	        pq.offer(new Node(0, 0, 0));

	        while (!pq.isEmpty()) {
	            Node now = pq.poll();

	            // 이미 더 짧은 경로로 방문한 적이 있으면 스킵
	            if (now.cost > dist[now.r][now.c]) continue;

	            for (int d = 0; d < 4; d++) {
	                int nr = now.r + dr[d];
	                int nc = now.c + dc[d];

	                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
	                    int newCost = 0; 
	                    int heightDiff = map[nr][nc] - map[now.r][now.c];

	                    if (heightDiff > 0) {
	                    	newCost = dist[now.r][now.c]+ 2 * heightDiff; // 오르막
	                    } else if (heightDiff == 0) {
	                    	newCost = dist[now.r][now.c] + 1; // 평지
	                    } else {
	                    	newCost = dist[now.r][now.c] + 0; // 내리막
	                    }

	                    if (newCost < dist[nr][nc]) {
	                        dist[nr][nc] = newCost;
	                        pq.offer(new Node(nr, nc, dist[nr][nc]));
	                    }
	                }
	            }
	        }

	        return dist[N-1][N-1];
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for (int tc = 1; tc <= T; tc++) {
	        	 N = sc.nextInt();
	 	        map = new int[N][N];
	 	        dist = new int[N][N];

	 	        for (int i = 0; i < N; i++) {
	 	            for (int j = 0; j < N; j++) {
	 	                map[i][j] = sc.nextInt();
	 	                dist[i][j] = Integer.MAX_VALUE; 
	 	            }
	 	        }

	 	        int answer = dijkstra();
	 	        System.out.println("#"+ tc+" " + answer);
			}
	       
	    }
	}
