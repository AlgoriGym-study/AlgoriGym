package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D20250403 {
    static int N, K; // N: 시작 위치, K: 목표 위치
    static final int MAX_SPOT = 100_001;  // 최대 위치 -> 0 ~ 100_000
    static int[] time; // 각 위치에 도달하는 최소 시간
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        if(N == K) {
            System.out.print(0);
            br.close();
            return;
        }
        
        time = new int[MAX_SPOT];
        for(int i = 0; i < MAX_SPOT; i++) time[i] = -1;
        
        bfs(N);
        
        System.out.print(time[K]);
        br.close();
    }
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        time[start] = 0;
        q.offer(start);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            if(curr == K) return;
            
            int[] nextList = {curr - 1, curr + 1, curr * 2};
            
            for(int next : nextList) {
                if(next >= 0 && next < MAX_SPOT) {
                    if(time[next] == -1) {
                        time[next] = time[curr] + 1;  // 다음 위치에 도달하는 최소 시간
                        q.offer(next);
                    }
                }
            }
        }
    }
}
