package Algorithm_Study.common.C20250411;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//행렬찾기
public class PJE {

	static int[][] map; //맵
	static int[][] depth; //깊이 
	static boolean[][] visited; //방문 

	//상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n; //크기
	
	static class SubMatrix implements Comparable<SubMatrix>{
		
		int size; // SubMatrix 내부 개수 
		int depth; // 깊이 (행)
		int width; // 가로길이 (열) 
		
		public SubMatrix(int size, int depth, int width) {
			this.size = size;
			this.depth = depth;
			this.width = width;
		}

		@Override
		public int compareTo(SubMatrix o) {
			// 사이즈가 작은 순서로 정렬,  
			// 사이즈 같을 시 행이 더 짧은 순서로 정렬
			if(this.size < o.size) 
				return -1;
			else if (this.size == o.size)
				return Integer.compare(this.depth, o.depth);
			else 
				return 1;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			List<SubMatrix> sm = new ArrayList<>();
			
			map = new int[n][n];
			visited = new boolean[n][n];
			depth = new int [n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 입력
			int smNum = 0; // 부분매트릭스 개수
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					if (map[i][j] != 0 && !visited[i][j]) {
						size = 1; //각 부분매트릭스 내부의 사이즈
						maxRow = minRow = i;
						maxCol = minCol = j;
						smNum++;
						bfs(i, j);
//						System.out.println(smNum + " "+ size+" "+ maxRow+" "+minRow+maxCol+" "+minCol);
						sm.add(new SubMatrix(size, (maxRow - minRow +1), (maxCol - minCol+1)));
					}
				}
			}
			
			Collections.sort(sm);
			
			System.out.print("#" + tc + " " + smNum +" ");
			for (SubMatrix subMatrix : sm) {
				System.out.print(subMatrix.depth+ " " +subMatrix.width +" ");
			}
			System.out.println();
		}
	}
	static int size;
	static int maxRow,minRow;
	static int maxCol,minCol;
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[i][j] = true;
		int depth = i;
		int width = j;
		q.add(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if( n <= nr  || nr < 0 || n <= nc || nc < 0)
					continue;
				if( visited[nr][nc] || map[nr][nc] == 0 )
					continue;
				
				visited[nr][nc] = true;
				size++;
				
				depth = nr;
				width = nc;
				//행렬을 찾기위해 가장 큰 행열 / 가장 작은 행열 숫자 구하기 
				if(maxRow < depth)
					maxRow = depth;
				if(depth < minRow)
					minRow = depth;
				
				if(maxCol < width)
					maxCol = width;
				if(width < minCol)
					minCol = width;
				
				
				q.add(new int [] {nr,nc});
			}
		}
	}
}
