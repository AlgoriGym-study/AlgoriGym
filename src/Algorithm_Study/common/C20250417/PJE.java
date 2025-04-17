package Algorithm_Study.common.C20250417;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PJE {

    static final int dy[] = {0, 0, 1, -1};
    static final int dx[] = {1, -1, 0, 0};

    static final int DEAD = 0, ACTIVE = 1, INACTIVE = 2;

    static int T, N, M, K;

    static List<Cell> cell; //지금 존재하는 세포
    static PriorityQueue<Cell> pq; // 번식 후보 (생명력 높은 순)
    static boolean[][] visited;

    static class Cell implements Comparable<Cell> {
        int x, y;       //좌표
        int time;       //상태 변화 시점 (활성화되거나 죽는 시간)
        int state;      //상태
        int life;       //생명력

        Cell(int x, int y, int time, int life) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.life = life;
            this.state = INACTIVE;
        }

        // 생명력 높은 순으로 정렬
        @Override
        public int compareTo(Cell o) {
            return Integer.compare(o.life, this.life);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); 

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); //행
            M = sc.nextInt(); //열
            K = sc.nextInt(); //배양 시간

            cell = new ArrayList<>();
            pq = new PriorityQueue<>();
            visited = new boolean[1000][1000];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int n = sc.nextInt(); // 생명력
                    if (n != 0) {
                        int x = i + K;
                        int y = j + K;
                        cell.add(new Cell(x, y, n, n));
                        visited[x][y] = true;
                    }
                }
            }

            simulation();

            System.out.println("#" + tc + " " + count());
        }
    }

    static void simulation() {
        for (int k = 1; k <= K; k++) {

            // 직전에 번식 후보였던 세포들 처리
            while (!pq.isEmpty()) {
                Cell c = pq.poll();
                int x = c.x;
                int y = c.y;

                // 아직 아무 세포도 존재하지 않는 칸에만 번식 가능
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    cell.add(c); // 새로운 세포
                }
            }

            // 현재 존재하는 모든 세포 상태 업데이트
            for (int i = 0; i < cell.size(); i++) {
                Cell cur = cell.get(i);

                if (cur.state == DEAD) continue; // 이미 죽은 세포무시

                // 비활성 상태인 세포가 활성화되는 시점
                if (cur.state == INACTIVE && cur.time == k) {
                    cur.state = ACTIVE; // 활성화됨
                    cur.time = k + cur.life; // 다음 죽는 시점 갱신

                    // 상하좌우로 번식
                    for (int d = 0; d < 4; d++) {
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        pq.add(new Cell(nx, ny, k + 1 + cur.life, cur.life)); 
                        // 새 세포는 다음 시간에 비활성으로 생성됨
                    }

                } else if (cur.state == ACTIVE && cur.time == k) {
                    // 활성 상태 유지 시간 끝나면 죽음 처리
                    cur.state = DEAD;
                    cur.time = 0;
                    cur.life = 0;
                }
            }
        }
    }

    // 살아 있는 세포 수 세기 (비활성 or 활성)
    static int count() {
        int cnt = 0;
        for (Cell c : cell) {
            if (c.state == ACTIVE || c.state == INACTIVE) {
                cnt++;
            }
        }
        return cnt;
    }
}
