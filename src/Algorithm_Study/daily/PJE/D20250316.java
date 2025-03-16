package Algorithm_Study.daily.PJE;
import java.util.Arrays;
import java.util.Scanner;
//조합.
public class D20250316 {
	static int N,M,ans;
	static int[] AIdx,BIdx;
	static boolean [] visitA;
	static int [][] food;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //식재료 수
			M = N/2;
			AIdx = new int[M];
			BIdx = new int[M];
			visitA = new boolean[N];
			food = new int [N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					food[i][j] = sc.nextInt();
				}
			}
			
			//입력
			ans = Integer.MAX_VALUE;
			comb(0,0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	//조합구하기
	private static void comb(int level,int tmpIdx) {
		
		if(tmpIdx==M) { //조합
			calSinergy();
			return;
		}
		if(level==N) {
			return;
		}
		
		AIdx[tmpIdx] = level;
		visitA[level] = true;
		comb(level+1,tmpIdx+1);

		visitA[level] = false;
		comb(level+1,tmpIdx);
		
	}
	//시너지 계싼
	private static void calSinergy() {
		//B인덱스 채우기 
		int idx = 0;
		int A=0,B=0;
		for (int i = 0; i < N; i++) {
			if(!visitA[i]) {
				BIdx[idx++] = i;
			}
		}
		
		
		//A인덱스로 A 시너지, B 시너지의 합 구하기
		for (int i = 0; i < M; i++) {
			for (int j = i+1; j < M; j++) {
					A+=food[AIdx[i]][AIdx[j]]+food[AIdx[j]][AIdx[i]];
					B+=food[BIdx[i]][BIdx[j]]+food[BIdx[j]][BIdx[i]];
			}
		}
//		System.out.println("A시너지"+A);
//		System.out.println("B시너지"+B);
		//두 시너지의 차이중 제일 작은 값 구하기
		ans = Math.min(Math.abs(A-B), ans);
	}
}


