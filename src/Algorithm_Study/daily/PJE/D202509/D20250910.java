package Algorithm_Study.daily.PJE.D202509;
import java.util.*;
// 백준 숨바꼭질
public class D20250910 {
    static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치

        int[] dist = new int[MAX + 1];
        boolean[] visited = new boolean[MAX + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;
        dist[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                System.out.println(dist[cur]);
                return;
            }

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int nx : nexts) {
                if (0 <= nx && nx <= MAX && !visited[nx]) {
                    visited[nx] = true;       // 큐에 넣을 때 방문 표시
                    dist[nx] = dist[cur] + 1; // 현재까지 시간 +1
                    q.offer(nx);
                }
            }
        }
    }
}
