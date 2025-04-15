package Algorithm_Study.common.C20250415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CSY {

    static class State {
        int r, c, dir, k, cnt; // 위치, 방향, 벤 나무 수, 조작 수

        public State(int r, int c, int dir, int k, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.k = k;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static char[][] map;
    static int[] start = new int[2];
    static int[] end = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc= 1; tc <= T; tc++){
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()); // 벨 수 있는 나무 수

            map = new char[N][N];
            for(int i = 0; i < N; i++){
                String[] str = br.readLine().split("");
                for(int j = 0; j < N; j++){
                    map[i][j] = str[j].charAt(0);
                    if(map[i][j] == 'X'){
                        start[0] = i;
                        start[1] = j;
                    }else if(map[i][j] == 'Y'){
                        end[0] = i;
                        end[1] = j;
                    }// 시작 및 도착 좌표 저장
                }
            }// input done

            int ans = bfs(K);


            sb.append(ans).append("\n");
        }// tc
        System.out.println(sb.toString());
    }// main

    static int bfs(int K){
        Queue<State> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][N][4][K+1]; // 위치, 방향, 벨 수 있는 나무 수 방문배열

        // 시작 지점 추가 (시작은 0방향)
        visited[start[0]][start[1]][0][K] = true;
        q.offer(new State(start[0], start[1], 0, K, 0 ));

        while (!q.isEmpty()){
            State cur = q.poll();

            // 도착 지점에 도착하면 끝!
            if(cur.r == end[0] && cur.c == end[1]) return cur.cnt;

            // 전진
            int nr = cur.r + dr[cur.dir];
            int nc = cur.c + dc[cur.dir];

            if(nr >= 0 && nr < N && nc >= 0 && nc < N){ // 범위 내에 있고
                // 이동 가능한 곳이면
                if(map[nr][nc] == 'G' || map[nr][nc] == 'Y'){
                    if(!visited[nr][nc][cur.dir][cur.k]){
                        visited[nr][nc][cur.dir][cur.k] = true;
                        q.offer(new State(nr, nc, cur.dir, cur.k, cur.cnt+1)); // 이동!
                    }
                }else if(map[nr][nc] == 'T' && cur.k > 0){ // 나무인데 벨 수 있다면
                    if(!visited[nr][nc][cur.dir][cur.k-1]){
                        visited[nr][nc][cur.dir][cur.k-1] = true;
                        q.offer(new State(nr, nc, cur.dir, cur.k-1, cur.cnt+1)); // 이동!
                    }
                }
            }

            // 좌우회전
            for(int turn = -1; turn <= 1; turn += 2){
                int newDir = (cur.dir + turn + 4) % 4;
                if(!visited[cur.r][cur.c][newDir][cur.k]){
                    visited[cur.r][cur.c][newDir][cur.k] = true;
                    q.offer(new State(cur.r, cur.c, newDir, cur.k, cur.cnt+1)); // 이동
                }
            }

        }

        return -1; // 도착 못하면 -1 리턴
    }
}
