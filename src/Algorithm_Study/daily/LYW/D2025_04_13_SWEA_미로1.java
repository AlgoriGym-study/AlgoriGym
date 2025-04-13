package Algorithm_Study.daily.LYW;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D2025_04_13_SWEA_미로1 {
	static int[][] maze;
	static int[][] visited;
	static int N = 16;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt(); // 테스트케이스
			
			maze = new int[N][N];
			visited = new int[N][N];
			
			char[][] arr = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					maze[i][j] = arr[i][j] - '0';
				}
			}
			
			int ans = bfs(1,1);
			
			System.out.println("#" + tc + " " + ans);
			
		}// tc
	}// main

	static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			// 도착지점에 도착한 경우
			if(curr[0] == 13 && curr[1] == 13) {
				return 1;
			}
			
			// 4방향 탐색
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				// 배열 벗어난 경우
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				// 벽을 만난 경우
				if(maze[nr][nc] == 1) continue;
				// 거리가 결정된 경우
				if(visited[nr][nc] != 0) continue;
				
				// 갈수있는 경우
				visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
				q.add(new int[] {nr, nc});
				}
			}
			
		return 0;

	}
}
