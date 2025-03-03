package Algorithm_Study.common.C20250304;
import java.io.File;
import java.util.Scanner;

public class LYW {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("sample_input.txt"));
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			char[][] arr = new char[N][N];
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				arr[i] = str.toCharArray();
			}

			
			// 델타를 사용하여 상하좌우 4방향, 대각선 4방향으로 돌이 5개 이상 연속되어 있는지 확인
			int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
			int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};
			
			String answer = "NO";
			
		start : for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					// arr[i][j] == 'o' 일 때 델타로 오목 판별
					if(arr[i][j] == 'o') {
						for(int d = 0; d < 8; d++) {
							int x = i;
							int y = j;
							int cnt = 1; // 연속되는 돌의 갯수
							// 해당 델타 방향으로 계속 가면서 오목인지 판별
							while (true) {
							    x = x + dr[d];
							    y = y + dc[d];

							    if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y] == 'o') {
							        cnt++;
							        if (cnt == 5) {  // 오목이 성립하면 즉시 탈출
							            answer = "YES";
							            break start;
							        }
							    } else {
							        break;  // 돌이 없거나 범위를 벗어나면 탐색 중단
							    }
							}

							// cnt가 5인 경우 정답은 YES
							if(cnt == 5) {
								answer = "YES";
								break start;
							}
							
						} // 델타 for						
					}
				}
			}
			
		System.out.println("#" + tc + " " + answer);
			
			
		}//tc
	}
}
