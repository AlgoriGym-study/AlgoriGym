package Algorithm_Study.daily.PJE;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 미로탈출	
public class D20250420 {
    static int N,M;
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static char [][] map;

    static class Point{
    	int nx,ny;

		public Point(int nx, int ny) {
			this.nx = nx;
			this.ny = ny;
		}
    	
    }
	public int solution(String[] maps) {
    	N = maps.length;
    	M = maps[0].length();
    	map = new char [N][M];
    	Point start = null, end = null, lever = null;
    	for (int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j ++) {
    			map[i][j] = maps[i].charAt(j);
    			if(map[i][j] == 'S') {
    				start = new Point(i, j);
    			}else if(map[i][j] == 'L') {
    				lever = new Point(i, j);
    			} else if (map[i][j] == 'E') {
    				end = new Point(i, j);
    	        }
    		}
		}
    	// 맵 정보 저장 
    		int StoL = bfs(start,lever);
    	    int LtoE = bfs(lever,end);
    	    if(StoL == -1 || LtoE == -1)
    	    	return -1;
    	    return StoL + LtoE;
	}

	private int bfs(Point start, Point end) {
		int [][] dist = new int [N][M];
		Queue<Point> q = new LinkedList<>();
		dist[start.nx][start.ny] = 1;
		q.add(start);
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.nx + dr[d];
				int nc = now.ny + dc[d];
				if(nr < 0 || nc <0 || N <= nr || M <= nc )
					continue;
				if(0 < dist[nr][nc])
					continue;
				if(map[nr][nc]=='X')
					continue;
				dist[nr][nc] = dist[now.nx][now.ny]+1;
				if(nr == end.nx && nc == end.ny)
					return dist[nr][nc]-1;
				q.add(new Point(nr, nc));
			}
		}
		return -1;
	}

}



