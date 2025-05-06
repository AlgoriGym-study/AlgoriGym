package Algorithm_Study.daily.PJE;

import java.util.Scanner;

public class D20250504 {
	// 오 아 왼 위
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc ++) {
			int N = sc.nextInt();
			int [][] map = new int [N][N];
			int num = 1;
			int d = 0;
			int r = 0;
			int c = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[r][c] = num++;
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if( nr <0 || nr >=N || nc <0 || nc >=N || map[nr][nc]!=0){
						d = (d+1)%4; //방향 바꿔주기
						nr = r + dr[d]; 
						nc = c + dc[d];
					}
					r = nr;
					c = nc;
				}
			}
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
