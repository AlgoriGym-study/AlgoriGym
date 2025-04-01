import java.io.*;
import java.util.*;

public class D20250328_단지번호붙이기 {
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, count;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<Integer> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = new ArrayList<>();
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs(i,j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		Collections.sort(ans);
		
		for (int num : ans) {
			System.out.println(num);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x,y));
		visit[x][y] = true;
		int num = 1;
		
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			int row = curr.x;
			int col = curr.y;
			
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (!visit[nr][nc] && map[nr][nc] == 1) {
						visit[nr][nc] = true;
						num++;
						q.add(new Pos(nr,nc));
					}
				}
			}
		}
		
		ans.add(num);
	}
	
}
