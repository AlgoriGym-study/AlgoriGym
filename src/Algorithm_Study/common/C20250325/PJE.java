package Algorithm_Study.common.C20250325;
import java.util.Scanner;
// 과목평가 룩과 나이트
public class PJE {
	static int N,M,K,ans;
	static int [][] board;
	
	// 룩 상하좌우
	static int [] rx = {-1,1,0,0};
	static int [] ry = {0,0,-1,1};
	// 나이트 대각선 이동, 수직 수평 이동
	static int [] nx = {-1,-2,-2,-1,1,2,2,1};
	static int [] ny = {-2,-1,1,2,-1,-2,2,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 체스판 크기 N,M
			M = sc.nextInt();
			K = sc.nextInt(); // 이동횟수
			
			ans = 0;
			
			int nr =0, nc = 0; // 나이트 현재위치
			int rr =0, rc = 0; // 룩 현재위치
			
			board = new int [N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					board[i][j] = sc.nextInt();
					if (board[i][j] == 2) {
						// 나이트 위치 저장
						nr = i;
						nc = j;
					}else if(board[i][j] == 1) {
						// 룩 위치 저장
						rr = i;
						rc = j;
					}
				}
			}
			check = new boolean[N][M][N][M];
			move(0, rr, rc, nr, nc);
			System.out.println("#"+tc+" "+ans);
		}
	}
	static boolean check[][][][];
	//K번 아무 기물이나 움직인 후에 룩과 나이트가 위치한 형태의 경우의 수 구하는 프로그램.
	static void move (int root, int rr,int rc,int nr,int nc) { //룩,나이트 순서
		//K번 움직이면 종료됨
		//한번 움직일때마다 나이트와 룩이 번갈아 배치되어야함.
		//둘이 같은 위치에 놓일 수는 없음
		if(root == K) {
			if(!check[rr][rc][nr][nc]) {
				check[rr][rc][nr][nc]=true;
				ans++;
			}
			return;
		}
		//룩움직임
		for (int i = 0; i < 4; i++) {
			int nrr = rr + rx[i];
			int ncc = rc + ry[i];
			
			//범위 안에 있고 룩과 나이트가 같은 위치에 있으면 안됨
			while(0<= nrr && nrr < N && 0<= ncc && ncc < M && !(nrr == nr && ncc == nc ) ) {
				move(root+1,nrr,ncc,nr,nc);
				nrr += rx[i];
				ncc += ry[i];
			}
			
		}
		
		
		//나이트움직임
		for (int i = 0; i < 8; i++) {
			int nnr = nr +nx[i];
			int nnc = nc + ny[i];
			
			if(0<=nnr && nnr <N && 0<=nnc && nnc < M && !(nnr == rr && nnc == rc)) {
				move(root+1,rr,rc,nnr,nnc);
			}
		}
	}
	
}
