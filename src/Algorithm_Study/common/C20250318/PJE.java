package Algorithm_Study.common.C20250318;

import java.util.Arrays;
import java.util.Scanner;

public class PJE {
	static int N;
	static int[] queen; //열
	static boolean[] visit;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			queen = new int [N];
			visit = new boolean [N];
			answer = 0;
			putQueen(0);
			System.out.println("#"+tc+" "+answer);
		}
		
	}
	private static void putQueen(int level) {
		if(level== N) {
			answer++;
			return;
		}
		
		
		i: for (int i = 0; i < N; i++) {  // 앞으로 놓을 자리
		    for (int j = 0; j < level; j++) {  // 이미 놓은 자리
		        if (Math.abs(queen[j] - i) == Math.abs(level - j)) {
		            continue i;  // 대각선 충돌 시 다음 열로 이동
		        }
		    }

		    if (visit[i]) continue; 

		    visit[level] = true;  
		    putQueen(level + 1); 
		    visit[level] = false;
		}
		
	}
	
}
