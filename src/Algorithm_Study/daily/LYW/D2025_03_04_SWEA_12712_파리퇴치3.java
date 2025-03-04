package Algorithm_Study.daily.LYW;
import java.util.Scanner;

public class D2025_03_04_SWEA_12712_파리퇴치3 {
    // + 모양 델타 배열 (상하좌우)
    static int[] dr1 = { -1, 1, 0, 0 };
    static int[] dc1 = { 0, 0, -1, 1 };
    // X 모양 델타 배열 (대각선 4방향)
    static int[] dr2 = { -1, -1, 1, 1 };
    static int[] dc2 = { -1, 1, 1, -1 };
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
 
            int N = sc.nextInt();
            int M = sc.nextInt(); // 에프킬러 범위
            int[][] arr = new int[N][N];
 
            // 배열에 파리 수 넣기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            // 배열의 각각의 값을 중심으로 스프레이를 뿌린다
            int answer = -1;
            
            // + 모양으로 델타 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 델타
                    int sum = arr[i][j];
                    for (int d = 0; d < 4; d++) {
                        int a = i;
                        int b = j;
                        // 델타가 M만큼 반복되어야 한다
                        for (int k = 0; k < M-1; k++) {
                            int x = a + dr1[d];
                            int y = b + dc1[d];
                            // 배열의 범위인 경우에만 합을 구한다
                            if (x >= 0 && x < N && y >= 0 && y < N) {
                                sum += arr[x][y];
                            }
                            a = x;
                            b = y;
                        }
                    } // 델타 for
                    answer = Math.max(answer, sum);
                }
            }
             
            // x 모양으로 델타 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 델타
                    int sum = arr[i][j];
                    for (int d = 0; d < 4; d++) {
                        int a = i;
                        int b = j;
                        // 델타가 M만큼 반복되어야 한다
                        for (int k = 0; k < M-1; k++) {
                            int x = a + dr2[d];
                            int y = b + dc2[d];
                            // 배열의 범위인 경우에만 합을 구한다
                            if (x >= 0 && x < N && y >= 0 && y < N) {
                                sum += arr[x][y];
                            }
                            a = x;
                            b = y;
                        }
                    } // 델타 for
                    answer = Math.max(answer, sum);
                }
            }
             
            System.out.println("#" + tc + " " + answer);
 
        } // tc
    }
}