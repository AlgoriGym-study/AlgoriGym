package Algorithm_Study.common.C202507.C20250723;

import java.util.*;

public class LYW0035 {
    static int[] parent;
    static int[] enemy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 관계 수

        parent = new int[n + 1];
        enemy = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            enemy[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            String type = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (type.equals("F")) {
                union(a, b);
            } else { // 원수 관계
                int aEnemy = enemy[a];
                int bEnemy = enemy[b];

                if (aEnemy != 0) union(aEnemy, b);
                else enemy[a] = b;

                if (bEnemy != 0) union(bEnemy, a);
                else enemy[b] = a;
            }
        }

        // 각 대표를 set에 담아 팀 수 계산
        Set<Integer> teamSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            teamSet.add(find(i));
        }

        System.out.println(teamSet.size());
    }

    // 유니온 파인드
    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}
