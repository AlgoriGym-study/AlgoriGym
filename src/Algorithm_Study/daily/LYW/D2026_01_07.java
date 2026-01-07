package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2026_01_07 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine().trim());

		if (K > C * R) {
			System.out.println(0);
			return;
		}

		boolean[][] visited = new boolean[R + 1][C + 1];
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int dir = 0;
		int x = 1, y = 1;

		for (int i = 1; i < K; i++) {
			visited[y][x] = true;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 1 || nx > C || ny < 1 || ny > R || visited[ny][nx]) {
				dir = (dir + 1) % 4;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			x = nx;
			y = ny;
		}

		System.out.println(x + " " + y);
	}
}
