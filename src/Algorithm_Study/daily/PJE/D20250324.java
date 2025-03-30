package Algorithm_Study.daily.PJE;

import java.util.Scanner;
// 백준 연결요소의 개수
public class D20250324 {
	static int [][] graph;
	static boolean [] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //정점의 개수 
		int M = sc.nextInt(); //간선의 개수
		
		graph = new int [N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		//입력

		int answer = 0;
		for (int i = 1; i <= N ; i++) {
			if(!visited[i]) {
				answer ++;
				dfs(i);
			}
		}
//		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(graph[i][j]+" ");
//			}
//			System.out.println();
//		}
	System.out.println(answer);
	}

	private static void dfs(int root) {
		if(visited[root]) return;
		
		visited[root] = true;
		
		for (int i = 1; i < graph.length; i++) {
			if(!visited[i]&&graph[root][i]==1) {
				dfs(i);
			}
		}
		
		
	}
}
