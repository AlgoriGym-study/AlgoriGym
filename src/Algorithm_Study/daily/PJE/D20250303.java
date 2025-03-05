package Algorithm_Study.daily.PJE;
import java.util.Scanner;
//SWEA 달팽이 문제
public class D20250303 {
	// 오른쪽 -> 아래 -> 왼쪽 -> 위쪽
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// N크기의 달팽이 숫자 출력
			int[][] board = new int[N][N];

			int num = 1;
			int d = 0; // 방향, 여기에서는 델타의 인덱스역할
			int r = 0;
			int c = 0;
			
			//N*N번 반복
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					// 값 갱신
					board[r][c] = num++;

					// 다음 좌표
					int nr = r + dr[d];
					int nc = c + dc[d];

					// 숫자가 적혀있거나 범위에서 벗어나면 방향 꺾기(델타 인덱스 바꿔주기)
					if ( (nr < 0 || nr >= N || nc < 0 || nc >= N) || board[nr][nc] > 0) {
						d = (d + 1) % 4; 
						nr = r + dr[d]; 
						nc = c + dc[d]; 
					}
					
					// 좌표 인덱스 갱신
					r = nr;
					c = nc;
				}
			}
			
			System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		System.out.print(board[i][j] + " ");
            	}
            	System.out.println();
            }

		}
	}
}
