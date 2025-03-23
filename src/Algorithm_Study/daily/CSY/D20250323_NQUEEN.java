package Algorithm_Study.daily.CSY;

import java.util.Arrays;
import java.util.Scanner;

public class D20250323_NQUEEN {

    static int[] arr;
    static boolean[] sel;
    static int N;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++){

            N = sc.nextInt();
            arr = new int[N];
            sel = new boolean[N];
            count = 0;

            perm(0);

            sb.append("#" + tc + " " + count + "\n");
        }
        System.out.println(sb.toString());
    }

    static void perm(int level){ // level은 현재 탐색할 행
        if(level == N){ // 행의 수가 체스판 수를 넘으면 끝!
            count++;
            System.out.println(Arrays.toString(arr));
            return;
        }

        // 퀸을 놓으려는 열
        i : for(int i = 0; i < N; i++){
            // 그 열에서 행 체크!(기존의 행과 겹치는지)
            for(int r = 0; r < level; r++){
                // 행의 차와 열의 차가 같으면 같은 대각선 상에 위치한다는 뜻
                if(Math.abs(level-r) == Math.abs(arr[r] - i)) continue i;
            }

            if(sel[i]) continue;

            sel[i] = true;
            arr[level] = i;
            perm(level+1);
            sel[i] = false; // 백트래킹

        }

    }
}
