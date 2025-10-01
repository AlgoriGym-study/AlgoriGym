package Algorithm_Study.common.C202509.C20250924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SJG0046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 건물 개수
            int K = Integer.parseInt(st.nextToken());  // 규칙 개수
            
            int[] buildTime = new int[N + 1];  // 각 건물 짓는데 걸리는 시간
            int[] inDegree = new int[N + 1];   // 진입차수
            int[] totalTime = new int[N + 1];  // 해당 건물까지 걸리는 총 시간
            List<List<Integer>> graph = new ArrayList<>();
            
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            
            // 건물 짓는 시간 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }
            
            // 건설 순서 규칙 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph.get(X).add(Y);  // X → Y
                inDegree[Y]++;
            }
            
            int W = Integer.parseInt(br.readLine());  // 목표 건물
            
            // 위상정렬 시작
            Queue<Integer> queue = new LinkedList<>();
            
            // 진입차수 0인 건물들 큐에 추가
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    totalTime[i] = buildTime[i];
                }
            }
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                
                for (int next : graph.get(current)) {
                    // 현재 경로로 next를 짓는데 걸리는 시간
                    totalTime[next] = Math.max(totalTime[next], 
                                               totalTime[current] + buildTime[next]);
                    
                    inDegree[next]--;
                    
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            
            sb.append(totalTime[W]).append("\n");
        }
        
        System.out.print(sb);
    }
}
