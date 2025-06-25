package Algorithm_Study.common.C202504.C20250411;

import java.io.*;
import java.util.*;

public class SJG {
	static int n;
    static int[][] field;
    static boolean[][] visited;
    static int[] dr, dc;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        // 주변인덱스 탐색을 위한 델타 배
        dr = new int[] {-1, 1, 0, 0};
        dc = new int[] {0, 0, -1, 1};
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	// 결과값들을 정렬조건에 맞게 출력하기 위한 우선순위 큐 생
            PriorityQueue<Submatrix> pq = new PriorityQueue<>((s1, s2) -> {
                if (s1.size != s2.size) {
                    return s1.size - s2.size; // 1. 면적 오름차순
                } else {
                    return s1.r - s2.r;       // 2. 면적이 같으면 행 오름차순
                }
            });
            // 입력값 n
            n = Integer.parseInt(br.readLine());
            // n * n의 방문 배열 및 행렬의 정보를 가지고 있는 정수형 2차원 배열 field
            visited = new boolean[n][n];
            field = new int[n][n];
            for(int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for(int j = 0;  j < n; j++) field[i][j] = Integer.parseInt(input[j]);
            }	// 행렬 입력값 입력완
 
            // 완전 탐색하며 bfs 수행
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                	// 해당 인덱스의 값이 0이거나 이미 방문한 인덱스라면 continue;
                    if(field[i][j] == 0 || visited[i][j]) continue;
                    // bfs를 수행한 값을 pq에 추가해
                    pq.offer(bfs(i, j));
                }
            }
            // pq.size()로 행렬의 개수를 출력 셋팅
            sb.append("#").append(test_case).append(" ").append(pq.size());
 
            // 우선순위 큐에서 조건에 맞게 정렬된 submatrix인스턴스를 순차적으로 추출하여 행 정보와 열 정보를 출력셋팅 
            while (!pq.isEmpty()) {
                Submatrix s = pq.poll();
                sb.append(" ").append(s.r).append(" ").append(s.c);
            }
            sb.append("\n");
        }
        // 출력셋팅된 값들을 출력
        System.out.print(sb);
        br.close();
    }
     
    // bfs 메서드
    private static Submatrix bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new int[]{r, c});
        
        // 시작점에서 가장 먼 인덱스를 구하기 위한 maxR, maxC를 선언 및 초기화
        int maxR = r;
        int maxC = c;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            
            // 델타배열을 활용한 탐색
            for(int d = 0; d < 4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= n || field[nr][nc] == 0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                
                // 시작점에서 가장 먼 인덱스 값을 구하기 위해 최대값 업데이트
            	maxR = Math.max(maxR, nr);
            	maxC = Math.max(maxC, nc);
            }
        }
        
        // 해당 행렬의 행값과 열 값을 추출
        int row = maxR - r + 1;
        int col = maxC - c + 1;
        return new Submatrix(row, col);
    }
     
    static class Submatrix {
        int r, c, size;
        Submatrix(int r, int c) {
            this.r = r;
            this.c = c;
            this.size = r * c;
        }
    }
}