package Algorithm_Study.common.C2025041５;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PJE {
	static int startR,startC,targetR,targetC;
	static int N,K,ans;
	static char [][] map;
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int [][] changeDir = {
			{1,3,2,2}, //위 > 위 아래 왼 오
			{3,1,2,2}, //아래 > 위 아래 왼 오
			{2,2,1,3}, //왼 > 위 아래 왼 오
			{2,2,3,1} // 아래 > 위 아래 왼 오
	};
	static class Node {
		int r,c,dir,chop,moves;

		public Node(int r, int c, int dir, int chop, int moves) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.chop = chop;
			this.moves = moves;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new char [N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					
					if(map[i][j] == 'X') {
						startR = i;
						startC = j;
					}else if(map[i][j] == 'Y') {
						targetR = i;
						targetC = j;
					}
					
				}
			}
			// 입력 
			// 노드 : 현재 위치, 현재 방향, 전진, 조작횟수 
			ans = 0;
			bfs();
			System.out.println("#"+tc+" "+ans);
		}
	}
	// X > Y
	private static void bfs() {
		   boolean[][][][] visited = new boolean[N][N][K + 1][4];
		    Queue<Node> q = new LinkedList<>();
		    ans = Integer.MAX_VALUE;

		    for (int d = 0; d < 4; d++) {
		        visited[startR][startC][K][d] = true;
		        q.add(new Node(startR, startC, d, K, 0));
		    }
		q.add(new Node(startR, startC, 0, K, 0)); // 시작좌표, 방향은 -1, chop은 K번, 움직인 횟수 0
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.r;
			int c = curr.c;
			int dir = curr.dir;
			int chop = curr.chop;
			int move = curr.moves;
			
			for (int d = 0; d < 4; d++) {
				int nr = r +dr[d];
				int nc = c +dc[d];
				// 범위 벗어나면 넘어가기
				if(N <= nr || nr < 0 || N <= nc || nc < 0)
					continue;
			
				int nextMove = move + changeDir[dir][d];
				if(map[nr][nc] == 'Y') {
					//방향이 다를경우 3번 더해지냐 2번더해지냐 달라짐
					//ex.위쪽 보고있는데 아래로 가야할경우 3번 
					ans = Math.min(ans, nextMove);
					continue;
				// 맵이 T인데 K가 남아잇을경우 -> 한번 자르기
				}else if (map[nr][nc] == 'T') {
					if(0 < chop && !visited[nr][nc][chop-1][d]) {
						visited[nr][nc][chop-1][d] = true;
						q.add(new Node(nr, nc, d, chop-1, nextMove));
					}else {
						continue;
					}
				}
				
				// 모든걸 다 넘어왔다면
				// 큐에 넣기 => 큐에 넣기전에 맵이 Y라면 
				// 방향 확인하고 움직임 갱신 후 bfs 종료
				
				 
				else if (map[nr][nc] == 'G') {
					if (!visited[nr][nc][chop][d]) {
						visited[nr][nc][chop][d]= true;
						q.add(new Node(nr,nc,d,chop, nextMove));
					}
					
				}
			}
		}
		
		if (ans == Integer.MAX_VALUE) ans = -1; 
	}
}
