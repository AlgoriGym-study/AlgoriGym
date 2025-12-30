package Algorithm_Study.daily.PJE.D202510;
import java.util.*;
//프로그래머스 순위
public class D20251024 {
    static List<Integer>[] winGraph;  // i가 이긴 선수 목록
    static List<Integer>[] loseGraph; // i를 이긴 선수 목록
    static boolean[] visited;
    static int n;

    public int solution(int n, int[][] results) {
        this.n = n;

        // 그래프 초기화
        winGraph = new ArrayList[n + 1];
        loseGraph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }

        // 결과 입력
        for (int[] r : results) {
            int a = r[0], b = r[1];
            winGraph[a].add(b); // a가 b를 이김
            loseGraph[b].add(a); // b는 a에게 짐
        }

        int answer = 0;

        // 각 선수별로 이길 수 있는 사람 수 + 질 수 있는 사람 수 확인
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int winCount = dfs(i, winGraph);  // i가 이길 수 있는 선수
            visited = new boolean[n + 1];
            int loseCount = dfs(i, loseGraph); // i가 질 수 있는 선수

            if (winCount + loseCount == n - 1)
                answer++;
        }

        return answer;
    }

    // DFS로 연결된 노드 개수 탐색
    static int dfs(int cur, List<Integer>[] graph) {
        visited[cur] = true;
        int count = 0;
        for (int next : graph[cur]) {
            if (!visited[next]) {
                count++;
                count += dfs(next, graph);
            }
        }
        return count;
    }
}
