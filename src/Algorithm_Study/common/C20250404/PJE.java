package Algorithm_Study.common.C20250404;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
// 백준 택배배송
public class PJE {
	static int INF = Integer.MAX_VALUE;
	static class Barn implements Comparable<Barn>{
		int e,cost;

		public Barn( int e, int cost) {
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Barn o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 헛간 수
		int M = sc.nextInt(); // 소길
		//각 길에는 C마리의 소가 있음 
		//소들의 길은 두새의 떨어진 헛간인 A와 B를 이음
		
		List<Barn> []list = new ArrayList[N+1]; //헛간배열
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int [] dist = new int [N+1]; //최소비용을 누적할 배열
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt(); // 헛간 노드
			int B = sc.nextInt(); // 헛간 노드
			int C = sc.nextInt(); // 소
			
			list[A].add(new Barn(B,C));
			list[B].add(new Barn(A,C));
		}
		
		// 시작점이 1, 끝점이 N. 
		// 시작정점이 주어지고 음수 가중치 X 최소비용을 구하는 문제이므로 다익스트라
		PriorityQueue<Barn> pq = new PriorityQueue<>();
		
		pq.add(new Barn(1,0)); //1에서 출발
		dist[1] = 0; //1 가중치 0
		
		while(!pq.isEmpty()) {
			Barn current = pq.poll();
			int curr = current.e;
			int cost = current.cost;
			
			if(dist[curr] < cost) continue;
			
			for (Barn next : list[curr]) {
				int nextBarn = next.e;
				int newCost = cost+next.cost;
				
				if(newCost < dist[nextBarn]) {
					dist[nextBarn] = newCost;
					pq.add(new Barn(nextBarn,newCost));
				}
			}
			
		}
		System.out.println(dist[N]);
		
	}
}
