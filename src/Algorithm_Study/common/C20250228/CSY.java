package Algorithm_Study.common.C20250228;

import java.util.Scanner;

public class CSY {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            // 상하좌우 중 가장 낮은 높이로만 이동 가능 (같으면 이동x)
            // 최대 이동 거리

            //로직
            int ans = 0;
            int[] dr = {-1, 1, 0, 0}; //상하좌우
            int[] dc = {0, 0, -1, 1};

            // 완전 탐색
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){

                    // 현재 좌표값
                    int count = 0;
                    int mr = r; // 현재 값
                    int mc = c; // 현재 값

                    // 이동할 공간이 있으면 계속 이동하는 while문
                    while(true){

                        int cur = arr[mr][mc];
                        boolean isChange = false; // while문 break 조건
                        int min = cur; // 최솟값에 현재 좌표 할당
                        int next_r = mr;
                        int next_c = mc;

                        // 델타 탐색(현재 좌표의 상하좌우 탐색)
                        for(int d = 0; d < 4; d++){
                            int nr = mr + dr[d];
                            int nc = mc + dc[d];

                            // 상하좌우 값이 유효한지 체크하고, 최솟값보다 작으면 최솟값 갱신
                            if(nr >= 0 && nr < N && nc >= 0 && nc < N && min > arr[nr][nc]){
                                isChange = true;
                                min = arr[nr][nc];
                                next_r = nr;
                                next_c = nc;
                            }
                        }// for문

                        // 이동을 안 했으면 종료
                        if(!isChange) break;

                        // 이동했으면 count++ 하고, 좌표 갱신
                        count++;
                        mr = next_r;
                        mc =next_c;


                    }// while문
                    ans = Math.max(ans, count);



                } // 완전 탐색 for문1
            } // 완전 탐색 for문2

            //출력
            System.out.println("#" + tc + " " + ans);
        }
    }
}
