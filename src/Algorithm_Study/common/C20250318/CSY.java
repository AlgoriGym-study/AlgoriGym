package Algorithm_Study.common.C20250318;

import java.util.Scanner;

public class CSY {
    static int count;
    static int[] arr;
    static boolean[] selected;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = "";
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            count = 0;
            arr = new int[N];
            selected = new boolean[N];

            perm(0);

            s += "#" + tc + " " + count + "\n";
        }
        System.out.println(s);

    }

    static void perm(int level){
        // 기저
        if(level == arr.length){ // 더 이상 놓을 퀸이 없으면 끝!
            count++;
            return;
        }

        // 재귀
        // i 는 퀸을 놓을 열!
        i : for(int i = 0; i < arr.length; i++){
            for(int r = 0; r < level; r++){
                // 대각선 방향에 퀸이 있는지 체크(행의 차이와 열의 차이가 같으면 대각선 방향에 있다..!!)
                if(Math.abs(r-level) == Math.abs(arr[r] - i)) continue i;
            }

            if(selected[i]) continue; // 이미 선택된 열이면 넘기기
            // 아니면 배열에 넣어서 채워주기!
            selected[i] = true;
            arr[level] = i;
            perm(level + 1);
            selected[i] = false;

        }
    }
}
