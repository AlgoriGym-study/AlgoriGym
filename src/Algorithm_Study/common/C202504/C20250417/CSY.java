package Algorithm_Study.common.C202504.C20250417;


import java.io.*;
import java.util.*;

public class CSY {


    static class Cell implements Comparable<Cell> {
            int r, c;
            int life;       // 생명력 수치
            int time;       // 시간 흐름 (비활성 상태에서 경과 시간 or 활성 상태 경과 시간)
            int status;     // 0: 비활성, 1: 활성

            public Cell(int r, int c, int life, int time, int status) {
                this.r = r;
                this.c = c;
                this.life = life;
                this.time = time;
                this.status = status;
            }

            @Override
            public int compareTo(Cell o) {
                return Integer.compare(o.life, this.life); // 생명력 내림차순 (큰 게 먼저)
            }
        }

        static int T, N, M, K;
        static final int SIZE = 700; // K(좌) + 입력자체의 크기(50) + K(우)
        static final int OFFSET = 300; // 배열의 중앙값. (0,0)부터 시작하면 음수인덱스로 에러날 수 있음
        static int[][] board = new int[SIZE][SIZE];// 배열의 최대 크기!(이 값을 벗어나지 않음)
        static boolean[][] visited = new boolean[SIZE][SIZE];

        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int tc = 1; tc <= T; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken()); //(1≤N≤50, 1≤M≤50)
                M = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken()); // 배양 시간

                Queue<Cell> queue = new LinkedList<>();

                for (int i = 0; i < N; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < M; j++) {
                        int x = Integer.parseInt(st.nextToken());
                        if (x > 0) { // 주어진 세포가 있다는 뜻
                            int r = OFFSET + i; // 중앙에서 시작
                            int c = OFFSET + j;
                            board[r][c] = x;
                            visited[r][c] = true;
                            queue.offer(new Cell(r, c, x, 0, 0)); // 초기에는 비활성 상태로 시작
                        }
                    }
                }

                // K시간 동안 시뮬레이션
                for (int time = 1; time <= K; time++) {
                    PriorityQueue<Cell> newCells = new PriorityQueue<>(); //생명력이 큰 세포들순으로 정렬
                    int size = queue.size(); // 처음에 문제에서 주어진 세포들의 수(즉, 번식된 적 없음)

                    for (int i = 0; i < size; i++) {
                        Cell cell = queue.poll();

                        if (cell.status == 0) { // 비활성
                            if (cell.time + 1 == cell.life) {
                                // 활성화됨
                                queue.offer(new Cell(cell.r, cell.c, cell.life, 0, 1)); //시간은 0으로!
                            } else {
                                // 비활성 상태 유지(시간은 지났으니까 비활성 상태이지만 한시간 추가해서 큐에 넣기)
                                queue.offer(new Cell(cell.r, cell.c, cell.life, cell.time + 1, 0));
                            }
                        } else if (cell.status == 1) { // 활성
                            // 1시간마다 전파 시도
                            if (cell.time == 0) { // 활성 상태로 바꼈는데, 시간이 0부터 시작이니까
                                for (int d = 0; d < 4; d++) {
                                    int nr = cell.r + dr[d];
                                    int nc = cell.c + dc[d];

                                    if (!visited[nr][nc]) {
                                        // 번식되는 애들은 만약 자리가 겹치면 생명력이 큰 순으로 차지하기 때문에 우선순위 큐에 넣음.
                                        newCells.offer(new Cell(nr, nc, cell.life, 0, 0));
                                    }
                                }
                            }

                            if (cell.time + 1 < cell.life) {// 활성 가능한 상태! 시간만 바꿔서 큐에 넣어주기.
                                queue.offer(new Cell(cell.r, cell.c, cell.life, cell.time + 1, 1)); // 아직 활성 중
                            }
                            // 아니면 죽음
                        }
                    }

                    // 전파 우선순위 처리
                    while (!newCells.isEmpty()) {
                        Cell c = newCells.poll(); // 생명력이 큰 순으로 나옴
                        if (!visited[c.r][c.c]) { // 생명력이 큰 애들부터 방문 체크가 되어서 같은 자리여도 생명력이 작은 애들은 그냥 빠져나감.
                            visited[c.r][c.c] = true;
                            board[c.r][c.c] = c.life;
                            queue.offer(c);// 다음시간대에 활동하도록 큐에 추가
                        }
                    }
                }// K시간동안 시뮬레이션

                sb.append("#").append(tc).append(" ").append(queue.size()).append("\n");
                // 초기화 // 위에서 사이즈와 함께 스테틱하게 정의했기 때문에 테스트케이스마다 초기화 해주어야 함.
                for (int i = 0; i < SIZE; i++) {
                    Arrays.fill(board[i], 0);
                    Arrays.fill(visited[i], false);
                }
            }

            System.out.println(sb.toString());
        }
    }

