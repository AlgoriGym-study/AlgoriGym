package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2025_04_24_SWEA_작업순서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {  
            int V = sc.nextInt();        // 정점 개수
            int E = sc.nextInt();        // 간선 개수

            List<Integer>[] graph = new ArrayList[V + 1]; 
            int[] indegree = new int[V + 1];               // 진입 차수

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph[from].add(to);    // 간선 추가
                indegree[to]++;         // 진입 차수 증가
            }

            Queue<Integer> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();

            // 진입 차수 0인 노드를 큐에 추가
            for (int i = 1; i <= V; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                result.add(current);

                for (int next : graph[current]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            // 출력
            System.out.print("#" + t + " ");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
