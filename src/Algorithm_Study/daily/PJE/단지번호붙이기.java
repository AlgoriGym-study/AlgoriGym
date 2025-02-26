package Algorithm_Study.daily.PJE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//1은 집이 있는곳, 0은 없는곳. 
//좌우,아래위로 다른집이 있는경우 집이 연결됨. 대각선은 연결아님.
//지도를 입력하여 단지갯수를 출력하고 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램 


	public class 단지번호붙이기 {
		// 상하좌우
		static int[] dr = { 1, -1, 0, 0 };
		static int[] dc = { 0, 0, -1, 1 };
		static int[][] apt;
		static boolean[][] visited;

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			apt = new int[N][N];
			visited = new boolean[N][N];
			
			// 입력 띄어쓰기로 들어오는지 아닌지 반드시 확인해야함
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					apt[i][j] = line.charAt(j) - '0';
				}
			}

			int danji = 0; // 단지 갯수
			List<Integer> houses = new ArrayList<>(); // 단지 내 집 갯수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (apt[i][j] == 1 && !visited[i][j]) {
						danji++;
						int num = dfs(i, j); // 단지 내 집 갯수
						houses.add(num);
					}
				}
			}
			System.out.println(danji);
			Collections.sort(houses);

			for (int size : houses) {
				System.out.println(size);
			}

		}

		private static int dfs(int i, int j) {

			Stack<int[]> stack = new Stack<>();
			int[] xy = { i, j };
			stack.push(xy);
			visited[i][j] = true;
			int size = 0;

			while (!stack.isEmpty()) {
				int[] now = stack.pop();
				int x = now[0];
				int y = now[1];
				size++;

				for (int k = 0; k < 4; k++) {
					int nr = x + dr[k];
					int nc = y + dc[k];

					// 범위내에 있으면 상하좌우 탐색
					if (nr >= 0 && nr < apt.length && nc >= 0 && nc < apt.length) {
						// 값이 있고 방문한 적 없다면 push
						if (apt[nr][nc] == 1 && !visited[nr][nc]) {
							visited[nr][nc] = true;
							int[] xy2 = { nr, nc };
							stack.push(xy2);
						}
					}

				}

			}

			return size;
		}

	}
