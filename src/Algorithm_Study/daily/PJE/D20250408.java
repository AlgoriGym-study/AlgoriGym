package Algorithm_Study.daily.PJE;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// SWEA 파핑파핑 지뢰찾기
public class D20250408 {
	static int N;
	static char [][] map;
	static boolean [][] visited;
	static int [] dr = {-1,-1,-1,0,0,1,1,1};
	static int [] dc = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new char [N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < map.length; i++) {
				String str = sc.next();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			// 입력
			
			// bfs + 그리디
			// 지뢰가 있는 칸을 제외한 다른 모든 칸의 숫자들이 표시되려면 최소 몇번의 클릭을 해야하는가?
			// 클릭하면 8방향의 지뢰가 숫자로 표기됨. 
			// 우선 지뢰 숫자를 채워두기 
			// 0인곳부터 누르면서 bfs 수행해보기 
			// 이후 나머지 클릭 
			// bfs 들어갈 때마다 클릭 수 늘려주기
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j]=='.'){
						putNums(i,j); //숫자 채워주기
					}
				}
			}
			
			int clicks = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(!visited[i][j] && map[i][j]=='0'){
						clicks++;
						bfs(i,j);
					}
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(!visited[i][j] && map[i][j]!='*'){
						clicks++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+clicks);
		}
	}
	
	private static void bfs(int i, int j) {
		Queue<int []> q = new LinkedList<>();
		visited[i][j] = true;
		q.add(new int [] {i,j});
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			if(map[r][c]!='0')
				continue;
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(N <= nr || nr < 0 || N<= nc || nc <0)
					continue;
				if(visited[nr][nc] || map[nr][nc]=='*')
					continue;

				visited[nr][nc] = true;
				q.add(new int [] {nr,nc});
			}
		}
	}

	private static void putNums(int r, int c) {
		int num = 0;
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(N <= nr || nr < 0 || N<= nc || nc <0)
				continue;
			if(map[nr][nc]=='*')
				num++;
		}
		
		map[r][c] =  (char)(num+'0');
		
	}
}
