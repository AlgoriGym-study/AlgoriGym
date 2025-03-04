package Algorithm_Study.daily.PJE;

import java.util.Scanner;
//SWEA 우주괴물
public class D20250304 {
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[][] board = new int[N][N];
			
			int monsterY = 0, monsterX = 0; //몬스터의 x,y좌표
			int cnt = 0; // 빈칸

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
					if (board[i][j] == 0) {
						cnt++; //총빈칸의 수 구하기
					}
					if (board[i][j] == 2) {
						monsterX = i;
						monsterY = j;
					}
				}
			}
			// 입력

			int r = monsterX;
			int c = monsterY;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				// 범위 안에 있고 0이라면
				while (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 0) {
					// 광선이 닿으므로 횟수 줄여주기
					cnt--;
					// 좌표 바꾸기
					nr = nr + dr[i];
					nc = nc + dc[i];
				}

			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}
