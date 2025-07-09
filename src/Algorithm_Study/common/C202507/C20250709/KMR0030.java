package Algorithm_Study.common.C202507.C20250709;

import java.util.*;

public class KMR0030 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] distance;
    static int[] minDistance;
    static List<int[]> house;
    static List<int[]> chicken;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if(map[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        distance = new int[chicken.size()][house.size()];
        int[] minChicken = new int[house.size()];
        minDistance = new int[house.size()];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        for (int i = 0; i < chicken.size(); i++) {
            for (int j = 0; j < house.size(); j++) {
                distance[i][j] = Math.abs(chicken.get(i)[0] - house.get(j)[0]) + Math.abs(chicken.get(i)[1] - house.get(j)[1]);
                if(distance[i][j] < minDistance[j]) {
                    minDistance[j] = distance[i][j];
                    minChicken[j] = i;
                }
            }
        }// 집-치킨집 거리 모두 계산

        Set<Integer> min = new HashSet<>();
        for (int i = 0; i < house.size(); i++) {
            min.add(minChicken[i]);
        } // 최소 거리 가진 치킨집 - 중복 제거

        if(M >= min.size()) {
            int result = 0;
            for (int d : minDistance) {
                result += d;
            }
            System.out.println(result);
        } else {
            comb(0, 0, new int[M]);
            System.out.println(answer);
        }

        sc.close();
    }

    static void comb(int idx, int sIdx, int[] arr) {
        if(sIdx == M) {
            answer = Math.min(answer, cal(arr.clone()));
            return;
        }

        if (idx == chicken.size()) return;

        arr[sIdx] = idx;
        comb(idx + 1, sIdx + 1, arr);

        comb(idx + 1, sIdx, arr);

    }

    static int cal(int[] arr) {
        int min = 0;

        for (int i = 0; i < house.size(); i++) {
            int value = Integer.MAX_VALUE;
            for (int row : arr) {
                if(value > distance[row][i]) {
                    value = distance[row][i];
                }
            }

            min += value;
        }
        return min;
    }// cal
}
