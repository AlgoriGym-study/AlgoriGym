package Algorithm_Study.daily.CSY;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D20250228_풍선팡 {
    // 델타 static 선언(상,하,좌,우)
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Algorithm_Study/daily/CSY/input/D20250228.txt"));

        // 테스트케이스 수
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            // 입력
            int N = sc.nextInt(); // 행의 수
            int M = sc.nextInt(); // 열의 수
            // 2차원 배열 생성
            int[][] arr = new int[N][M];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            // 로직
            int ans = 0;

            // 완전 탐색
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){

                    // 풍선 터지는 수(하나의 좌표에서 다 돌 때마다 초기화
                    // 본인 값도 더해야 해서 자기 좌표로 초기화
                    int count = arr[i][j];

                    int P = arr[i][j]; // 풍선 터지는 칸 수! ex) 1이면 상하좌우로 한 칸, 2이면 두 칸

                    // 터지는 칸 수(?)만큼 반복문!
                    for(int p = 1; p <= P; p++){
                        for(int d = 0; d < 4; d++){
                            int nr = i + dr[d] * p;
                            int nc = j + dc[d] * p;

                            // 좌표값 유효성 체크
                            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                            // 조건문 통과하면 통과한 좌표값들 더하기
                            count += arr[nr][nc];
                        }
                    }
                    // 모든 칸 수에서 결과 중 최댓값 ans에 저장
                    ans = ans > count ? ans : count;

                }
            }


            // 출력
            System.out.println("#" + tc + " " + ans);
        }
    }
}
