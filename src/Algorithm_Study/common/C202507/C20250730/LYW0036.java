package Algorithm_Study.common.C202507.C20250730;

import java.util.Scanner;

public class LYW0036 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int maxCell; // 가지치기를 위한 격자 내 최댓값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];
		maxCell = 0;

		// 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > maxCell)
					maxCell = map[i][j];
			}
		}
		sc.close();

		answer = 0;

		// 모든 시작점에서 DFS + T모양 체크
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				visited[r][c] = true;
				dfs(r, c, 1, map[r][c]); // 깊이1, 합계=map[r][c]
				visited[r][c] = false;
				checkTShape(r, c);
			}
		}

		System.out.println(answer);
	}

	/**
	 * 경로형(연결된 4칸) 도형 탐색: ㅗ 제외 모든 테트로미노를 커버 depth: 현재 포함된 칸 수 (1..4) sum: 현재까지 합
	 */
	static void dfs(int r, int c, int depth, int sum) {
		// 가지치기: 남은 칸(4 - depth)을 모두 maxCell로 채워도 answer를 못 넘으면 중단
		int remain = 4 - depth;
		if (sum + remain * maxCell <= answer)
			return;

		if (depth == 4) {
			if (sum > answer)
				answer = sum;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (visited[nr][nc])
				continue;

			visited[nr][nc] = true;
			dfs(nr, nc, depth + 1, sum + map[nr][nc]);
			visited[nr][nc] = false;
		}
	}

	/**
	 * ㅗ, ㅜ, ㅓ, ㅏ 모양 체크 (경로형 DFS로 못 잡는 케이스) 중심을 (r,c)로 하는 4가지 변형을 하드코딩해서 합산
	 */
	static void checkTShape(int r, int c) {
		// ㅗ, ㅜ, ㅓ, ㅏ
		int[][][] shapes = { { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } }, // ㅗ
				{ { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } }, // ㅜ
				{ { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 } }, // ㅓ
				{ { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 } } // ㅏ
		};

		for (int[][] shape : shapes) {
			int sum = 0;
			boolean valid = true;

			for (int[] off : shape) {
				int nr = r + off[0];
				int nc = c + off[1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					valid = false;
					break;
				}
				sum += map[nr][nc];
			}

			if (valid && sum > answer)
				answer = sum;
		}
	}
}
