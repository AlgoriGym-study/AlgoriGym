package Algorithm_Study.daily.PJE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//총 환경 부담금을 최소로 지불하며, N개의 모든 섬을 연결할 수 있는 교통 시스템을 설계하세요.
//환경부담금 정책 : 환경부담세율(E)와 해저터널길이(L)의 제곱의 곱(E*L^2)만큼 지불

//SWEA 하나로
public class D20250327 {
	static int[] p;
	
	static class Edge implements Comparable<Edge> {

		int s; //시작노드
		int e; //끝노드
		double cost; //비용

		public Edge(int s, int e, double cost) {
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
			return Double.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 섬의 개수
			int[] x = new int[N]; // x좌표
			int[] y = new int[N]; // y좌표

			// x,y 좌표 저장
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}

			double E = sc.nextDouble(); // 환경 부담 세율 실수

			// Edge 리스트 만들기
			List<Edge> edgeList = new ArrayList<>();
			
			// N개의 섬 중 2개를 뽑아서 섬 사이 거리와 비용 계산
			for (int i1 = 0; i1 < N; i1++) {
				for (int j = i1 + 1; j < N; j++) {
					long dx = x[i1] - x[j];
					long dy = y[i1] - y[j];
					long distance = dx * dx + dy * dy;
					double cost = E * distance;
					edgeList.add(new Edge(i1, j, cost));
				}
			}
			
			Collections.sort(edgeList);
			
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			double totalCost = 0;
			int edgeCount = 0;

			for (Edge edge : edgeList) {
				if (findSet(edge.s) != findSet(edge.e)) {
					
					union(edge.s, edge.e);
					totalCost += edge.cost;
					edgeCount++;
					if (edgeCount == N - 1)
						break;
					
				}

			}

			System.out.println("#" + tc + " " + Math.round(totalCost));
		}
	}

	// 두 집합 합치기 
	static void union(int x, int y) {
		p[findSet(y)] = p[x];
	}
	
	// 부모 찾기(경로압축)
	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
//		
//		if(x==p[x]) return p[x];
//		else return findSet(p[x]);
//		
	}
}
