package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_04_06_백준_유기농배추 {
    static int[][] field;
    static boolean[][] visited;
    static int M, N;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우 방향
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        while (T-- > 0) {
            M = sc.nextInt(); // 가로 길이
            N = sc.nextInt(); // 세로 길이
            int K = sc.nextInt(); // 배추 개수

            field = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치 저장
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1;
            }

            int wormCount = 0;

            // 모든 칸 탐색하면서 DFS 실행
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (field[y][x] == 1 && !visited[y][x]) {
                        dfs(x, y);
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);
        }

        sc.close();
    }

    // DFS 함수
    public static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (field[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
