import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D20250406_벽부수고이동하기 {
	static class Node {
		int x, y, count, wall;//벽을 부순적 있는지 없는지

		public Node(int x, int y, int count, int wall) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.wall = wall;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());// 사다리
		M = Integer.parseInt(st.nextToken());// 뱀

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}

		visited = new boolean[N][M][2];
		System.out.println(bfs(0,0));

	}

	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,1,0));
		visited[x][y][0] = true; //0은 벽을 부수지 않고 방문한 노드의 방문여부
		visited[x][y][1] = true; //1은 벽을 부수면서 방문한 노드의 방문여부

		while (!q.isEmpty()) {
			Node curr = q.poll();

			if (curr.x == N-1 && curr.y == M-1)
				return curr.count;

			for (int d = 0; d < 4; d++) {
				int nr = curr.x + dr[d];
				int nc = curr.y + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 0) {
						if (!visited[nr][nc][curr.wall]) {
							q.add(new Node(nr,nc,curr.count+1, curr.wall));
							visited[nr][nc][curr.wall] = true;
						}
					}
					else if (map[nr][nc] == 1) {
						if (curr.wall == 0 && !visited[nr][nc][1]) {
							q.add(new Node(nr,nc,curr.count+1,1));
							visited[nr][nc][1] = true;
						}
					}
				}
			}
		}

		return -1;
	}
}
