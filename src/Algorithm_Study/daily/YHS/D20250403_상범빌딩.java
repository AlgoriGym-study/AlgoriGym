package Algorithm_Study.daily.YHS;

import java.io.*;
import java.util.*;

public class D20250403_상범빌딩 {
	static class Pos {
		int z, x, y, time;

		public Pos(int z, int x, int y, int time) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int L, R, C;
	static Pos start;
	static char[][][] map;
	static boolean[][][] visit;
	static int[] dl = { -1, 1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				break;

			map = new char[L][R][C];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = str.charAt(k);
						if (map[i][j][k] == 'S')
							start = new Pos(i, j, k, 0);
					}
				}
				br.readLine();
			}

			bfs();
		}
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		visit = new boolean[L][R][C];

		q.add(start);
		visit[start.z][start.x][start.y] = true;

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			if (map[curr.z][curr.x][curr.y] == 'E') {
				System.out.printf("Escaped in %d minute(s).\n", curr.time);
				return;
			}

			for (int d = 0; d < 6; d++) {
				int nl = curr.z + dl[d];
				int nr = curr.x + dr[d];
				int nc = curr.y + dc[d];

				if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (!visit[nl][nr][nc] && map[nl][nr][nc] != '#') {
						visit[nl][nr][nc] = true;
						q.add(new Pos(nl, nr, nc, curr.time + 1));
					}
				}
			}
		}

		System.out.println("Trapped!");
	}
}
