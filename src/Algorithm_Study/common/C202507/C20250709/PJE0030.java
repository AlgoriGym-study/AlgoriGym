package Algorithm_Study.common.C202507.C20250709;
import java.util.*;

// 백준 치킨배달
public class PJE0030 {
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
        int[] chickenIdx = new int[M]; // 선택된 인덱스 저장 배열
        comb(0, 0, chickenIdx, chickenCount); 


        // 결과 출력
        System.out.println(minTotalDistance);
    }

    // 조합
static void comb(int start, int depth, int[] chickenIdx, int total) {
    if (depth == M) { // M개의 치킨집을 모두 선택했을 경우
        List<int[]> selectedChickens = new ArrayList<>();
        for (int idx : chickenIdx) {
            selectedChickens.add(chickens.get(idx)); // 인덱스를 바탕으로 실제 치킨집 위치 추가
        }
        int totalDistance = calCityChickenDistance(selectedChickens); // 선택한 치킨집 조합으로 도시의 총 치킨 거리 계산
        minTotalDistance = Math.min(minTotalDistance, totalDistance); 
        return;
    }

    for (int i = start; i < total; i++) {
        chickenIdx[depth] = i; // 현재 치킨집 인덱스를 저장
        comb(i + 1, depth + 1, chickenIdx, total); // 다음 단계로 재귀
    }
}


    // 도시의 총 치킨 거리 계산
    static int calCityChickenDistance(List<int[]> selectedChickens) {
        int sum = 0;

        for (int[] house : houses) {
            int hx = house[0], hy = house[1];
            int minDist = Integer.MAX_VALUE;

            for (int[] chicken : selectedChickens) {
                int cx = chicken[0], cy = chicken[1];
                int dist = Math.abs(hx - cx) + Math.abs(hy - cy); // 맨해튼 거리
                minDist = Math.min(minDist, dist);
            }

            sum += minDist;
        }

        return sum;
    }
}
