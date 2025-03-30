package Algorithm_Study.daily.PJE;

import java.util.Scanner;
//과목평가 미술관의 조명
public class D20250319 {
	//상하좌우
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int [][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			board = new int[N][N];
			int lightsNwalls = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
					if(board[i][j]!=0)
						lightsNwalls++;
				}
			}
			
			//입력 
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(board[i][j] == 2) { //조명 
						
						int row = i;
						int col = j;
						
						for (int k = 0; k < 4; k++) {
							int nx = row + dx[k]; 
							int ny = col + dy[k];
							
							//범위안에 있고 0 또는 3이라면 
							while((nx>=0 && ny>=0 && nx < N && ny < N) && (board[nx][ny] == 0||board[nx][ny] == 3)) {
								board[nx][ny] =3;
								nx += dx[k];
								ny += dy[k];
							}
							
						}
						
						
					}
				}
			}
			
			int brightened = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(board[i][j]==3) {
						brightened++;
					}
				}
			}
			
			int answer = N*N-(brightened+lightsNwalls);
			System.out.println("#" + tc + " " + answer);
		}
	}
}
