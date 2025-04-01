package Algorithm_Study.daily.CSY.March;

import java.util.Scanner;

public class D20250303_농작물_수확하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

/*
1
5
14054
44250
02032
51204
52212
*/

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            // input
            int N = sc.nextInt(); // 농장 크기
            int[][] field = new int[N][N];
            sc.nextLine();
            String[][] temp = new String[N][N];

            for(int i = 0; i < N; i++) {
                temp[i] = sc.nextLine().split("");
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    field[i][j] = Integer.parseInt(temp[i][j]);
                }
            }

            // logic
            int ans = 0;

            // 마름모 형태.
            // 행은 계속 증가. 열의 규칙을 파악해야 함.
            // 열의 범위 설정이 중요!
            for(int i = 0; i < N; i++){
                int start, end; // 열의 시작과 끝(범위)

                // 마름모 윗부분(열의 개수가 1,3,5,,,, 홀수 형태로 증가)
                // N/2 인 이유는 열의 시작점이 N/2이기 때문!
                // 행에 따른 열의 범위 설정.
                if(i <= N/2){
                    start = N/2 - i;
                    end = N/2 + i;
                }else{
                    start = i - N/2;
                    end = N - (i-N/2) - 1;
                }

                // 이제 열의 범위대로 접근!
                for(int j = start; j <= end; j++){
                    ans += field[i][j];
                }
            }


            System.out.println("#" + tc + " " + ans);
        }

    }
}
