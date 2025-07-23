package Algorithm_Study.common.C202507.C20250723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SJG0035 {
    static int n, m;
    static int[] parent;

    // 적 관계를 임시 저장할 리스트
    static List<List<Integer>> enemies;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        enemies = new ArrayList<>();
        for (int i = 0; i <= n; i++) enemies.add(new ArrayList<>());

        // 1) F/E 관계 읽어서 처리
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char type = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if (type == 'F') {
                union(p, q);
            } else { // 'E'
                enemies.get(p).add(q);
                enemies.get(q).add(p);
            }
        }
        br.close();

        // 적의 적은 친구의 조건
        for (int x = 1; x <= n; x++) {
            List<Integer> list = enemies.get(x);
            int sz = list.size();
            // 리스트 안의 모든 쌍을 union
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    union(list.get(i), list.get(j));
                }
            }
        }

        // 서로 같은 root를 갖는 팀 개수 카운트
        boolean[] seen = new boolean[n+1];
        int teams = 0;
        for (int i = 1; i <= n; i++) {
            int r = find(i);
            if (!seen[r]) {
                seen[r] = true;
                teams++;
            }
        }

        System.out.println(teams);
    }

    static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
