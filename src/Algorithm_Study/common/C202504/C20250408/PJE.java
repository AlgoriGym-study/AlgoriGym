package Algorithm_Study.common.C202504.C20250408;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// SWEA 탈주범 검거
public class PJE {
	//상0하1좌2우3
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	// 각 구조물이 확인해야하는 방향 넣어놓은 map
	static Map<Integer, int[]> checkDir = new HashMap<>();
	static {
		checkDir.put(1,new int [] {0,1,2,3});
		checkDir.put(2,new int [] {0,1});
		checkDir.put(3,new int [] {2,3});
		checkDir.put(4,new int [] {0,3});
		checkDir.put(5,new int [] {1,3});
		checkDir.put(6,new int [] {1,2});
		checkDir.put(7,new int [] {0,2});
	}
	
	static boolean [][] visited;
	static int [][] map;
	static int [][] depth;
	static int N,M,R,C,L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// 탈주범이 위치할 수 있는 장소의 개수를 계산하는 프로그램.
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 지도 세로 크기
			M = sc.nextInt(); // 지도 가로 크기
			R = sc.nextInt(); // 맨홀 위치한 장소의 세로 위치 
			C = sc.nextInt(); // 맨홀 위치한 장소의 가로 위치
			L = sc.nextInt(); // 탈출 후 소요된 시간
			
			map = new int [N][M];
			visited = new boolean[N][M];
			depth = new int [N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 시뮬레이션+bfs 문제 
			// => 시작점(맨홀)로부터 숫자가 있는곳으로 퍼져나가면서 level L에 도달했을 때의 visited 장소 개수 세기
			
			bfs(R,C,0);
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j] && depth[i][j] < L)
						answer++;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void bfs(int r, int c, int level) {
		Queue<int []> q = new LinkedList<int[]>();
		depth[r][c] = 0;
		visited[r][c] = true;
		q.add(new int [] {r,c});
		
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			// 현재 방향에서 가야하는 방향 d 
			for (int d : checkDir.get(map[cr][cc])) {
				//다음 방향 
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				//범위 넘어가면 컨티뉴 
				if(nr < 0 || N <= nr || nc < 0 || M <= nc )
					continue;
				//이미 방문했거나 맵에서 갈 수 없는 곳이면 컨티뉴
				if(visited[nr][nc] || map[nr][nc] == 0)
					continue;
				// 다음 방향이 가도 되는곳이 아니면 컨티뉴
				// 구조물, 방향 (1,0)
				if( !isChangeable(map[nr][nc],d))
					continue;
				// 전부 통과했다면 방문체크 & 레벨 늘려준 후 큐에 넣기
				visited[nr][nc] = true;
				depth[nr][nc] = depth[cr][cc] + 1;
				if(depth[nr][nc] == L) return; // L에 도달하면 bfs 종료
				q.add(new int [] {nr,nc});
				
			}
		}
	}
	static int[] opposite = {1, 0, 3, 2};  // 반대
	private static boolean isChangeable(int pipeType, int from) {
	    // 도착지점에서의 방향은 반대 방향이 연결되어 있어야 함
	    int requiredDir = opposite[from];
	    int[] nextDirs = checkDir.get(pipeType);
	    
	    for (int dir : nextDirs) {
	        if (dir == requiredDir) return true;
	    }
	    return false;
	}
}
