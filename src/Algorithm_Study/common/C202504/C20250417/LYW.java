package Algorithm_Study.common.C202504.C20250417;

import java.util.*;

public class LYW {
 
    // 세포 클래스
    static class Cell {
        int r, c;       // 위치 좌표
        int life;       // 생명력
        int time;       // 활성 상태 경과 시간
        int inactive;   // 비활성 상태 남은 시간
        boolean active; // 활성 여부
 
        public Cell(int r, int c, int life) {
            this.r = r;
            this.c = c;
            this.life = life;
            this.time = 0;
            this.inactive = life;
            this.active = false;
        }
    }
 
    static int N, M, K, size;
    static int[][] map;          // 초기 입력 맵
    static int[][] cellMap;      // 전체 확장 맵 (세포 상태 표시)
    static boolean[][] visited;  // 번식한 위치 체크
    static Queue<Cell> q;        // 살아있는 세포들을 담는 큐
    static List<Cell> tmpList;   // 이번 시간에 번식할 후보 리스트
 
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스 수
 
        for (int tc = 1; tc <= T; tc++) {
            // 입력 받기
            N = sc.nextInt(); // 행
            M = sc.nextInt(); // 열
            K = sc.nextInt(); // 시간
 
            map = new int[N][M];
            size = N + 2 * K + 10; // 여유 공간 포함한 전체 맵 크기
            cellMap = new int[size][size];
            visited = new boolean[size][size];
            q = new LinkedList<>();
            tmpList = new ArrayList<>();
 
            // 입력 맵 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
 
            int offset = K + 5; // 중앙 배치를 위한 여유 offset
 
            // 초기 세포를 중앙으로 이동해서 cellMap에 넣기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) {
                        int r = i + offset;
                        int c = j + offset;
                        cellMap[r][c] = map[i][j];
                        visited[r][c] = true;
                        q.offer(new Cell(r, c, map[i][j])); // 큐에 추가
                    }
                }
            }
 
            // K시간 동안 반복
            for (int time = 1; time <= K; time++) {
                tmpList.clear(); // 이번 시간에 번식할 후보들
 
             // 1. 큐에 담긴 세포들을 순회하면서 상태 체크, 시간 증가시키기
                int qSize = q.size(); // 현재 세포 수 만큼만 처리
                for (int i = 0; i < qSize; i++) {
                    Cell cell = q.poll();
                    boolean alive = false; // 이번 시간 이후에도 살아있는지 여부
 
                    // 1-1. 비활성 상태 (비활성 유지 시간 감소시키면서 활성 상태로 변경되는지 확인한다)
                    if (!cell.active) {
                        cell.inactive--; // 비활성 유지 시간 감소
                        if (cell.inactive == 0) {
                            cell.active = true;
                            cell.time = 0;
                        }
                        alive = true; // 아직 살아 있음
                    } 
                    // 1-2. 활성 상태 (활성화 후 첫 1시간인 경우 번식시키기, 번식될 좌표의 세포를 임시리스트에 담기)
                    else {
                        if (cell.time == 0) {
                            // 활성화된 첫 시간 -> 번식
                            for (int d = 0; d < 4; d++) {
                                int nr = cell.r + dr[d];
                                int nc = cell.c + dc[d];
                                if (inRange(nr, nc) && !visited[nr][nc] && cellMap[nr][nc] == 0) {
                                    tmpList.add(new Cell(nr, nc, cell.life)); // 번식 후보 등록
                                }
                            }
                        }
 
                        cell.time++; // 활성 상태 시간 증가
 
                        // 아직 생명력이 남아있다면 살아 있음
                        if (cell.time < cell.life) {
                            alive = true;
                        }
                    }
 
                    if (alive) {
                        q.offer(cell); // 살아 있으면 다시 큐에 넣음
                    }
                }
 
                // 2. 번식 후보들 정리 (좌표별 생명력 높은 세포만 유지)
                Map<String, Cell> nextCells = new HashMap<>();
                for (Cell c : tmpList) {
                    String key = c.r + "," + c.c;
                    // 들어온적 없는 좌표이거나 || 이미 있는데 생명력이 더 큰 값이 들어온 경우 -> 새로운 새포 유지시키기
                    if (!nextCells.containsKey(key) || nextCells.get(key).life < c.life) {
                        nextCells.put(key, c); // 생명력 높은 세포 유지
                    }
                }
 
                // 3. 번식 적용
                for (Cell c : nextCells.values()) {
                    cellMap[c.r][c.c] = c.life;
                    visited[c.r][c.c] = true;
                    q.offer(c); // 새로운 세포 큐에 추가
                }
            }
 
            // K시간 후 살아있는 세포 수 출력 -> 큐에 남게된 세포들은 활성화, 비활성화 상태의 세포들 이므로 총 갯수가 정답이 된다.
            System.out.println("#" + tc + " " + q.size());
        }
    }
 
    // 배열 범위 체크 함수
    static boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < size && c < size;
    }
}