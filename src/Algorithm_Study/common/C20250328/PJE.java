package Algorithm_Study.common.C20250328;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 백준 키순서 
public class PJE {
	static List<Integer> [] graph;
	static List<Integer> [] reverseGraph;
	static boolean [] visited;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 노드 개수
		int M = sc.nextInt(); // 간선 개수
		
		graph = new ArrayList[N+1];
		reverseGraph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
			reverseGraph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			//a번 학생이 b번 학생보다 키가 작음 
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b); // 방향이 있는 그래프
			reverseGraph[b].add(a);
		}
//		for (List<Integer> list : graph) {
//			System.out.println(list);
//		}
		// 노드가 전부 연결되어있으면 키가 몇번째인지 알 수 있음. 
		visited = new boolean[N+1];
		
		ans = 0;
		
		 for (int i = 1; i <= N; i++) {
	            // 나보다 키 큰 사람 수
	            visited = new boolean[N + 1];
	            int taller = dfs(graph, i);

	            // 나보다 키 작은 사람 수
	            visited = new boolean[N + 1];
	            int shorter = dfs(reverseGraph, i);

	            if (taller + shorter == N - 1) {
	                ans++; // 정확한 순서를 알 수 있음
	            }
	        }

		//자신의 키가 몇번째인지 알 수 있는 학생이 모두 몇명인지 출력
		System.out.println(ans);
	}
	
	static int dfs(List<Integer>[] g ,int node) {
		
		visited[node] = true;
		 int count = 0;
	        for (int next : g[node]) {
	            if (!visited[next]) {
	                count += 1 + dfs(g, next);
	            }
	        }
	        return count;
		
	}
}
