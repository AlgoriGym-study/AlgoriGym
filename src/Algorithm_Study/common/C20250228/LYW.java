package Algorithm_Study.common.C20250228;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LYW {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("sample.txt"));

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			// 입력값 배열에 넣기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 델타로 상하좌우 값 비교
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int answer = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0; // 한 경우의 대한 공이 움직인 횟수
					int a = i;
					int b = j;

					// arr[i][j] 기준으로 상하좌우의 값을 가져온다.
					// 공이 최대로 굴러가려면 arr[i][j]보다 큰값 중, 가장 큰 값의 방향으로 이동해야한다.
					while (true) {
						int num = 0;
						// 뎉타
						for (int d = 0; d < 4; d++) {
							int x = a + dr[d];
							int y = b + dc[d];

							// 인덱스가 배열 범위이면서, arr[i][j]보다 큰 수 인 경우 -> 가장 큰 값 방향으로 이동
							if (x >= 0 && x < N && y >= 0 && y < N && arr[a][b] < arr[x][y]) {
								int n = arr[x][y];
								num = Math.max(num, n);
								if(arr[x][y] == num) {
									a = x;
									b = y;
								}
							}
						}
						
						if (num != 0) {
							cnt++; // 다음수로 이동 했으므로 ++
						}
						else {
							break;
						}
					} // while
						// cnt와 answer 비교
					answer = Math.max(answer, cnt);

				}
			}
			
			System.out.println("#" + tc + " " + answer);

		} // test_case
	} // main

}
