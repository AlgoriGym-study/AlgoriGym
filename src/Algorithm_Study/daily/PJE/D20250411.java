package Algorithm_Study.daily.PJE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// swea 차윤이의 rc카
public class D20250411 {
	static int startR, startC;
	// 상0하1좌2우3
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	// 현재 - 왼쪽 회전
	// 지금 방향이 0 1 2 3 일때 함수를 만나면 방향이 바뀌어야함
	static int[] turnLeft = { 2, 3, 1, 0};
	static int[] turnRight = { 3, 2, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 필드의크기
			// G : 이동 가능한 땅 T : 이동불가능한 나무
			// X : 현재 위치 Y : 이동하고자 하는 위치
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'X') {
						startR = i;
						startC = j;
					}

				}
			}
			StringBuilder sb = new StringBuilder();
			int Q = sc.nextInt(); // 조종 횟수

			for (int i = 0; i < Q; i++) {
				// ex. 7 RRAALAA
				int C = sc.nextInt(); // 커멘드 길이
				char[] str = sc.next().toCharArray(); // 커멘드
				// 각 커멘드마다 목적지 도달 가능하면 1, 아니면 0
				// A : 앞으로 이동
				// L : 왼쪽으로 90도 회전 R : 오른쪽으로 90도 회전

				int d = 0; // 방향 (위쪽이 디폴트)
				int r = startR;
				int c = startC;
				for (int j = 0; j < C; j++) { // 커멘드 길이 만큼 반복
					
					switch (str[j]) { // 커멘드가
					case 'A': { // A면
						// 방향 바꾸지 않고 앞으로 전진
						// 다음좌표
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						// 범위를 벗어나거나 T를 만나면 못가는것
						if (N <= nr || nr < 0 || N <= nc || nc < 0)
							continue;
						if (map[nr][nc] == 'T')
							continue;
						
						// 방향 확인 끝나면 갱신
						r = nr;
						c = nc;
						break;
					}
					case 'L': { // 왼쪽으로 90도
						d = turnLeft[d];
						break;
					}
					case 'R': {
						d = turnRight[d];
						break;
					}
					}
					
				}
				// 입력
				// RC카를 조종했을 때 목적지에 도달 할 수 있는지 구하라.
				if (map[r][c]=='Y') {
					sb.append(1);
				}else {
					sb.append(0);
				}
				sb.append(" ");
			}
			System.out.println("#"+tc+" "+sb);
		}
		
	}
}
