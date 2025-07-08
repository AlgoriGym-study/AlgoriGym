package Algorithm_Study.common.C202507.C20250709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SJG0030 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[][] grid;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = br.readLine().split(" ");
        N = Integer.parseInt(inputNM[0]);    // 도시의 크기
        M = Integer.parseInt(inputNM[1]);    // 남길 치킨집 개수
        grid = new int[N][N];                // 도시 배열
        
        // 입력 및 좌표 수집
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
                if (grid[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (grid[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        
        // 조합용 배열 초기화
        selected = new int[M];
        
        // DFS로 조합 생성 & 평가
        System.out.print(dfs(0, 0));
        br.close();
    }

    // start: 다음으로 고를 치킨집 인덱스, depth: 지금까지 고른 수
    private static int dfs(int start, int depth) {
        if (depth == M) {
            return evaluate();
        }
        int ret = INF;
        for (int i = start; i < chicken.size(); i++) {
            selected[depth] = i;
            ret = Math.min(ret, dfs(i + 1, depth + 1));
        }
        return ret;
    }

    // 현재 selected[]에 담긴 치킨집 조합으로 도시 치킨 거리 계산
    private static int evaluate() {
        int sum = 0;
        for (int[] h : house) {
            int hr = h[0], hc = h[1];
            int minDist = INF;
            for (int idx : selected) {
                int[] c = chicken.get(idx);
                int cr = c[0], cc = c[1];
                int dist = Math.abs(hr - cr) + Math.abs(hc - cc);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
            sum += minDist;
        }
        return sum;
    }
}
