package Algorithm_Study.daily.PJE;
import java.util.Arrays;
import java.util.Scanner;

public class D20250331 {
	static int p[];
	
	static class Edge implements Comparable<Edge>{
		int s,e,cost;

		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점 수 
		int E = sc.nextInt(); // 간선 수
		Edge e [] = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			e[i] = new Edge(a, b, c);
		}
		
		Arrays.sort(e); //가중치 기준 정렬
		
		p = new int [V+1];
		
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		int pick = 0;
		int ans = 0;
		
		for (int i = 0; i < E; i++) {
			int px = findSet(e[i].s);
			int py = findSet(e[i].e);
			if(px != py) {
				union(px,py);
				pick++;
				ans += e[i].cost;
			}
			if(pick == (V-1))
				break;	
		}
		
		System.out.println(ans);
		
	}

	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	private static int findSet(int x) {
		if(x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
}






