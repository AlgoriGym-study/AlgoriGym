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

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int r = i, c = j;
                    int[] temp = new int[4];

                    //상하좌우 탐색
                    while(true){
                        //상
                        if(r - 1 > 0){
                            if(arr[r-1][c] < arr[i][j]){
                            temp[0] = arr[r-1][c];
                            }

                        }

                    }

                }
            }

            //출력
            System.out.println("#" + tc + " " + ans);
        }
    }
}
