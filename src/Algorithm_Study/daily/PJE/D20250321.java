package Algorithm_Study.daily.PJE;

import java.util.Scanner;
//SWEA 달팽이 숫자
public class D20250321 {
	// 오 아 왼 위
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int [][] board = new int [N][N];
			int num =1 ;
			int row = 0,col = 0;
			int d = 0;
			
			while(num != N*N +1) {
				
				board[row][col] = num++;
				
				int nx = row+ dx[d];
				int ny = col+ dy[d];
				
				if( nx < 0 || nx >=N || ny <0 || ny >= N || board[nx][ny] !=0 ) {
					d = (d+1) % 4;
					nx = row+dx[d];
					ny = col+dy[d];
				}
				
				row = nx;
				col = ny;
			}
			System.out.println("#"+tc+ " " );
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}
}
