package Algorithm_Study.common.C20250429;

import java.io.*;
import java.util.*;

public class SJG {
	static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] height;
    static int[][] energy;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            height = new int[N][N];
            energy = new int[N][N];	// dp배열처럼 사용할 배열 energy;
            
            // 고도 정보 입력
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    height[i][j] = Integer.parseInt(input[j]);
                    energy[i][j] = INF; // 에너지 초기값 Integer형의 최대값으로 할
                }
            }
            
            bfsDP(0, 0);
            sb.append("#").append(tc).append(" ").append(energy[N-1][N-1]).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
    
    private static void bfsDP(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        energy[startX][startY] = 0;
        queue.offer(new int[]{startX, startY});
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;	// 범위 검사
                
                int moveCost = getMoveCost(x, y, nx, ny);	// 다음 칸으로 이동했을 때 추가로 소모되는 연료의 양 연
                
                // 다음도착할 인덱스의 배열 값이 현재 인덱스의 에너지 값과 이동 시 추가로 소모되는 연료의 양의 합보다 클 때
                if (energy[nx][ny] > energy[x][y] + moveCost) {
                    energy[nx][ny] = energy[x][y] + moveCost;	// 더 작은 값으로 갱신
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    private static int getMoveCost(int x, int y, int nx, int ny) {
        int diff = height[nx][ny] - height[x][y];
        
        if (diff < 0) return 0; // 내리막
        else if (diff == 0) return 1; // 평지
        else return 2 * diff; // 오르막
    }
}
