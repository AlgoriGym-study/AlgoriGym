package Algorithm_Study.daily.CSY.March;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D20250331_미로탐색 {


        static int N, M;
        static char[][] arr;
        static int[][] dist;

        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            N = sc.nextInt();
            M = sc.nextInt();

            arr = new char[N][M];
            dist = new int[N][M];

            for(int i = 0; i < N; i++) {
                arr[i] = sc.next().toCharArray();
            }
            int ans = 0;
            i : for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == '1') {
                        ans = bfs(i, j);
                        break i;
                    }
                }
            }

            System.out.println(ans);

        }

        static int bfs(int r, int c) {
            Queue<int[]> q = new LinkedList<>();
            dist[r][c] = 1;
            q.add(new int[] {r,c});

            while(!q.isEmpty()) {

                int[] cur = q.poll();
                if(cur[0] == N - 1 && cur[1] == M-1) return dist[cur[0]][cur[1]];
                for(int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if(arr[nr][nc] == '0' || dist[nr][nc] != 0) continue;

                    arr[nr][nc] = '0';
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    q.add(new int[] {nr, nc});
                }
            }

            return -1;
        }


}
