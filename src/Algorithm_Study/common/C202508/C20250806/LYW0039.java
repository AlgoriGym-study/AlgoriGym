package Algorithm_Study.common.C202508.C20250806;

import java.util.*;

public class LYW0039 {
	static int N, K, L;
	static int[][] board;
	// 우, 하, 좌, 상 (시계 방향)
	static final int[] dr = { 0, 1, 0, -1 };
	static final int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N + 1][N + 1]; // 1-indexed

		K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			board[r][c] = 1; // 사과
		}

		L = sc.nextInt();
		int[] turnTime = new int[L];
		char[] turnDir = new char[L];
		for (int i = 0; i < L; i++) {
			turnTime[i] = sc.nextInt();
			turnDir[i] = sc.next().charAt(0);
		}

		System.out.println(simulate(turnTime, turnDir));
	}

	private static int simulate(int[] turnTime, char[] turnDir) {
		Deque<int[]> snake = new ArrayDeque<>();
		snake.addLast(new int[] { 1, 1 });
		board[1][1] = 2; // 뱀 위치

		int dir = 0; // 오른쪽 시작
		int time = 0;
		int headR = 1, headC = 1;
		int turnIdx = 0;

		while (true) {
			time++;

			int nr = headR + dr[dir];
			int nc = headC + dc[dir];

			// 벽 또는 자기자신과 충돌
			if (nr < 1 || nr > N || nc < 1 || nc > N)
				return time;
			if (board[nr][nc] == 2)
				return time;

			// 머리 이동
			snake.addFirst(new int[] { nr, nc });
			if (board[nr][nc] == 1) {
				board[nr][nc] = 2; // 사과 먹으면 꼬리 유지
			} else {
				board[nr][nc] = 2;
				int[] tail = snake.removeLast();
				board[tail[0]][tail[1]] = 0;
			}

			headR = nr;
			headC = nc;

			// 방향 전환
			if (turnIdx < L && time == turnTime[turnIdx]) {
				char t = turnDir[turnIdx];
				if (t == 'L')
					dir = (dir + 3) % 4;
				else
					dir = (dir + 1) % 4;
				turnIdx++;
			}
		}
	}
}
