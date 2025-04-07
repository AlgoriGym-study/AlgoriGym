package Algorithm_Study.daily.CSY.February;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D20250226_파리퇴치3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Algorithm_Study/daily/CSY/input/D20250226.txt"));

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt(); // 배열 수
            int M = sc.nextInt(); // 스프레이 노즐

            int[][] arr = new int[N][N];
            for(int i = 0; i< N; i++){
                for(int j = 0; j < N ; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            // logic
            int ans = 0;
            int[] dr = {-1, 1, 0, 0}; //상하좌우
            int[] dc = {0, 0, -1, 1}; //상하좌우
            int[] dr2 = {-1, 1, 1, -1}; //우상, 우하, 좌하, 좌상
            int[] dc2 = {1, 1, -1, -1}; //우상, 우하, 좌하, 좌상

            // 완전 탐색 : 전체 좌표 다 돌기
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    int sum = arr[r][c]; // 해당 좌표로 초기화(본인도 더해야 하기 때문)
                    int sum2 = arr[r][c];

                    // 델타 탐색
                    for(int d = 0; d < 4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        int nr2 = r + dr2[d];
                        int nc2 = c + dc2[d];
                        // 상하좌우
                        if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        sum += arr[nr][nc];

                        // 대각선
                        if(nr2 < 0 || nr2 >= N || nc2 < 0 || nc2 >= N) continue;
                        sum2 += arr[nr2][nc2];

                        for(int m = 1; m < M - 1; m++){
                            nr += dr[d];
                            nc += dc[d];
                            nr2 += dr2[d];
                            nc2 += dc2[d];

                            // 상하좌우
                            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                            sum += arr[nr][nc];

                            // 대각선
                            if(nr2 < 0 || nr2 >= N || nc2 < 0 || nc2 >= N) continue;
                            sum2 += arr[nr2][nc2];
                        }
                    }
                    int result = Math.max(sum, sum2);

                    ans = Math.max(ans, result);

                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
