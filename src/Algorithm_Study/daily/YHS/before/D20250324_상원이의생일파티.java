package Algorithm_Study.daily.YHS.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250324_상원이의생일파티 {
    static int[][] graph;
    static int V, E, count;
    static StringTokenizer st;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new int[V + 1][V + 1];
            visit = new boolean[V + 1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a][b] = 1;
                graph[b][a] = 1;
            }

            count = 0;
            recur(1, 0);

            System.out.printf("#%d %d\n", tc, count);
        }
    }

    static void recur(int row, int edge) {
        if (edge == 2) { // 친구의 친구까지만 찾아야 하므로 간선의 길이가 2일때 종료
            return;
        }

        for (int i = 2; i <= V; i++) { // 1 = 상원이이므로 2부터 시작
            if (graph[row][i] == 1) { // 상원이의 친구만 찾으면 되므로 for문 필요 없이 1번 행부터 탐색
                if (!visit[i]) {
                    visit[i] = true;
                    count++;
                }
                recur(i, edge + 1);
            }
        }

        return; // for문을 다 돌동안 간선이 2개가 되지 않는다는건 더이상 친구가 없거나 중복된 경우이므로 종료
    }
}
