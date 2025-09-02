package Algorithm_Study.common.C202508.C20250820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SJG0040 {
    static int N, sangUhSize, count;
    static int[] sangUh;
    static int[][] grid;
    
    // 상 좌 하 우 -> 문제에서 우선순위에 따라..
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        sangUh = new int[2];    // 아기 상어의 위치
        
        sangUhSize = 2;
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 9) {
                    sangUh[0] = i;
                    sangUh[1] = j;
                    grid[i][j] = 0;
                }
            }
        }
        
        System.out.print(simul());
        br.close();
    }
    
    private static int simul() {
        int res = 0;
        
        while(true) {
            int[] target = bfs();
            
            if(target == null) break;
            
            sangUh[0] = target[0];
            sangUh[1] = target[1];
            grid[target[0]][target[1]] = 0;
            res += target[2];
            
            count++;
            if(count == sangUhSize) {
                sangUhSize++;
                count = 0;
            }
        }
        
        return res;
    }
    
    private static int[] bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> dq = new ArrayDeque<>();

        dq.offer(new int[]{sangUh[0], sangUh[1], 0});
        visited[sangUh[0]][sangUh[1]] = true;
    
        while(!dq.isEmpty()) {
            int size = dq.size(); // 현재 거리에 있는 모든 노드 개수
            List<int[]> candidates = new ArrayList<>(); // 현재 거리의 먹을 수 있는 물고기들
        
            // 현재 거리의 모든 노드 처리
            for(int i = 0; i < size; i++) {
                int[] cur = dq.poll();
                int r = cur[0], c = cur[1], dist = cur[2];
            
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
            
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || grid[nr][nc] > sangUhSize) continue;
            
                    visited[nr][nc] = true;
            
                    if(grid[nr][nc] > 0 && grid[nr][nc] < sangUhSize) {
                        candidates.add(new int[]{nr, nc, dist + 1});
                    } else {
                        dq.offer(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        
            // 현재 거리에서 먹을 수 있는 물고기가 있으면 우선순위에 따라 선택
            if(!candidates.isEmpty()) {
                candidates.sort((a, b) -> {
                    if(a[0] != b[0]) return a[0] - b[0]; // 행 우선
                    return a[1] - b[1]; // 열 우선
                });
                return candidates.get(0);
            }
        }
    
        return null;
    }
}
