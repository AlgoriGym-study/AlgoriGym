package Algorithm_Study.common.C202503.C20250320;
import java.util.Scanner;

public class LYW {
	// 트리의 노드 개수와 간선 개수를 저장하는 변수
	static int V; // 정점 개수
	static int E; // 간선 개수
	static int subtree; // 공통 조상을 루트로 하는 서브트리 크기
	static Node[] tree; // 노드 정보를 저장하는 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수 입력

		for (int tc = 1; tc <= T; tc++) {
			V = sc.nextInt(); // 정점 개수 입력
			E = sc.nextInt(); // 간선 개수 입력
			int first = sc.nextInt(); // 공통 조상을 찾을 첫 번째 노드
			int second = sc.nextInt(); // 공통 조상을 찾을 두 번째 노드

			tree = new Node[V + 1]; // 인덱스가 1부터 시작하도록 배열 생성

			// 간선 정보를 입력받아 트리 구성
			for (int i = 0; i < E; i++) {
				int index = sc.nextInt(); // 부모 노드
				int child = sc.nextInt(); // 자식 노드

				// 부모 노드가 존재하지 않으면 새로 생성
				if (tree[index] == null)
					tree[index] = new Node(index);

				// 부모 노드에 자식 추가
				tree[index].addChild(child);

				// 자식 노드가 존재하지 않으면 새로 생성
				if (tree[child] == null)
					tree[child] = new Node(child);

				// 자식 노드에 부모 정보 저장
				tree[child].parent = index;
			}

			// 첫 번째 노드의 깊이(Level) 찾기
			int fLevel = 0;
			int f = first;
			while (f != 1) { // 루트(1)까지 올라가면서 깊이 증가
				fLevel++;
				f = tree[f].parent;
			}

			// 두 번째 노드의 깊이(Level) 찾기
			int sLevel = 0;
			int s = second;
			while (s != 1) { // 루트(1)까지 올라가면서 깊이 증가
				sLevel++;
				s = tree[s].parent;
			}

			// 깊이를 맞춘 후, 최소 공통 조상(LCA) 찾기
			while (fLevel != sLevel) {
				if (fLevel > sLevel) { // 첫 번째 노드가 더 깊다면 부모로 이동
					fLevel--;
					first = tree[first].parent;
				} else if (fLevel < sLevel) { // 두 번째 노드가 더 깊다면 부모로 이동
					sLevel--;
					second = tree[second].parent;
				}
			}

			// 깊이가 동일해진 상태에서 공통 조상 찾기
			while (first != second) { // 두 노드가 같아질 때까지 부모로 이동
				first = tree[first].parent;
				second = tree[second].parent;
			}

			// 찾은 공통 조상을 루트로 하는 서브트리 크기 계산
			subtree = 0;
			countSubtree(first); // 공통 조상 노드를 루트로 하여 서브트리 크기 계산

			// 결과 출력
			System.out.printf("#%d %d %d\n", tc, first, subtree);
		}
		sc.close(); // 입력 닫기
	}

	// DFS를 이용하지 않고 서브트리 크기 계산 (재귀 방식)
	static void countSubtree(int v) {
		if (v <= V) { // 유효한 노드인지 확인
			if (tree[v] != null) { // 노드가 존재하면
				subtree++; // 서브트리 크기 증가
				countSubtree(tree[v].left); // 왼쪽 자식 탐색
				countSubtree(tree[v].right); // 오른쪽 자식 탐색
			}
		}
	}
}

// 트리의 각 노드를 표현하는 클래스
class Node {
	int data; // 노드 번호
	int left = 0; // 왼쪽 자식 노드
	int right = 0; // 오른쪽 자식 노드
	int parent = 0; // 부모 노드

	// 노드 생성자
	public Node(int data) {
		this.data = data;
	}

	// 자식 노드 추가하는 메서드
	public void addChild(int child) {
		if (left == 0) { // 왼쪽 자식이 비어 있다면 추가
			this.left = child;
		} else if (left > child) { // 왼쪽 자식보다 작은 값이면
			right = left; // 기존 왼쪽 자식을 오른쪽으로 이동
			left = child;
		} else { // 기존 왼쪽 자식보다 크면 오른쪽에 추가
			right = child;
		}
	}
}
