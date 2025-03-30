package Algorithm_Study.daily.CSY;

import java.util.Scanner;

public class D20250319_N과M1 {
    static int N;
    static int M;
    static int[] result;
    static boolean[] sel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 전체 데이터
        sel = new boolean[N]; // 데이터 방문 체크 배열

        M = sc.nextInt(); // 뽑을 데이터 개수
        result = new int[M]; // 뽑을 결과 배열

        perm(0); // 순열 : 서로 다른 N개의 원소 중 R개를 뽑아서 나열하는 것(순서0)

    }

    static void perm(int idx){
        if(idx == M){
            for(int i = 0; i < M; i++){
                    System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(sel[i-1]) continue;
            sel[i-1] = true;
            result[idx] = i;
            perm(idx+1);
            sel[i-1] = false;
        }
    }
}
