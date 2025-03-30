package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250316 {
	static int N;
	static int[][] synergy;
	static boolean[] selected;
	static int minDiff;
	
	public static void main(String args[]) throws Exception {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int T = Integer.parseInt(br.readLine());

	for(int test_case = 1; test_case <= T; test_case++) {
		N = Integer.parseInt(br.readLine());
		synergy = new int[N][N];
		selected = new boolean[N];
		minDiff = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 0; j < N; j++) synergy[i][j] = Integer.parseInt(input[j]);
		}
		
		comb(0, 0);
	
		sb.append("#").append(test_case).append(" ").append(minDiff).append("\n");
	}
	br.close();
	System.out.print(sb);
	}
	
	public static void comb(int idx, int cnt) {
		if(cnt == N / 2) {
			int a = 0;
			int b = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					
					if(selected[i] && selected[j]) a += synergy[i][j];
					else if(!selected[i] && !selected[j]) b += synergy[i][j];
				}
			}
			int diff = Math.abs(a - b);
			minDiff = (minDiff > diff) ? diff : minDiff;
			return;
			}
	
	if(idx == N) return;
	selected[idx] = true;
	comb(idx+1, cnt+1);
	selected[idx] = false;
	comb(idx+1, cnt);
}
}
