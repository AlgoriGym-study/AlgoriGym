package Algorithm_Study.common.C20250304;

import java.util.Scanner;

//N X N 크기의 판이 있다. 판의 각 칸에는 돌이 있거나 없을 수 있다. 돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 없는지 판정하는 프로그램
public class PJE {

	static int[] dr = { 0, 1, 1, 1 }; // 오른쪽, 아래, 아래-왼,오 대각선
	static int[] dc = { 1, 0, -1, 1 }; // 오른쪽, 아래, 아래-왼,오 대각선

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(sc.nextLine());
			char[][] board = new char[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			// 돌 입력

			// 돌을 찾으면 가로, 세로, 대각선 중 하나의 방향으로 연속한 부분이 있는지 판정 필요
			String answer = "NO"; // 빙고가 맞는지 확인
			loop:for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					int r = i;
					int c = j;
//					System.out.println("현재좌표: "+r+" "+c);
					
					if( board[r][c] == '.')
						continue;
					// 지금 r,c좌표에서 o를 찾음. 해당 좌표를 기점으로 가로 세로 대각선에 o이 이어지는지 확인
					for (int j2 = 0; j2 < 4; j2++) {
						int rocks = 1; //돌 갯수
						
						int nr = r + dr[j2];
						int nc = c + dc[j2];


						// 범위에서 벗어나지 않았고 돌이 있으면 => 돌하나 올리고 좌표갱신, 그방향으로 o있는지 확인해야함
						while( (nr >= 0 && nr < N && nc >= 0 && nc < N ) &&  board[nr][nc] == 'o' ) {
							rocks++;
							if(rocks >= 5) {
								answer = "YES";
								break loop;
							}
//							System.out.println(nr+" "+nc);
							nr = nr+dr[j2];
							nc = nc+dc[j2];
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
