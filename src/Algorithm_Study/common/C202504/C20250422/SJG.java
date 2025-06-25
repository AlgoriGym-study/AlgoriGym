package Algorithm_Study.common.C202504.C20250422;

import java.io.*;
import java.util.*;

public class SJG {
	static final int ROWS = 12;
    static final int COLS = 6;
    static char[][] field = new char[ROWS][COLS];
    static boolean[][] visited; // BFS 방문 체크 배열
    
    
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우 행 이동
    static int[] dc = {0, 0, -1, 1}; // 상하좌우 열 이동

    // 좌표를 저장하기 위한 내부 클래스 
    static class Puyo {
        int r, c;

        Puyo(int r, int c) {
            this.r = r;
            this.c = c;
        }

        // Set에서 중복 제거 및 비교를 위해 hashCode와 equals 구현
        @Override
        public int hashCode() {
            return r * 31 + c;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Puyo other = (Puyo) obj;
            return r == other.r && c == other.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < ROWS; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < COLS; j++) {
                field[i][j] = input[j];
            }
        }    // 입력끝

        int count = 0; // 연쇄 횟수

        while (true) {
            visited = new boolean[ROWS][COLS]; // 매 연쇄마다 방문 배열 초기화
            Set<Puyo> popCandidates = new HashSet<>(); // 터뜨릴 뿌요 좌표 저장 (Set으로 중복 방지)
            boolean didPop = false; // 이번 턴에 터뜨렸는지 여부

            // 1. 터뜨릴 수 있는 뿌요 그룹 찾기
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (field[i][j] != '.' && !visited[i][j]) {
                        List<Puyo> group = bfs(i, j); // BFS 탐색
                        if (group.size() >= 4) {
                            popCandidates.addAll(group); // 터뜨릴 후보에 추가
                            didPop = true;
                        }
                    }
                }
            }

            // 2. 터뜨릴 뿌요가 없으면 종료
            if (!didPop) {
                break;
            }

            // 3. 연쇄 증가 및 뿌요 터뜨리기
            count++;
            for (Puyo p : popCandidates) {
                field[p.r][p.c] = '.';
            }

            // 4. 떨어뜨리기 적용
            applyFall();
        }

        // 최종 연쇄 횟수 출력
        System.out.print(count);
    }

    static List<Puyo> bfs(int r, int c) {
        Queue<Puyo> queue = new LinkedList<>();
        List<Puyo> groupCoords = new ArrayList<>();
        char color = field[r][c];

        Puyo start = new Puyo(r, c);
        queue.offer(start);
        groupCoords.add(start);
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Puyo curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                // 필드 범위 체크
                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS) {
                    continue;
                }

                // 방문 여부 및 같은 색 체크
                if (!visited[nr][nc] && field[nr][nc] == color) {
                    visited[nr][nc] = true;
                    Puyo next = new Puyo(nr, nc);
                    queue.offer(next);
                    groupCoords.add(next);
                }
            }
        }
        return groupCoords;
    }

    // 중력 함수: 뿌요 떨어뜨리기
    static void applyFall() {
        for (int c = 0; c < COLS; c++) {
            Queue<Character> tempCol = new LinkedList<>(); // 각 열의 뿌요 임시 저장
            // 열의 아래부터 위로 탐색하며 뿌요를 큐에 추가
            for (int r = ROWS - 1; r >= 0; r--) {
                if (field[r][c] != '.') {
                    tempCol.offer(field[r][c]);
                }
            }

            // 열의 아래부터 위로 다시 채우기
            for (int r = ROWS - 1; r >= 0; r--) {
                if (!tempCol.isEmpty()) {
                    field[r][c] = tempCol.poll();
                } else {
                    field[r][c] = '.';
                }
            }
        }
    }
}
