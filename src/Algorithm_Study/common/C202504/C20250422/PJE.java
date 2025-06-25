package Algorithm_Study.common.C202504.C20250422;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PJE {
	static char [][] map;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new char [12][6];
		for (int i = 0; i < 12; i++) {
			String str = sc.next();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 맵 입력
		
		int cnt=0;
		while(true) {
			boolean popped = false;
			
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(map[i][j]!='.') {
						if ( bfs(i,j)) { // 참을 반환하면 연쇄가 일어났다는 뜻
							popped = true;
						}
					}
				}
			}
			// 터진게 없으면 종료
			if(!popped ) break;
			// 중력 적용(위에 뿌요가 떨어짐)
			applyGravity();
			cnt++;
		}
		
		
		System.out.println(cnt);
	}	
	// 중력 처리 : '.' 아닌 뿌요들 아래로 떨어뜨림
	private static void applyGravity() {
	    for (int col = 0; col < 6; col++) {
	        Queue<Character> q = new LinkedList<>();
	        
	        // 아래에서 위로 탐색하며 뿌요를 큐에 담고 맵 .으로 만들기
	        for (int row = 11; row >= 0; row--) {
	            if (map[row][col] != '.') {
	                q.add(map[row][col]);
	                map[row][col] = '.';
	            }
	        }
	        
	        // 아래부터 큐에 있는 뿌요 채워넣음 
	        int row = 11;
	        while (!q.isEmpty()) {
	            map[row--][col] = q.poll();
	        }
	    }
	}


	private static boolean bfs(int i, int j) {
		
		boolean [][] visited = new boolean[12][6];
		Queue<int []> q = new LinkedList<int[]>();
		List<int[]>connected = new ArrayList<>();
		
		char color = map[i][j]; // 시작 뿌요
		q.add(new int [] {i,j});
		visited[i][j] = true;
		connected.add(new int [] {i,j});
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			int r = now[0];
			int c = now[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || 12 <= nr || nc < 0 || 6 <= nc)
					continue;
				if(visited[nr][nc] || map[nr][nc]!=color)
					continue;
				visited[nr][nc] = true;
				connected.add(new int[] {nr,nc});
				q.add(new int [] {nr,nc});
			}
		}
		// 뿌요 4개 이상이면 터뜨림
		if(connected.size() >= 4) {
			for(int[] pos : connected) {
				map[pos[0]][pos[1]] = '.';
			}
			return true;
		}
		return false;
		
	}
}









