package Algorithm_Study.daily.PJE;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D20250402 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 건물 수 
			int K = sc.nextInt(); // 규칙 개수
			
			int [] time = new int [N+1];
			int [][] building = new int [N+1][N+1];
			int [] indegree = new int[N+1];
			int [] dist = new int [N+1];
			
			for (int i = 1; i <= N; i++) {
				int S = sc.nextInt(); // 시간
				time[i] = S;
			}
			
			for (int i = 1; i <= K; i++) {
				int X = sc.nextInt(); // 건설 순서
				int Y = sc.nextInt();
				
				building[X][Y] = 1; // 두 건물 연결, 가중치 1
				indegree[Y]++; // 들어오는 곳 간선 늘려주기
			}
			
			int W = sc.nextInt(); // 지어야 할 건물 번호
			
			Queue<Integer> q = new LinkedList<Integer>();
			// 1. 간선 중 0인 곳 큐에 넣어주기 
			for (int i = 0; i < indegree.length; i++) {
				if(indegree[i] == 0) {
					dist[i] = time[i]; // 간선이 0이면 건설시간 온전히 더해줘야 함.
					q.add(i);
				}
			}
			
			// 2. 큐에서 꺼내면서 진출 간선 하나씩 줄여주고 0이 되면 다시 큐에 넣기 
			while(!q.isEmpty()) {
				int n = q.poll();
				
				if(n==W) break; // 큐에서 꺼냈는데 건설할 건물이면 그만하기
				
				for (int to = 1; to <= N; to++) {
					if(building[n][to] == 1) {
						//가야할 곳의 가중치 = 이전가중치 + 내 원래 가중치(시간)
						//근데 만약 간선이 여러개 연결되어있을경우
						//값이여러번 바뀌는데 더 큰 값으로 갱신되어야함 ex.4번 노드 
						// 110 = 10 + 100
						dist[to] = Math.max( dist[n] + time[to], dist[to]);
						indegree[to]--;
						
						if(indegree[to] == 0) {
							q.add(to);
						}
					}
				}
			}
			
			System.out.println(dist[W]);
		}
	}
}