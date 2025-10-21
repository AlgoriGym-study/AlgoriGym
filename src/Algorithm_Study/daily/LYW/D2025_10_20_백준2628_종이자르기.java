package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2025_10_20_백준2628_종이자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt();  // 가로 길이 (M)
        int height = sc.nextInt(); // 세로 길이 (N)
        int cuts = sc.nextInt();   // 절단 횟수

        List<Integer> horizontalCuts = new ArrayList<>();
        List<Integer> verticalCuts = new ArrayList<>();

        horizontalCuts.add(0); // 시작점
        horizontalCuts.add(height); // 끝점
        verticalCuts.add(0);
        verticalCuts.add(width);

        for (int i = 0; i < cuts; i++) {
            int dir = sc.nextInt(); // 0이면 가로, 1이면 세로
            int pos = sc.nextInt(); // 자르는 위치

            if (dir == 0) {
                horizontalCuts.add(pos);
            } else {
                verticalCuts.add(pos);
            }
        }

        Collections.sort(horizontalCuts);
        Collections.sort(verticalCuts);

        int maxArea = 0;

        for (int i = 1; i < horizontalCuts.size(); i++) {
            int h = horizontalCuts.get(i) - horizontalCuts.get(i - 1);
            for (int j = 1; j < verticalCuts.size(); j++) {
                int w = verticalCuts.get(j) - verticalCuts.get(j - 1);
                int area = w * h;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        System.out.println(maxArea);
    }
}
