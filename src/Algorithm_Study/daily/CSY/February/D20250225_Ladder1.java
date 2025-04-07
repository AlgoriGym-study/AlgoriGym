package Algorithm_Study.daily.CSY.February;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D20250225_Ladder1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Algorithm_Study/daily/CSY/input/D20250225.txt"));

        for (int tc = 1; tc <= 10; tc++) {
            //입력
            int T = sc.nextInt();
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            //로직
//            int ans = searchFinishIndx(arr);
//            int ans = bruteForce(arr);
            int ans = delta(arr);
            //출력
            System.out.println("#" + tc + " " + ans);
        }
    }

    static int searchFinishIndx(int[][] arr) {
        int finishIdx = 0;
        for (int i = 0; i < 100; i++) {
            if (arr[99][i] == 2) {
                finishIdx = i;
                break;
            }
        }

        int r = 98;
        int c = finishIdx;
        // 하나씩 줄여가면서... 길을 탐색
        // while 문으로 k가 0보다 클 때까지 계속 돌림.
        // 이때 좌우를 탐색해야 함.
        // 좌우 탐색
        // while문으로... arr[r][c] == 1 일때 계속 가는걸로...?
        while (r > 0) {
            //좌
            if (c > 0 && arr[r][c - 1] == 1) {
                while (c > 0 && arr[r][c - 1] == 1) c--;
            }
            //우
            else if (c < 99 && arr[r][c + 1] == 1) {
                while (c < 99 && arr[r][c + 1] == 1) c++;
            }

            r--;
        }

        return c;
    }

    static int bruteForce(int[][] arr){

        int ans = 0;
        // arr[0][0]에서 출발 이게 1이면 아래로, 0이면 좌우 탐색해서 1이면 0만날 때까지 증감.
        // 0만나면 다시 아래로.
        for(int i = 0; i < 100; i++){
            if(arr[0][i] == 1) {
                int r = 0;
                int c = i;

                while(r < 99){
                    //좌
                    if(c > 0 && arr[r][c-1] ==1){
                        while(c > 0 && arr[r][c-1] ==1) c--;
                    }
                    //우
                    else if(c < 99 && arr[r][c+1] == 1){
                        while(c < 99 && arr[r][c+1] == 1) c++;
                    }

                    r++;
                }// while문

                if(arr[99][c] == 2){
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }

    static int delta(int[][] arr){

        int[] dc = {-1, 1}; //좌, 우

        int ans = 0;
        // arr[0][0]에서 출발 이게 1이면 아래로, 0이면 좌우 탐색해서 1이면 0만날 때까지 증감.
        // 0만나면 다시 아래로.
        for(int i = 0; i < 100; i++){
            if(arr[0][i] == 1) {
                int r = 0;
                int c = i;

                while(r < 99){
                    //좌
                    if(c > 0 && arr[r][c+dc[0]] ==1){
                        while(c > 0 && arr[r][c+dc[0]] ==1) c--;
                    }
                    //우
                    else if(c < 99 && arr[r][c+dc[1]] == 1){
                        while(c < 99 && arr[r][c+dc[1]] == 1) c++;
                    }

                    r++;
                }// while문

                if(arr[99][c] == 2){
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
}
