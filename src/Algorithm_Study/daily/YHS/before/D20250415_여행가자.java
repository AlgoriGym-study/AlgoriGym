package Algorithm_Study.daily.YHS.before;

import java.io.*;
import java.util.*;

public class D20250415_여행가자 {
    static int[] p;
    static int[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        int M = Integer.parseInt(br.readLine());

        visit = new int[M];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (i == j)
                    continue;
                if (num == 1)
                    union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        boolean possible = true;
        for (int i = 1; i < M; i++) {
            if (findSet(visit[i]) != findSet(visit[0])) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    static void union(int u, int v) {
        u = findSet(u);
        v = findSet(v);

        if (u == v)
            return;

        if (u >= v)
            p[u] = v;
        else
            p[v] = u;
    }

    static int findSet(int v) {
        if (p[v] == v)
            return v;
        return p[v] = findSet(p[v]);
    }
}