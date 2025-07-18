package Algorithm_Study.common.C202507.C20250709;
import java.util.*;

public class LYW0030_2 {
    static int N, M;
    static int[][] city;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minTotalDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) houses.add(new int[]{i, j});
                else if (city[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }
        
        int chickenCount = chickens.size();
        int[] chickenIdx = new int[M];
        comb(0, 0, chickenIdx, chickenCount); 


        System.out.println(minTotalDistance);
    }

static void comb(int start, int depth, int[] chickenIdx, int total) {
    if (depth == M) {
        List<int[]> selectedChickens = new ArrayList<>();
        for (int idx : chickenIdx) {
            selectedChickens.add(chickens.get(idx)); 
        }
        int totalDistance = calCityChickenDistance(selectedChickens);
        minTotalDistance = Math.min(minTotalDistance, totalDistance); 
        return;
    }

    for (int i = start; i < total; i++) {
        chickenIdx[depth] = i;
        comb(i + 1, depth + 1, chickenIdx, total);
    }
}


    static int calCityChickenDistance(List<int[]> selectedChickens) {
        int sum = 0;

        for (int[] house : houses) {
            int hx = house[0], hy = house[1];
            int minDist = Integer.MAX_VALUE;

            for (int[] chicken : selectedChickens) {
                int cx = chicken[0], cy = chicken[1];
                int dist = Math.abs(hx - cx) + Math.abs(hy - cy); 
                minDist = Math.min(minDist, dist);
            }

            sum += minDist;
        }

        return sum;
    }
}
