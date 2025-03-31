package Algorithm_Study.common.C20250331;

import java.io.*;
import java.util.*;

public class SJG {
    static class Virus implements Comparable<Virus> {
        int time;
        int type;
        int r;
        int c;

        public Virus(int time, int type, int r, int c) {
            this.time = time;
            this.type = type;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Virus other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            }
            return Integer.compare(this.type, other.type);
        }
    }
    
	static int N, K;
    static int[][] map;
    static int S, targetR, targetC;

    // 4방향: 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N, K 입력 받기
        String[] lineNK = br.readLine().split(" ");
        N = Integer.parseInt(lineNK[0]);
        K = Integer.parseInt(lineNK[1]);

        map = new int[N][N];
        PriorityQueue<Virus> pq = new PriorityQueue<>();

        // 시험관 정보 입력 및 초기 바이러스 큐에 삽입
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if (map[i][j] != 0) {
                    pq.offer(new Virus(0, map[i][j], i, j));
                }
            }
        }

        // 목표 시간 S, 목표 위치 X, Y 입력
        String[] lineSXY = br.readLine().split(" ");
        S = Integer.parseInt(lineSXY[0]);
        targetR = Integer.parseInt(lineSXY[1]) - 1;
        targetC = Integer.parseInt(lineSXY[2]) - 1;

        // BFS 시뮬레이션 시작
        while (!pq.isEmpty()) {
            Virus current = pq.poll();

            if (current.time >= S) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = current.type;
                        pq.offer(new Virus(current.time + 1, current.type, nr, nc));
                    }
                }
            }
        }

        sb.append(map[targetR][targetC]);
        System.out.println(sb);

        br.close();
    }
}
