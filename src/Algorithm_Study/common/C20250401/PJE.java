package Algorithm_Study.common.C20250401;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//경쟁적전염
public class PJE {
	static int [][] map;
	// 상하좌우
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 맵 크기
		int K = sc.nextInt(); // 바이러스 종류 1 ~ K 중 하나
		// (1,2) (2,1) (3,3) int [K+1][2]
//		int [][] virusLocation = new int [K+1][2];
		map = new int [N][N]; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]!=0) {
					int num = map[i][j]; // 바이러스 숫자
					//바이러스 숫자 오름차순으로 좌표 저장
				}
			}
		}
		int S = sc.nextInt(); // S초
		int X = sc.nextInt(); // x좌표
		int Y = sc.nextInt(); // y좌표 해당 좌표의 바이러스 종류 출력
		//입력
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int[] is : virusLocation) {
//			System.out.print(Arrays.toString(is));
//		}
		// S초 까지 반복할 것. 1초에 바이러스개수만큼 bfs반복
		// 번호가 낮은 종류의 바이러스부터 증식하므로 
		// 1번 부터 K번까지 순서대로 dfs를 깊이 1까지만 진행해야함.
		
		for (int sec = 1; sec <= S; sec++) {
			
			//초당 바이러스 순서대로 bfs를 깊이 1까지만 수행해야함.
			for (int virus = 1; virus<= K; virus++) {
				
				//1초 : 1~k까지 bfs 한번 => map을 돌면서 바이러스 순서대로 bfs해야함. 
				i : for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j] != virus) continue;
						// 바이러스 순서에 맞는 바이러스를 맵에서 찾았다면
						// bfs수행
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] {i,j});
						
						while(!q.isEmpty()) {
							int [] now = q.poll();
							int r = now[0];
							int c = now[1];
							
							for (int d = 0; d < 4; d++) {
								int nr = r + dr[d];
								int nc = c + dc[d];
								if(N<=nr || nr <0 || N <=nc || nc <0)
									continue;
								if(map[nr][nc]!=0)
									continue;
								
//								System.out.println(virus+"바이러스일 때 다음좌표: "+nr+" "+nc);
								map[nr][nc] = virus;
								break i;
//								if(depth[nr][nc]>1) { // 깊이를 1까지만 해야함
//									continue;
//								}
//								q.add(new int [] {nr,nc});
							}
						}
						
						
						
					}
				}
			}
		}
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//			System.out.println();
//		}
		
		System.out.println(map[X-1][Y-1]);
		
		
		
	}
}



