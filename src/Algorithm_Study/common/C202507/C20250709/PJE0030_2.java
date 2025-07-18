package Algorithm_Study.common.C202507.C20250709;

import java.util.*;

// 백준 치킨배달
public class PJE0030_2 {
    private static List<Pair> home;
    private static List<Pair> chicken;
    private static int ans;
    
    private static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 도시의 크기
        int m = sc.nextInt(); // 최대 선택할 치킨집 수
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        List<Pair> selectedChicken = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
                int temp = sc.nextInt();
                if (temp == 1) {
                    home.add(new Pair(i, j)); // 집의 좌표
                } else if (temp == 2) {
                    chicken.add(new Pair(i, j)); // 치킨집의 좌표
                }
            }
        }

        combination(m, selectedChicken, 0);

        System.out.println(ans);
    }

    private static void combination(int r, List<Pair> result, int index) {
        if (result.size() == r) {
            ans = Math.min(ans, calculateCityMin(result));
            return;
        }
        for (int i = index; i < chicken.size(); i++) {
            result.add(chicken.get(i));
            combination(r, result, i + 1);
            result.remove(result.size() - 1);
        }
    }

    private static int calculateMin(int r, int c, List<Pair> chicken) {
        int min = Integer.MAX_VALUE;
        for (Pair pair : chicken) {
            min = Math.min(min, Math.abs(pair.r - r) + Math.abs(pair.c - c));
        }
        return min;
    }

    private static int calculateCityMin(List<Pair> selectedChicken) {
        int distance = 0;
        for (Pair homePair : home) {
            distance += calculateMin(homePair.r, homePair.c, selectedChicken);
        }
        return distance;
    }

  
}
