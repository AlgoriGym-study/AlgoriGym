package Algorithm_Study.common.C202504.C20250401;

import java.io.*;
import java.util.*;

public class YHS {

	static class Virus implements Comparable<Virus> {
		int type, time, x, y;

		public Virus(int type, int time, int x, int y) {
			this.type = type;
			this.time = time;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Virus o) {
			if (this.time == o.time) {
				return Integer.compare(this.type, o.type);
			}
			return Integer.compare(this.time, o.time);
		}
	}

	static int N, K, S, targetX, targetY;
	static int[][] grid;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static PriorityQueue<Virus> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		grid = new int[N][N];
		pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] != 0) {
					pq.add(new Virus(grid[i][j], 0, i, j));
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		targetX = Integer.parseInt(st.nextToken()) - 1;
		targetY = Integer.parseInt(st.nextToken()) - 1;

		bfs();

		System.out.println(grid[targetX][targetY]);
	}

	static void bfs() {
		while (!pq.isEmpty()) {
			Virus curr = pq.poll();
			int row = curr.x;
			int col = curr.y;

			if (curr.time == S)
				break; // S초가 지나면 종료

			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (grid[nx][ny] == 0) {
						grid[nx][ny] = curr.type;
						pq.offer(new Virus(curr.type, curr.time + 1, nx, ny));
					}
				}
			}
		}
	}
}
