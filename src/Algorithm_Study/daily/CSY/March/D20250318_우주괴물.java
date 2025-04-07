package Algorithm_Study.daily.CSY.March;

import java.util.Scanner;
public class D20250318_우주괴물 {
        // 상하좌우 델타 선언
        static int[] dr = { -1, 1, 0, 0 };
        static int[] dc = { 0, 0, -1, 1 };

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int T = sc.nextInt();
            String s = "";

            for (int tc = 1; tc <= T; tc++) {
                int N = sc.nextInt();

                int[][] arr = new int[N][N];

                boolean[][] visited = new boolean[N][N];
                // 방문 배열로 1이나 2면 true값 넣어주기.
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        arr[i][j] = sc.nextInt();
                        if (arr[i][j] == 1 || arr[i][j] == 2) {
                            visited[i][j] = true;
                        }
                    }
                }

                // logic
                int ans = 0;

                // 괴물 찾기
                int mr = 0, mc = 0;
                m: for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] == 2) {
                            mr = i;
                            mc = j;
                            break m;
                        }
                    }
                }

                // 광선이 닿으면 1로 바꿔주기

                int stop = 20; // 범위에 없는 수 지정
                df: for (int d = 0; d < 4; d++) {
                    for (int m = 1; m < N; m++) { // 광선 길이
                        if (stop != d) {
                            int r = mr + dr[d] * m;
                            int c = mc + dc[d] * m;

                            if (r < 0 || r >= N || c < 0 || c >= N)
                                continue;

                            // 광선이 지나가는 자리 true로 바꿔주기
                            if (arr[r][c] == 0)
                                visited[r][c] = true;

                            // 벽 만나면 광선 쏘기 끝!
                            if (arr[r][c] == 1) {
                                stop = d;
                                continue df;
                            }

                        }
                    }
                }

                // 결과 도출
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j])
                            ans++;
                    }
                }

                s += "#" + tc + " " + ans + "\n";
            }
            System.out.println(s);

        }

    }
