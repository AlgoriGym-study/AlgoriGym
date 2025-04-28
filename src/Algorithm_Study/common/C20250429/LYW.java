package Algorithm_Study.common.C20250429;

import java.util.*;

//구조대원이 최소 에너지로 목표 지점에 도달하는 문제
public class LYW {
	static int N; // 지형의 크기 (NxN)
	static int[][] map; // 고도 정보
	static int[][] dist; // 최소 에너지 비용 저장
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우 방향 벡터
	static int[] dc = { 0, 0, -1, 1 };

	// 우선순위 큐에서 사용할 노드 클래스 (비용 기준으로 정렬)
	static class Node implements Comparable<Node> {
		int r, c, cost; // 현재 위치 (r, c)와 누적 비용 cost

		Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost; // 비용이 작은 순서로 정렬
		}
	}

	// 다익스트라 알고리즘 구현 (최소 비용 계산)
	public static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = 0; // 시작 지점 (0,0) 비용 0
		pq.offer(new Node(0, 0, 0)); // 시작 노드 추가

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			// 이미 더 짧은 경로로 방문한 경우 스킵
			if (now.cost > dist[now.r][now.c])
				continue;

			// 4방향 탐색 (상하좌우)
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];

				// 지형 범위 안인지 확인
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					int heightDiff = map[nr][nc] - map[now.r][now.c];
					int moveCost;

					// 이동 비용 계산
					if (heightDiff > 0) {
						moveCost = 2 * heightDiff; // 오르막
					} else if (heightDiff == 0) {
						moveCost = 1; // 평지
					} else {
						moveCost = 0; // 내리막
					}

					int newCost = dist[now.r][now.c] + moveCost;

					// 더 적은 비용으로 이동 가능한 경우 업데이트
					if (newCost < dist[nr][nc]) {
						dist[nr][nc] = newCost;
						pq.offer(new Node(nr, nc, newCost));
					}
				}
			}
		}

		return dist[N - 1][N - 1]; // 도착 지점 (N-1, N-1)의 최소 비용 반환
	}

	// 메인 함수 (입력 처리)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			dist = new int[N][N];

			// 입력 받기 및 dist 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					dist[i][j] = Integer.MAX_VALUE; // 초기값 무한대 설정
				}
			}

			int answer = dijkstra(); // 다익스트라 실행
			System.out.println("#" + tc + " " + answer); // 결과 출력
		}

		sc.close();
	}
}
