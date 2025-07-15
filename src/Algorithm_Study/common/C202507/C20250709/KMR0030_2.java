package Algorithm_Study.common.C202507.C20250709;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMR0030_2 {
    static int N;
    static int M;
    static int[][] map;
    static List<int[]> chickens;
    static List<int[]> houses;
    static int min;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        min = Integer.MAX_VALUE;
        selected = new int[M];

        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) houses.add(new int[]{i, j});
                else if(map[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }// 입력

        bfs(0, 0);

        System.out.println(min);
        sc.close();
    }//main

    static void bfs(int cIdx, int idx) {
        if(idx == M) {
            int result = calculate(selected.clone());
            min = Math.min(min, result);
            return;
        }
        if(cIdx == chickens.size()) return;

        selected[idx] = cIdx;
        bfs(cIdx + 1, idx + 1);

        bfs(cIdx + 1, idx);
    }

    static int calculate(int[] selected) {
        int sum = 0;
        for (int i = 0; i < houses.size(); i++) {
            int minimum = Integer.MAX_VALUE;

            for (int j = 0; j < selected.length; j++) {
                int hr = houses.get(i)[0];
                int hc = houses.get(i)[1];
                int cr = chickens.get(selected[j])[0];
                int cc = chickens.get(selected[j])[1];

                int result = Math.abs(hr - cr) +  Math.abs(hc - cc);
                minimum = Math.min(minimum, result);
            }
            sum += minimum;
        }
        return sum;
    }

}
