package Algorithm_Study.daily.PJE;

import java.util.Arrays;
import java.util.Scanner;

public class 공통조상 {
	static int[] tree;
	static int[] leftChild;
	static int[] rightChild;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] str = sc.nextLine().split(" ");
			int V = Integer.parseInt(str[0]);
//			int E = Integer.parseInt(str[1]);
			int n1 = Integer.parseInt(str[2]);
			int n2 = Integer.parseInt(str[3]);

			tree = new int[V + 1];
			leftChild = new int[V + 1];
			rightChild = new int[V + 1];
			// 1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 10 6 11 11 13 저장
			String[] str2 = sc.nextLine().split(" ");
			
			// 왼쪽 오른쪽 자식 노드 저장
			for (int i = 0; i < str2.length; i += 2) {
				int parent = Integer.parseInt(str2[i]);
				int child = Integer.parseInt(str2[i + 1]);
				
				if (leftChild[parent] == 0) {
					leftChild[parent] = child;
				} else {
					rightChild[parent] = child;
				}
			}

			// 각 노드의 부모 저장
			for (int i = 1; i <= V; i++) {
				if (leftChild[i] != 0) {
					tree[leftChild[i]] = i;
				}
				if (rightChild[i] != 0) {
					tree[rightChild[i]] = i;
				}
			}

			int commonAncestor = findAncestor(1, n1, n2); //가장 가까운 조상 
			int subtreeSize = getSubtreeSize(commonAncestor); //조상을 루트로 하는 서브트리
			System.out.println("#" + tc + " " + commonAncestor + " " + subtreeSize);
		}
	}

	static int getSubtreeSize(int root) {
		if (root == 0)
			return 0;
		return 1 + getSubtreeSize(leftChild[root]) + getSubtreeSize(rightChild[root]);
	}

	static int findAncestor(int root, int n1, int n2) {
		// 종료 조건: 빈 노드거나 n1 또는 n2와 같으면 현재 노드를 반환
		if (root == 0)
			return 0;
		if (root == n1 || root == n2)
			return root;

		// 왼쪽과 오른쪽 서브트리에서 공통 조상 탐색
		int leftResult = findAncestor(leftChild[root], n1, n2);
		int rightResult = findAncestor(rightChild[root], n1, n2);

		// 두 서브트리 모두에서 값이 반환되면 현재 노드가 공통 조상
		if (leftResult != 0 && rightResult != 0)
			return root;

		// 한쪽에서만 값을 반환하면 그 값을 전파
		return (leftResult != 0) ? leftResult : rightResult;
	}
}
