package Algorithm_Study.daily.PJE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
// 백준 단지번호 붙이기
public class D20250330 {
	
	static int N,houses,danji;
	static int [][] map;
	static boolean [][] visited;
	static int answer;
	static int []dr = {-1,1,0,0};
	static int []dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정사각형 크기
		map = new int[N][N];
		visited = new boolean[N][N];
		danji = 0; // 단지 개수 저장
		List<Integer> h = new ArrayList<Integer>(); // 각 단지당 집의 개수 저장
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j]= str.charAt(j)-'0';
			}
 		}
		//입력

		// dfs 시작할때마다 단지개수 늘어남 , 각 단지 내부에서 집의 개수 늘어남
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					houses = 0;
					danji++;
					dfs(i,j);
					h.add(houses);
				}
			}
		}
		Collections.sort(h); //정렬
		System.out.println(danji);
		for (int i = 0; i < h.size(); i++) {
			System.out.println(h.get(i));
		}
	}

	private static void dfs(int x, int y) {
		Stack<int[]> stack = new Stack<int[]>();
		visited[x][y] = true;
		stack.push(new int[] {x,y});
		
		while(!stack.isEmpty()) {
			int []now = stack.pop();
			houses++;
			int r = now[0];
			int c = now[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(N <= nr || nr <0 || N <= nc || nc < 0 )
					continue;
				if(visited[nr][nc] || map[nr][nc] == 0)
					continue;
				
				visited[nr][nc]=true;
				stack.push(new int[] {nr,nc});
			}
		}
		
	}
}
