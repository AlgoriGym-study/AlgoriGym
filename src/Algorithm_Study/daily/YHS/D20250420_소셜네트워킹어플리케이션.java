package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250420_소셜네트워킹어플리케이션 {
    static int[] p;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("Scenario " + tc + ":\n");
			
			int N = Integer.parseInt(br.readLine());
			
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				if (findSet(u) == findSet(v))
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void union(int u, int v) {
		u = findSet(u);
		v = findSet(v);
		
		if (u == v) return;
		
		if (u >= v)
			p[u] = v;
		else
			p[v] = u;
	}
	
	static int findSet(int v) {
		if (p[v] == v) return v;
		return p[v] = findSet(p[v]);
	}
}
