package Algorithm_Study.daily.CSY.March;

import java.util.Scanner;

public class D20250311_이진수표현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String s = "";
        for(int tc = 1; tc <= T; tc++){

            int N = sc.nextInt();
            int M = sc.nextInt();

            // 마지막 N비트가 1인 이진수 : (1 << N) - 1
            // ex) N = 4, 1 << 4 => 10000(16)
            // 10000 - 1 = 01111(15)
            N = (1 << N) - 1;

            // 이것과 M과 & 연산 => 01111 & 0 = 0 (둘 다 1이어야 1!) 삼항연산자 이용하여 결과 도출
            String ans = (N & M) == N ? "ON" : "OFF";

            s += "#" + tc + " " + ans + "\n";
        }
        System.out.println(s);
    }
}
