package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_03_26_SWEA_치즈도둑 {
    static int N;
    static int[][] cheese;
    static boolean[][] visited;
    static int max; // 최대 덩어리 개수
    static int cnt; // 최대 덩어리와 비교할 덩어리 수
 
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
 
            N = sc.nextInt(); // 치즈 한 변의 길이
            cheese = new int[N][N];
            visited = new boolean[N][N];
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }
            int date = 0;
            max = 0;
 
            func(date);
            System.out.println("#" + tc + " " + max);
 
        } // tc
    }// main
 
    private static void func(int date) {
        // 종료조건
        if (date > 100) {
            return;
        }
 
        // visited 배열 초기화 시켜줘야됨
        visited = new boolean[N][N];
        cnt = 0;
 
        // 재귀부분
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cheese[i][j] == date) {
                    cheese[i][j] = 0;
                }
            }
        } // x번째 날에 x인 칸을 0으로 바꾼다.
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(cheese[i][j] != 0 && !visited[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }
         
        max = Math.max(cnt, max);
 
        func(date+1);
 
    }
 
    private static void dfs(int r, int c) {
        // 종료조건
 
        // 재귀부분
        visited[r][c] = true;
         
        for (int d = 0; d < 4; d++) {
            int x = r + dr[d];
            int y = c + dc[d];
 
            // 배열 범위 벗어난 경우 쳐내기
            if (x < 0 || y < 0 || x >= N || y >= N) {
                continue;
            }
            // 먹은 치즈인 경우 쳐내기
            if (cheese[r][c] == 0) {
                continue;
            }
            // 이미 카운트한 덩어리인 경우 쳐내기
            if(visited[x][y]) {
                continue;
            }
             
            // 위의 조건에 안걸린 경우
            dfs(x, y);
        }
 
    }
 
}