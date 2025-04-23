package Algorithm_Study.daily.PJE;
public class D20250422 {
	public static void main(String[] args) {
		Sol s = new Sol();
		String ans = s.solution(2,2,1,1,2,2,2);
		System.out.println(ans);
	}
}

class Sol {
	// n X m 격자미로 , (x,y)에서 출발 해서 (r,c)로 탈출. 거리가 총 k일때만 가능, 같은 격자를 두번 이상 방문해도됨
	// end로 갈 수 있는 모든 경우의 수 dfs로 탐색, 거리가 k인 경우만 확인
	// 문자열이 사전 순으로 가장 빠른 경로로 탈출해야 함
	int [] dr = {1,0,0,-1};
	int [] dc = {0,-1,1,0};
	//사전순 보장
	String[] dirName = {"d","l","r","u"};
	String answer;
	int N,M,X,Y,R,C,K;
	
	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		int dist = Math.abs(x - r) + Math.abs(y - c);
		if(k < dist || (k - dist) % 2 == 1) 
			return "impossible";
		N = n;
		M = m;
		X = x-1;
		Y = y-1;
		R = r-1;
		C = c-1;
		K = k;
	
		answer = "";
		dfs(X,Y,0,answer);
		return (answer.length() == K) ? answer : "impossible";
	}
	
	private void dfs(int x, int y, int depth,String path) {
		if(!answer.equals("")) return; //정답 찾았으면 중단
		if ( depth == K) {
			if(x == R && y ==C) {
				answer = path;
			}
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = x + dr[d];
			int nc = y + dc[d];
			
			if(0<=nr && nr < N && 0<=nc && nc < M ) {
				
				//남은 거리 
				int remain = Math.abs(nr-R) + Math.abs(nc - C);
				if(remain <= K-depth-1)
					dfs(nr,nc,depth+1,path+dirName[d]);
			}
		}
	}
		
	
}
