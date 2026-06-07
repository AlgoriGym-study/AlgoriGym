package Algorithm_Study.daily.KMR;

public class D20260602_PRO_네트워크 {
    private boolean[] visited;
    private int n;
    private int[][] computers;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        this.n = n;
        this.computers = computers;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int idx) {
        visited[idx] = true;

        for (int i = 0; i < n; i++) {
            if (computers[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
