package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D20250327_창용마을무리의개수 {
    static int p[];
    static List<Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            p = new int[N + 1];
            count = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                p[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            for (int i = 1; i <= N; i++) {
                int parent = find(p[i]);
                if (!count.contains(parent))
                    count.add(parent);
            }

            System.out.printf("#%d %d\n", tc, count.size());
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);   

        if (x == y)
            return;

        if (x <= y)
            p[y] = x;
        else
            p[x] = y;
    }

    static int find(int x) {
        if (p[x] == x)
            return x;
        return find(p[x]);
    }
}