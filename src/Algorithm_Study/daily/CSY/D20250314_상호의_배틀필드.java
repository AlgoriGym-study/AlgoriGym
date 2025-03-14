package Algorithm_Study.daily.CSY;

import java.util.Scanner;

public class D20250314_상호의_배틀필드 {
    static int r, c, H, W;
    static char[][] arr;
    static char state;
    static final char[] DIRS = {'^', 'v', '<', '>'}; // 상하좌우 방향
    static final int[] DR = {-1, 1, 0, 0}; // U, D, L, R
    static final int[] DC = {0, 0, -1, 1}; // U, D, L, R

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            H = sc.nextInt();
            W = sc.nextInt();
            arr = new char[H][W];

            for (int i = 0; i < H; i++) {
                arr[i] = sc.next().toCharArray();
            }

            // 전차 찾기
            findTank();

            int N = sc.nextInt();
            char[] commands = sc.next().toCharArray();

            for (char command : commands) {
                executeCommand(command);
            }

            arr[r][c] = state; // 최종 전차 위치 반영

            // 출력
            System.out.print("#" + tc + " ");
            for (char[] row : arr) {
                System.out.println(row);
            }
        }
    }

    // 전차 위치 찾기
    private static void findTank() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (isTank(arr[i][j])) {
                    r = i;
                    c = j;
                    state = arr[i][j];
                    return;
                }
            }
        }
    }

    // 전차 방향 판별
    private static boolean isTank(char ch) {
        return ch == '^' || ch == 'v' || ch == '<' || ch == '>';
    }

    // 명령 실행
    private static void executeCommand(char command) {
        switch (command) {
            case 'U': moveTank(0); break;
            case 'D': moveTank(1); break;
            case 'L': moveTank(2); break;
            case 'R': moveTank(3); break;
            case 'S': shoot(); break;
        }
    }

    // 전차 이동
    private static void moveTank(int dir) {
        state = DIRS[dir]; // 방향 변경
        int nr = r + DR[dir];
        int nc = c + DC[dir];

        if (isInBounds(nr, nc) && arr[nr][nc] == '.') { // 이동 가능하면 이동
            arr[r][c] = '.';
            r = nr;
            c = nc;
        }
    }

    // 포탄 발사
    private static void shoot() {
        int dir = getDirection(state);
        int sr = r, sc = c;

        while (true) {
            sr += DR[dir];
            sc += DC[dir];

            if (!isInBounds(sr, sc)) return; // 범위를 벗어나면 종료
            if (arr[sr][sc] == '#') return; // 강철 벽(#)이면 무시하고 종료
            if (arr[sr][sc] == '*') { // 벽돌 벽(*)이면 파괴
                arr[sr][sc] = '.';
                return;
            }
        }
    }

    // 방향을 인덱스로 변환
    private static int getDirection(char ch) {
        for (int i = 0; i < 4; i++) {
            if (DIRS[i] == ch) return i;
        }
        return -1;
    }

    // 배열 범위 체크
    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}