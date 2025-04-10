package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_04_09_SWEA_서로소집합 {
    static int[] parent;

    static void makeSet(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt(); // 원소 수
            int m = sc.nextInt(); // 연산 수

            makeSet(n);
            sb.append("#").append(t).append(" ");

            for (int i = 0; i < m; i++) {
                int op = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (op == 0) {
                    union(a, b);
                } else if (op == 1) {
                    sb.append(find(a) == find(b) ? "1" : "0");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
        sc.close();
    }
}
