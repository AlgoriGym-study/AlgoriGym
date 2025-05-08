package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_05_07_SWEA_String {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10; // 테스트 케이스 수는 항상 10

        for (int test_case = 1; test_case <= T; test_case++) {
            int tc = sc.nextInt();       // 테스트 케이스 번호
            String target = sc.next();   // 찾을 문자열
            String source = sc.next();   // 전체 문자열

            int count = 0;
            int N = source.length();
            int M = target.length();

            for (int i = 0; i <= N - M; i++) {
                boolean match = true;
                for (int j = 0; j < M; j++) {
                    if (source.charAt(i + j) != target.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) count++;
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
