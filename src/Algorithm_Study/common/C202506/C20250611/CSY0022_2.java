package Algorithm_Study.common.C202506.C20250611;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CSY0022_2 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static String[][] board;
    static boolean[][] outside;

    public static void main(String[] args) {
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};

        // 초기 board 구성
        N = storage.length;
        M = storage[0].length();
        board = new String[N][M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                board[r][c] = String.valueOf(storage[r].charAt(c));
            }
        }
        // 2) 요청 처리
        for (String req : requests) {
            char target = req.charAt(0);

            if (req.length() == 2) {
                // [크레인 요청] — 보드 전체에서 target 전부 제거
                removeAllByCrane(target);
                // 제거 후 빈 공간의 외부 연결 여부 갱신
                markOutsideSpaces();
            } else {
                // [지게차 요청] — 먼저 빈 공간의 외부 연결 여부 갱신
                markOutsideSpaces();

                // (1) 제거 대상 수집: target 이면서 외부와 인접한 칸
                List<int[]> toRemove = new ArrayList<>();
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < M; c++) {
                        if (board[r][c].equals(String.valueOf(target)) &&
                            isAdjacentToOutside(r, c)) {
                            toRemove.add(new int[]{r, c});
                        }
                    }
                }

                // (2) 수집한 칸을 한꺼번에 제거
                for (int[] p : toRemove) {
                    board[p[0]][p[1]] = "x";
                }
                // 제거 후 빈 공간의 외부 연결 여부 다시 갱신
                markOutsideSpaces();
            }
        }

        // 3) 최종 남은 블록 개수 세기
        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!board[r][c].equals("x")) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    /** 크레인 작업: board 전체에서 target 글자 전부 'x'로 제거 */
    public static void removeAllByCrane(char target) {
        String t = String.valueOf(target);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c].equals(t)) {
                    board[r][c] = "x";
                }
            }
        }
    }

    /** 빈 칸('x') 중에서 외곽(보드 바깥) 혹은 이미 표시된 외부 셀과 연결된 모든 칸을 표시 */
    public static void markOutsideSpaces() {
        outside = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        // (1) 보드 테두리에서 'x'인 칸을 모두 큐에 추가
        for (int i = 0; i < N; i++) {
            if (board[i][0].equals("x"))      enqueueOutside(i, 0, visited, q);
            if (board[i][M-1].equals("x"))    enqueueOutside(i, M-1, visited, q);
        }
        for (int j = 0; j < M; j++) {
            if (board[0][j].equals("x"))      enqueueOutside(0, j, visited, q);
            if (board[N-1][j].equals("x"))    enqueueOutside(N-1, j, visited, q);
        }

        // (2) BFS를 돌며 인접한 'x' 빈 칸 전파
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            outside[r][c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (!visited[nr][nc] && board[nr][nc].equals("x")) {
                    enqueueOutside(nr, nc, visited, q);
                }
            }
        }
    }

    /** 외부 표시 초기화 및 큐에 추가 */
    public static void enqueueOutside(int r, int c, boolean[][] visited, Queue<int[]> q) {
        visited[r][c] = true;
        q.add(new int[]{r, c});
    }

    /** (r,c) 칸이 외부와 연결된 빈 칸과 인접해 있는지 혹은 보드 경계를 벗어나는지 확인 */
    public static boolean isAdjacentToOutside(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            // 경계를 벗어나면 곧바로 외부와 연결
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                return true;
            }
            // 이미 외부로 표시된 빈 칸과 인접
            if (outside[nr][nc]) {
                return true;
            }
        }
        return false;
    }
}
