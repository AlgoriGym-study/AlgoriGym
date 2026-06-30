package Algorithm_Study.daily.LYW;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2026_06_30_2 {
	public int solution(int[][] maps) {

		int n = maps.length;
		int m = maps[0].length;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { 0, 0 });

		while (!queue.isEmpty()) {

			int[] current = queue.poll();

			int x = current[0];
			int y = current[1];

			for (int i = 0; i < 4; i++) {

				int nx = x + dx[i];
				int ny = y + dy[i];

				// 범위 체크
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				// 벽
				if (maps[nx][ny] == 0)
					continue;

				// 이미 방문
				if (maps[nx][ny] > 1)
					continue;

				maps[nx][ny] = maps[x][y] + 1;

				queue.offer(new int[] { nx, ny });
			}
		}

		return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
	}
}