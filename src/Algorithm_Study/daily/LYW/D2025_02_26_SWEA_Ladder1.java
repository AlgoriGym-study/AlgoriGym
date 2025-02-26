package Algorithm_Study.daily.LYW;

import java.io.File;
import java.util.Scanner;

class D2025_02_26_SWEA_Ladder1 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			int tc = sc.nextInt();

			int[][] arr = new int[100][100];
			int x = 0; // 도착지점 x좌표
			int y = 0; // 도착지점 y좌표

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}

//			System.out.println("x : " + x + "| y : " + y);
			
			// 도착지점을 시작으로 0이 나올때까지 올라간다. 0이 나오면 방향을 틀고 다시 0이 나올때까지 이동한다. -> i가 0이 될때까지반복
			a: while (true) {
				int dir = 0; // 좌우 방향 설정 (0이면 왼쪽 방향 / 1이면 오른쪽 방향)
				// 위로 이동
				for (int i = 1; i < 100; i++) {
					
					    // 올라가다 좌우에 1이 있으면, 좌우 중 1이 있는 곳으로 꺾기
						if (x-i >= 0 && x-i < 100 && y+1 >= 0 && y+1 < 100 && arr[x-i][y+1] == 1) { // 오른쪽에 1
							dir = 1;
							x = x-i;
							break;
						} else if (x-i >= 0 && x-i < 100 && y-1 >= 0 && y-1 < 100 && arr[x-i][y-1] == 1) { // 왼쪽에 1
							dir = -1;
							x = x-i;
							break;
						}						
					
					if(x-i == 0) { // x-i가 0이 되었을때 y값이 정답이 된다.
						break a;
					}
				} // for
				// 좌우로 이동
				if(dir == 1) { // 오른쪽으로 0이 나오거나 99번 인덱스까지 전진
					for(int j = 1; j < 100; j++) {
						if(y+j >= 0 && y+j < 100 && arr[x][y+j] == 0) {
							y = y+j-1;
							break;
						} else if(y+j == 99) {
							y = 99;
							break;
						}
					}
				} 
				else if(dir == -1) { // 왼쪽으로 0이 나오거나 0번 인덱스까지 전진
					for(int j = 1; j < 100; j++) {
						if(y-j >= 0 && y-j < 100 && arr[x][y-j] == 0) {
							y = y-j+1;
							break;
						} else if(y-j == 0) {
							y = 0;
							break;
						}
					}
				}
			} // while
			
			System.out.println("#" + tc + " " + y);

			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}