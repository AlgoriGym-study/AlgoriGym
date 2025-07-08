package Algorithm_Study.common.C202507.C20250709;

import java.util.*;

public class LYW0030 {
    static int N, M;
    static int[][] city;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    
    static int minDistance = Integer.MAX_VALUE;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 도시 크기
        M = sc.nextInt(); // 선택할 치킨집 수
        city = new int[N][N];

        // 도시 정보 입력 + 집/치킨집 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) homes.add(new int[]{i, j});
                else if (city[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        selected = new int[M]; // M개 고를 조합 인덱스
        comb(0, 0); // 조합 시작

        System.out.println(minDistance);
        sc.close();
    }

    // 조합 구하기 (치킨집 중 M개 선택)
    static void comb(int depth, int start) {
        if (depth == M) {
            // 선택된 M개의 치킨집으로 도시 치킨 거리 계산
            int distSum = calcChickenDistance();
            minDistance = Math.min(minDistance, distSum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    // 현재 선택된 치킨집 조합으로 도시 치킨 거리 계산
    static int calcChickenDistance() {
        int sum = 0;

        for (int[] home : homes) {
            int hx = home[0], hy = home[1];
            int min = Integer.MAX_VALUE;

            for (int idx : selected) {
                int[] chicken = chickens.get(idx);
                int cx = chicken[0], cy = chicken[1];
                int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                min = Math.min(min, dist);
            }

            sum += min; // 이 집의 치킨 거리 더함
        }

        return sum;
    }
}