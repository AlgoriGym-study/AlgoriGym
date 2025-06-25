package Algorithm_Study.common.C202504.C20250408;

import java.util.*;
import java.io.*;

public class YHS {
	static class Pos {
		int x, y, time;

		public Pos(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int N, M, R, C, L, count;
	static int[][] map;
	static boolean[][] visited;
	static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
	static int[][] tunnel = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } }; // 터널
																												// 번호에
																												// 따른 이동
																												// 가능 방향

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(R, C);

			System.out.printf("#%d %d\n", tc, count);
		}
	}

	static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y, 1));
		visited[x][y] = true;
		count = 1; // 시작 = 1시간 (1시간이 지난 뒤에 맨홀로 입장)

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			int dir = map[curr.x][curr.y];

			if (curr.time == L)
				continue; // 현재 칸까지의 이동시간이 L과 같다면 더이상 진행하지 않음 -> 큐가 더이상 추가되지 않으면서 자연스럽게 종료

			for (int num : tunnel[dir]) { // if 현재 칸이 1이라면 상하좌우로 이동 가능 -> tunnel[1] 의 인덱스들을 순회하며 각 방향으로 이동 가능한지 확인
											// (tunnel[1] = 0,1,2,3)
				int nr = curr.x + direction[num][0]; // num = 0이므로, direction의 num(0)번째 인덱스(상)의 x좌표와 더함
				int nc = curr.y + direction[num][1]; // num = 2라면 direction의 2번째 인덱스(좌) 와 더함

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (visited[nr][nc] || map[nr][nc] == 0)
					continue; // 이미 방문했거나, 0이면 이동이 불가능하므로 스킵

				if (!canGo(curr.x, curr.y, nr, nc))
					continue; // 현재 칸과 다음 칸이 반드시 이어져있어야 하므로 비교

				visited[nr][nc] = true;
				q.add(new Pos(nr, nc, curr.time + 1)); // 이동시간 +1 해서 큐에 삽입
				count++; // 정답++
			}
		}
	}

	static boolean canGo(int r, int c, int nr, int nc) { // 현재 칸, 다음 칸 비교
		int p = map[nr][nc]; // 다음 칸의 터널 번호
		for (int num : tunnel[p]) { // 다음 터널이 이동할 수 있는 방향들
			int nx = direction[num][0];
			int ny = direction[num][1];

			if (nr + nx == r && nc + ny == c) // 다음 칸에서 현재 칸으로 이동할 수 있다? true
				return true;
		}
		return false; // 이어져있지 않으니 false
	}
}
