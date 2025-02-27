package Algorithm_Study.daily.PJE;

import java.util.Scanner;
import java.util.Stack;

//백준 유기농 배추
public class D20250227 {
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// 배추 입력
		for (int t = 0; t < T; t++) {
			int M = sc.nextInt(); // 가로
			int N = sc.nextInt(); // 세로
			
			int [][] field = new int [M][N];
			
			int K = sc.nextInt(); // 배추 위치 갯수
			
			for (int k = 0; k < K; k++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				field[x][y] = 1;
			}
			
		////////////////
		
			
			Stack<int[]> stack = new Stack<>(); // 1인 좌표를 저장할 스택
			boolean [][] visited = new boolean [M][N]; // 방문한 좌표를 기록하는 배열(좌표 중복검사 방지용)
			
			int answer = 0; // 배추 그룹

			// dfs, 모든 좌표에 대해 검사 시작
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					
					// 1인데 방문안한곳이라면 새로운 배추를 발견했다는 의미
					if (!visited[i][j]&&field[i][j]== 1) {
						answer++; 
						
						stack.push(new int[] {i,j}); // 스택에 좌표 넣기 
						visited[i][j] = true; // 방문 표시 
						
						while(!stack.isEmpty()) {  // 스택에 좌표가 남아있지 않을때까지 검사
							int [] now = stack.pop(); // 스택에 들어간 좌표 꺼내기
							int r = now[0];
							int c = now[1];
								
							//한 배추의 상하좌우에 인접한 배추가 있는지 알아야함 
							for (int l = 0; l < 4; l++) {
								int nr = r + dr[l]; 
								int nc = c + dc[l];
								
								// 다음 좌표가 범위에서 벗어나지 않고, 방문도 하지 않았고, 1이라면 => 인접한 배추를 찾았다는 의미
								if(nr>=0 && nc >=0 && nr < M && nc < N && !visited[nr][nc] && field[nr][nc]== 1) {
									stack.push(new int[] {nr,nc}); // 해당좌표 스택에 넣기 (그 좌표를 기점으로 상하좌우 다시 검사해야하니까)
									visited[nr][nc] = true; // 방문 표시
								}
							}
							
							
						}
						
					}
				}
			}
			
			System.out.println(answer);
		}
	}
	
}
