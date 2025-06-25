package Algorithm_Study.common.C202504.C20250415;

import java.util.*;
import java.io.*;

public class YHS {
	static final int U = 0, D = 1, L = 2, R = 3;
	static int N, K, min;
	static char[][] board;
	static boolean[][][][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	static class Car {
		int x, y, dir, remote, count;

		public Car(int x, int y, int dir, int remote, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.remote = remote;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			board = new char[N][N];
			min = Integer.MAX_VALUE;

			int startX = 0, startY = 0;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = str.charAt(j);
					if (board[i][j] == 'X') {
						startX = i;
						startY = j;
					}
				}
			}

			bfs(startX, startY);

			if (min == Integer.MAX_VALUE)
				min = -1;
			System.out.printf("#%d %d\n", tc, min);
		}
	}

	static void bfs(int r, int c) {
		Queue<Car> q = new LinkedList<>();
		visited = new boolean[N][N][4][K + 1];

		// 시작 좌표에서 4방향 모두 탐색 (전진 포함 비용 처리)
		for (int d = 0; d < 4; d++) {
			int cost = (d == U) ? 1 : 2; // 방향 유지 시 전진 비용 1, 회전 후 전진 비용 2
			q.add(new Car(r, c, d, cost, K));
			visited[r][c][d][K] = true;
		}

		while (!q.isEmpty()) {
			Car now = q.poll();

			if (board[now.x][now.y] == 'Y') {
				min = Math.min(min, now.remote);
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x + drc[d][0];
				int nc = now.y + drc[d][1];

				if (nx < 0 || nx >= N || nc < 0 || nc >= N)
					continue;

				int nextRemote = (d == now.dir) ? now.remote + 1 : now.remote + 2;

				// 목적지 도착 처리
				if (board[nx][nc] == 'Y') {
					min = Math.min(min, nextRemote);
					continue;
				}

				if (board[nx][nc] == 'G' && !visited[nx][nc][d][now.count]) {
					visited[nx][nc][d][now.count] = true;
					q.add(new Car(nx, nc, d, nextRemote, now.count));
				} else if (board[nx][nc] == 'T' && now.count > 0 && !visited[nx][nc][d][now.count - 1]) {
					visited[nx][nc][d][now.count - 1] = true;
					q.add(new Car(nx, nc, d, nextRemote, now.count - 1));
				}
			}
		}
	}
}
