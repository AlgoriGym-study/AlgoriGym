package Algorithm_Study.daily.PJE;

import java.util.PriorityQueue;
import java.util.Scanner;

//SWEA 보급로
public class D20250401 {
	static int INF = Integer.MAX_VALUE;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {

		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			// 입력
			// map은 복구작업 시간
			// 0,0 -> N-1,N-1로 갈때 최소시간을 구해라.
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			int[][] dist = new int[N][N]; // 거리 배열
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = INF; // 무한으로 초기화
				}
			}

			dist[0][0] = 0; // 처음은 0.
			PriorityQueue<Node> pq = new PriorityQueue<>();

			pq.add(new Node(0, 0, 0));

			while (!pq.isEmpty()) {
				Node curr = pq.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = curr.x + dr[d];
					int nc = curr.y + dc[d];

					if (0 <= nr && nr < N && 0 <= nc && nc < N) {
						int newCost = dist[curr.x][curr.y] + map[nr][nc];

						if (newCost < dist[nr][nc]) {
							dist[nr][nc] = newCost;
							pq.add(new Node(nr, nc, newCost));
						}

					}
				}
			}

			System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
		}
	}
}
