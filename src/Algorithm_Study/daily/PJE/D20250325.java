package Algorithm_Study.daily.PJE;
import java.util.Scanner;
import java.util.Stack;
// 백준 섬의 개수
public class D20250325 {

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int w = sc.nextInt(); //열
			int h = sc.nextInt(); //행
			
			if(w==0 && h==0)
				break;
			
			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			Stack<int[]> stack = new Stack<int[]>();
			// 입력
			// 섬의 개수를 세는 프로그램.
			int island = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1 ) {
						island++;
						
						stack.push(new int[] { i, j });
						visited[i][j] = true;
						
						while (!stack.isEmpty()) {
							int[] now = stack.pop();
							int r = now[0];
							int c = now[1];
							for (int d = 0; d < 8; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								if ((0 <= nr && nr < h && 0 <= nc && nc < w)  && !visited[nr][nc] && map[nr][nc] == 1) {
//								System.out.println(nr + " " + nc + " 현재좌표의 값: "+map[nr][nc]);
									stack.push(new int[] { nr, nc });
									visited[nr][nc] = true;
									
								}
								
							}
							
						}
						
					}
					
				}
			}
			System.out.println(island);
		}

	}
}
