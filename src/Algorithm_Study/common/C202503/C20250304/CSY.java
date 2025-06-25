package Algorithm_Study.common.C202503.C20250304;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSY {
    // static한 델타 선언
    static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}; // 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
    static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1}; // 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Algorithm_Study/common/C20250304/input.txt"));

        int T = sc.nextInt(); // 테스트 케이스 수
        for (int tc = 1; tc <= T; tc++) {
            // 입력
            int N = sc.nextInt(); // 오목판 수
            char[][] board = new char[N][N]; // 오목판 배열
            for (int i = 0; i < N; i++) {
                board[i] = sc.next().toCharArray();
            }


            // 로직
            String ans = "NO";

            // 전체 좌표 순회
            for (int i = 0; i < N; i++) {
                boolean isFinish = false; // 전체 탐색 끝낼 조건
                for (int j = 0; j < N; j++) {
                    // 해당 좌표가 돌이 아니면 순회x
                    if (board[i][j] != 'o') continue;

                    // 델타 탐색으로 각 방향 탐색( 해당 방향에 돌이 있으면 그 방향으로 쭉 탐색 (while))
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        int count = 1; // 위에 조건으로 일단 한 개는 세고 시작!

                        // 좌표값 유효성 체크, 돌 아닌 경우에도 끝!
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != 'o') continue;
                        count++; // 위 조건문으로 하나 세고 시작.
                        while (count < 5) {
                            /// 좌표값 갱신
                            nr += dr[d];
                            nc += dc[d];
                            // 다음 좌표가 돌이 아니면 끝!
                            if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != 'o') break;
                            count++;
                        }
                        // 오목 되면 끝! 델타문 빠져나가기
                        if (count == 5) {
                            isFinish = true;
                            break;
                        }
                    }// 델타 for문

                    // 오목 나오면 전체 순회 종료!
                    if (isFinish) {
                        ans = "YES";
                        break;
                    }
                }
            }


            // 출력
            System.out.println("#" + tc + " " + ans);
        }
    }
}
