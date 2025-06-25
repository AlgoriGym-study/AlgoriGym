package Algorithm_Study.common.C202503.C20250311;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSY {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Algorithm_Study/common/C20250311/input.txt"));

        int T = sc.nextInt();

        String s = "";
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt(); // 나무 개수
            int[] arr = new int[N];

            int max = -1; // 최대값 찾기
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]); // 값 들어올 때마다 비교해서 최대값 갱신
            }

            int ans = 0;
            int even = 0; // 짝수 날
            int odd = 0; // 홀수 날

            for(int i = 0; i < N; i++){
                int water = max - arr[i]; // 최대를 제외한 나무가 자라야 하는 키
                even += water/2;
                odd += water%2;
            }

            if(even > odd){ // 짝수 날이 홀수 날보다 클 경우

                while(even > odd-1){
                    even--;
                    odd += 2;
                }
            } else { // 홀수 날이 짝수 날보다 클 경우
                while(odd-even > 1){
                    odd -= 2;
                    even++;
                }
            }
            ans = odd + even;

            s += "#" + tc + " " + ans + "\n";
        }
        System.out.println(s);
    }
}
