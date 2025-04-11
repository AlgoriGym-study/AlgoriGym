package Algorithm_Study.daily.PJE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D20250410 {
	static int[][] map;
	static boolean[][] visited;
	static int startR, startC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			map = new int[16][16];
			visited = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String str = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = (str.charAt(j) - '0');
					if (map[i][j] == 2) {
						map[i][j] = 0;
						startR = i;
						startC = j;
					}

				}
			}
			answer = false;
			bfs(startR, startC);

			System.out.println("#" + N + " " + (answer ? 1 : 0));
		}
	}

	static boolean answer;

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (16 <= nr || nr < 0 || 16 <= nc || nc < 0)
					continue;
				if (visited[nr][nc] || map[nr][nc] == 1)
					continue;

				if (map[nr][nc] == 3) {
					answer = true;
					return;
				}

				if (map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}

			}
		}
	}

}
