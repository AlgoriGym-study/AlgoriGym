package Algorithm_Study.common.C202506.C20250625;

import java.util.*;

public class LYW0026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 암호문 개수
            List<String> cipher = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                cipher.add(sc.next());
            }

            int M = sc.nextInt(); // 명령어 개수
            for (int i = 0; i < M; i++) {
                String cmd = sc.next(); // 명령어 타입
                if (cmd.equals("I")) {
                    int x = sc.nextInt(); // 삽입 위치
                    int y = sc.nextInt(); // 삽입할 암호문 개수
                    for (int j = 0; j < y; j++) {
                        cipher.add(x + j, sc.next()); // x 이후 위치에 삽입
                    }
                } else if (cmd.equals("D")) {
                    int x = sc.nextInt(); // 삭제 시작 위치
                    int y = sc.nextInt(); // 삭제할 개수
                    for (int j = 0; j < y; j++) {
                        if (x + 1 < cipher.size()) {
                            cipher.remove(x + 1); // x 다음부터 삭제
                        }
                    }
                } else if (cmd.equals("A")) {
                    int y = sc.nextInt(); // 추가할 개수
                    for (int j = 0; j < y; j++) {
                        cipher.add(sc.next()); // 맨 뒤에 추가
                    }
                }
            }

            // 결과 출력
            System.out.print("#" + tc);
            for (int i = 0; i < 10 && i < cipher.size(); i++) {
                System.out.print(" " + cipher.get(i));
            }
            System.out.println();
        }

        sc.close();
    }
}
