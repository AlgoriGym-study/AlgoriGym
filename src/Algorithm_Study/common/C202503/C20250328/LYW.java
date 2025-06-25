package Algorithm_Study.common.C202503.C20250328;
import java.util.*;

public class LYW {
    static int N, M;
    static ArrayList<Integer>[] taller;
    static ArrayList<Integer>[] shorter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 학생 수
        M = sc.nextInt(); // 비교 횟수

        // 인접 리스트 초기화
        taller = new ArrayList[N + 1];
        shorter = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            taller[i] = new ArrayList<>();
            shorter[i] = new ArrayList<>();
        }

        // 그래프 입력 받기
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // a < b 라는 뜻이므로
            taller[a].add(b);   // a보다 큰 학생
            shorter[b].add(a);  // b보다 작은 학생
        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            boolean[] visited1 = new boolean[N + 1];
            boolean[] visited2 = new boolean[N + 1];

            int bigger = dfs(i, taller, visited1);
            int smaller = dfs(i, shorter, visited2);
            
            // A보다 작다고 확인된 학생 수 + A보다 크다고 확인된 학생 수 = N - 1이면,
            // A는 나머지 모든 학생들과 키 비교 결과를 알고 있는 상태 -> 자신이 몇번째인지 알 수 있다
            if (bigger + smaller == N - 1) {
                result++;
            }
        }

        System.out.println(result);
    }

    // DFS를 사용하여 연결된 학생 수 세기
    static int dfs(int now, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[now] = true;
        int count = 0;
        for (int next : graph[now]) {
            if (!visited[next]) {
                count += 1 + dfs(next, graph, visited);
            }
        }
        return count;
    }
}
