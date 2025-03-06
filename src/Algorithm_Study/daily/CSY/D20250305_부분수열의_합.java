package Algorithm_Study.daily.CSY;

import java.util.Scanner;

public class D20250305_부분수열의_합 {
    // 편리한(?) 함수 사용을 위한 static 선언
    static int N;
    static int K;
    static int[] arr;
    static boolean[] sel;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){

            // input
            N = sc.nextInt();
            K = sc.nextInt();

            arr = new int[N];

            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }

            int ans = 0; // 테스트 케이스마다 초기화
            // 1. 비트로 구하기
//            ans = 비트();

            // 2. 재귀함수로 구하기
            sel = new boolean[N];
            cnt = 0; // 테스트케이스마다 초기화;
            powerset(0);
            ans = cnt;

            //output
            System.out.println("#" + tc + " " + ans);
        }
    }// main

    static int 비트(){
        int count = 0; // 조건을 만족하는 경우의 수

        // 전체 경우의 수 : 1 << N : 2의 N 제곱
        for(int i = 0; i < (1 << N); i++){
            int sum = 0; // 경우의 수 별로 합 초기화
            // 경우의 수마다 원소가 해당되는지 체크하는 for문
            for(int j = 0; j < N; j++){
                // & 연산자로 원소가 포함되어 있는지 체크
                if((i & 1 << j) != 0){
                    sum += arr[j];
                }
            }
            if(sum == K) count++;
        }

        return count;
    }

    static void powerset(int idx){
        // 종료
        if(idx == N){
            int sum =0; // 경우의 수마다 합 초기화
            for(int i = 0; i < N; i++){
                if(sel[i]){
                    sum += arr[i];
                }
            }

            if(sum == K) cnt++;
            return;

        }

        // 재귀
        sel[idx] = true;
        powerset(idx+1);

        sel[idx] = false;
        powerset(idx+1);
    }
}
