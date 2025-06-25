package Algorithm_Study.common.C202504.C20250401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CSY {

    static int N, K, S, X, Y;
    static int[][] arr;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static List<int[]> virus;

    public static void main(String[] args) throws IOException {
//		long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0)
                    virus.add(new int[] { arr[i][j], 0, i, j });
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        // input done

        virus.sort(Comparator.comparingInt(a -> a[0])); // 오름차순으로 정렬. 0인덱스는 바이러스 종류

        bfs();

        int ans = arr[X - 1][Y - 1];

        System.out.println(ans);
//		long end = System.currentTimeMillis();
//		System.out.println("실행 시간: " + (end - start) + "ms");
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>(virus);

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int v = cur[0];
            int time = cur[1];
            int r = cur[2];
            int c = cur[3];

            if(time == S) return;
            // 네 방향 탐색
            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];
                // 유효성 체크
                if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;
                if (arr[nr][nc] != 0)
                    continue; // 다른 바이러스가 있으면 아웃

                arr[nr][nc] = v;
                q.add(new int[] {v, time+1, nr, nc});
            }
        }

    }

}

