package Algorithm_Study.daily.PJE;
import java.util.Scanner;
// SWEA 햄스터
public class D20250407 {
	static int N,X,M;
	static int [] cages;
	static int [][] records;
	static int [] answer;
	static int maxTotal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 햄스터 우리 수 
			X = sc.nextInt(); // 최대 햄스터 수 
			M = sc.nextInt(); // 남긴 기록 수
			
			cages = new int [N];
			records = new int [M][3];
			maxTotal = -1;
			
			for (int i = 0; i < M; i++) {
				int l = sc.nextInt()-1; // l번 우리 부터
				int r = sc.nextInt()-1; // r번 우리 까지
				int s = sc.nextInt(); // s마리였다 
				
				records[i][0] = l;
				records[i][1] = r;
				records[i][2] = s;
			}
			
			answer = new int [N];
			
			// 한 우리에 최대햄스터(X)까지 늘려보면서 
			// 중복순열로 우선 배치 후
			// l부터 r까지 합이 s마리라는 조건이 맞는지 확인
			dfs(0);

			System.out.print("#"+tc+" ");
			if (maxTotal == -1) {
				System.out.print("-1");
			} else {
				for (int i = 0; i < N; i++) {
					System.out.print(answer[i] + " ");
				}
			}
			System.out.println();
		}
	}
	
	// 중복 순열 
	private static void dfs(int depth) {
		if(depth == N) { // 최대 우리 수에 도달하면 조건 확인
			if(check()) {
				int total = 0;
				for (int i = 0; i < N; i++) { 
					total+= cages[i];
				}
				if(total > maxTotal) {
					maxTotal = total;
					for (int i = 0; i < N; i++) { 
						answer [i] = cages[i];
					}
				}
			}
			return;
		}
		
		for (int i = 0; i <= X; i++) { // 최대햄스터 수까지 올리면서 cage에 넣을 수 있음
			cages[depth] = i;
			dfs(depth+1);
		}
	}


	private static boolean check() {
		for (int i = 0; i < M; i++) {
			int l = records[i][0];
			int r = records[i][1];
			int s = records[i][2];

			int sum = 0;
			for (int j = l; j <= r; j++) {
				sum += cages[j];
			}
			if (sum != s) {
				return false;
			}
		}
		return true;
	}
}
