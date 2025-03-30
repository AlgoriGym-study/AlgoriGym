package Algorithm_Study.common.C20250320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class YHS {

	static List<Integer> parentList; // 조상들을 담아둘 리스트
	static int[][] tree;
	static int ancestor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			tree = new int[V + 1][3];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				if (tree[parent][1] == 0)
					tree[parent][1] = child;
				else
					tree[parent][2] = child;
				tree[child][0] = parent;
			}

			parentList = new ArrayList<>();
			findAncestor(tree[A][0], tree[B][0]);
			System.out.printf("#%d %d %d\n", tc, ancestor, measureSize(ancestor));
		}
	}

	public static void findAncestor(int p1, int p2) {
		if (p1 != 0 && parentList.contains(p1)) {
			ancestor = p1;
			return;
		} else if (p2 != 0 && parentList.contains(p2) || p1 == p2) {
			ancestor = p2;
			return;
		}

		parentList.add(p1);
		parentList.add(p2);
		findAncestor(tree[p1][0], tree[p2][0]);
	}

	public static int measureSize(int p) {
		int size = 0;

		if (tree[p][1] != 0)
			size += measureSize(tree[p][1]);
		if (tree[p][2] != 0)
			size += measureSize(tree[p][2]);

		return size + 1; // + 자기자신
	}
}
