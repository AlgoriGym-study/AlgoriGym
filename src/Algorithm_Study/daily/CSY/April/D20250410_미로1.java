package Algorithm_Study.daily.CSY.April;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D20250410_미로1 {

        static int[][] arr;
        static int N = 16;

        static int[] dr = {-1,1,0,0};
        static int[] dc = {0,0,-1,1};

        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            for(int tc = 1; tc <= 10; tc++) {
                int T = Integer.parseInt(br.readLine());

                arr = new int[N][N];
                for(int i = 0; i < N; i++) {
                    String[] str = br.readLine().split("");
                    for(int j = 0; j < N; j++) {
                        arr[i][j] = Integer.parseInt(str[j]);
                    }
                }

                int ans = bfs();

                sb.append("#").append(T).append(" ").append(ans).append("\n");
            }
            System.out.println(sb.toString());
        }

        private static int bfs() {
            Queue<int[]> q = new LinkedList<>();
            arr[1][1] = 1;
            q.add(new int[]{1,1});

            while(!q.isEmpty()) {
                int[] curr = q.poll();

                for(int d = 0 ; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(arr[nr][nc] == 1) continue;
                    if(arr[nr][nc] == 3) return 1;

                    arr[nr][nc] = 1;
                    q.add(new int[] {nr,nc});
                }
            }

            return 0;
        }

    }


