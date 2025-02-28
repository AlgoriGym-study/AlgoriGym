package Algorithm_Study.common.C20250228;

import java.util.Scanner;
//오류 해결결
public class JSH {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // 2차원 배열 설정
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            // 배열의 값 설정
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 델타 설정
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            // 최대 이동 수
            int maxCount = 0;

            // 배열의 모든 수를 조회할 것이기 때문에 2중 for문 사용
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    // 이동 수
                    int moves = 0;
                    // 현재 위치
                    int curX = x, curY = y;

                    // 현재 위치가 주변 위치중에 가장 작을 때 까지 반복
                    while (true) {

                        // 초기 설정
                        int nextX = -1, nextY = -1;
                        // 가장 작은 수의 위치 저장
                        int minValue = arr[curX][curY];

                        // 네 방향 탐색
                        for (int i = 0; i < 4; i++) {
                            int nx = curX + dx[i];
                            int ny = curY + dy[i];

                            // 범위 확인 및 낮은 곳 찾기
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] < minValue) {
                                minValue = arr[nx][ny];
                                nextX = nx;
                                nextY = ny;
                            }
                        }

                        // 이동할 곳 이 없으면 break;
                        if (nextX == -1 || nextY == -1) {
                            break;
                        }

                        // 이동할 곳이 있으면 현재 위치에 저장
                        curX = nextX;
                        curY = nextY;
                        // 이동 수 증가
                        moves++;
                    }
                    // max함수를 이용하여 최대 이동 수와 이동 수를 계속 비교
                    maxCount = Math.max(maxCount, moves);
                }
            }
            System.out.println(maxCount);
        }
    }
}
