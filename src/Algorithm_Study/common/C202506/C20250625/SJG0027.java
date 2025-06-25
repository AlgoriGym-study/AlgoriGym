package Algorithm_Study.common.C202506.C20250625;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class SJG0027 {
    static final int INF = Integer.MAX_VALUE;   // 무한대 값
    static int N, M;    // 시작 위치와 목표 위치
    static int[] time;  // 각 위치까지 도달하는 최소 시간
    static int MAX_SIZE = 100_001;  // 최대 위치 크기 (0부터 100000까지)
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 시작 위치
        M = Integer.parseInt(input[1]); // 목표 위치
        
        // 시작 위치와 목표 위치가 같으면 시간 0초
        if(N == M) {
            System.out.print(0);
            br.close();
            return;
        }
        
        // 시간 배열 초기화
        time = new int[MAX_SIZE];   
        for(int i = 0; i < MAX_SIZE; i++) time[i] = INF;
        
        dijkstra(N);
        
        System.out.print(time[M]);
        br.close();
    }
    
    private static void dijkstra(int start) {
        // 우선순위 큐를 사용하여 최소 시간을 기준으로 노드를 처리
        // 노드: 위치 x, 시간 time
        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.time - n2.time;
        });
        
        time[start] = 0;
        pq.offer(new Node(start, time[start]));
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int spot = curr.x;
            int currTime = curr.time;
            
            // 현재 위치의 시간보다 더 큰 시간으로 도달했다면 무시
            if(currTime > time[spot]) continue;
            // 목표 위치에 도달했으면 종료
            if(spot == M) return;
            
            // 3가지 이동 방법
            // 1. 순간이동 (2*X, 시간 0초)

            if(spot * 2 < MAX_SIZE && time[spot * 2] > currTime) {
                time[spot * 2] = currTime;
                pq.offer(new Node(spot * 2, time[spot * 2]));
            }
            
            // 2. 뒤로 걷기 (X-1, 시간 1초)
            if(spot - 1 >= 0 && time[spot - 1] > currTime + 1) {
                time[spot - 1] = currTime + 1;
                pq.offer(new Node(spot - 1, time[spot - 1]));
            }
            
            // 3. 앞으로 걷기 (X+1, 시간 1초)
            if(spot + 1 < MAX_SIZE && time[spot + 1] > currTime + 1) {
                time[spot + 1] = currTime + 1;
                pq.offer(new Node(spot + 1, time[spot + 1]));
            }
        }
    }
    
    static class Node {
        int x;
        int time;
        
        Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
