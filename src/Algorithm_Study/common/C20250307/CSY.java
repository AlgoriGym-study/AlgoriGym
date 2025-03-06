package Algorithm_Study.common.C20250307;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CSY {
    static int[] arr;
    static int[] temp;
    static int N;
    static int K;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Algorithm_Study/common/C20250307/input.txt"));

        int T = sc.nextInt();

        String s = "";
        for(int tc = 1; tc <= T; tc++){
            // input
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];
            temp = new int[N]; // 원소 - K의 배열
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }

            // logic
            // 부분집합으로 모든 경우의 수를 구하고
            // 경우의 수 하나하나 안에서 최소값과 최대값의 차가 K이면
            // 이 조건 통과한 경우의 수의 원소 개수 중 최대값이 정답.
            int ans = 0;
            // 오름차순으로 정렬
            Arrays.sort(arr);
            // -3 -2 -1 0 2 4 5 11 12 16
            // 각 원소에서 K 값을 뺀 배열 생성
//            for(int i = 0; i < N; i++){
//                temp[i] = arr[i] - K;
//            }
//            // temp를 처음부터 탐색
//            for(int i = 0; i < N; i++){
//                int count = 0;
//                // 그 안에서 i와 j의 합이 K이하일 때까지의 수를 카운트
//                for(int j = i; j < N; j++){
//                    if(temp[i] - temp[j] <= K) count++;
//                }
//                ans = Math.max(ans, count);
//            }
            ans = powerset();

            s += "#" + tc + " " + ans +"\n";

        }
        System.out.println(s);

    }

    static int powerset(){
        int ans = 0;
        for(int i = 0; i < (1 << N); i++){
            int count = 0;
            int min = Integer.MAX_VALUE;
            int max = -1;

            for(int j = 0; j  < N; j++){
                if((i & (1 << j)) != 0){
                    count++; // 경우의 수 세기(몇 개짜리 집합인지)
                    // 경우의 수 하나하나
                    if(arr[j] < min){
                        min = arr[j];
                    }// 해당 경우의 수의 최솟값 갱신

                    if(arr[j] > max){
                        max = arr[j];
                    }// 해당 경우의 수의 최댓값 갱신
//                    System.out.print(arr[j] + " ");
                }
            }
            if(max-min <= K) ans = Math.max(ans, count);
        }

        return ans;
    }
}
