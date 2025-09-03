package Algorithm_Study.common.C202508.C20250820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SJG0041 {
    static int N;
    static int[][] grid, dist;
    
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int pNum = 1;
        
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            
            grid = new int[N][N];
            dist = new int[N][N];
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }
            
            sb.append("Problem ").append(pNum++).append(": ").append(dijkstra()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    
    private static int dijkstra() {
        Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            return n1[2] - n2[2];
        });
        
        dist[0][0] = grid[0][0];
        pq.offer(new int[]{0, 0, grid[0][0]});    // 행, 열, 비용
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];    // 현재 행
            int c = cur[1];    // 현재 열
            int cost = cur[2]; // 비용
            
            if(cost > dist[r][c]) continue;
            
            if(r == N-1 && c == N-1) return cost;
            
            // 4방향 탐색
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
            
                // 범위 체크
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            
                // 새로운 경로의 비용 계산
                int newCost = cost + grid[nr][nc];
            
                // 더 좋은 경로를 발견했다면 업데이트
                if(newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new int[]{nr, nc, newCost});
                }
            }
        }
        // 목표 지점까지의 최소 비용 반환
        return dist[N-1][N-1];
    }
}
