package Algorithm_Study.daily.LYW;

import java.util.ArrayList;
import java.util.Scanner;
 
public class D2025_12_11 {
    static int N, visit;
    static double E;
    static int[][] island;
    static ArrayList<double[]> edges;
    static int[] parent;
 
    public static int findParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }
 
    public static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
 
        parent[y] = x;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            // 섬의 개수
            N = sc.nextInt();
            // 섬의 좌표를 저장할 2차원 배열
            island = new int[N][2];
            // 집합 배열
            parent = new int[N];
 
            // 집합 초기화
            for (int i = 1; i < N; i++) {
                parent[i] = i;
            }
 
            for (int i = 0; i < N; i++) {
                island[i][0] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                island[i][1] = sc.nextInt();
            }
 
            // E : 환경부담세율
            E = sc.nextDouble();
 
            // 간선을 저장할 List
            edges = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double dist = Math.pow(island[i][0] - island[j][0], 2) + Math.pow(island[i][1] - island[j][1], 2);
                    double weight = dist * E;
                    edges.add(new double[] { i, j, weight });
                }
            }
 
            // 정렬 기준 : Compartor : 메서드 딱하나 compare(double[] a, dobule[] b)
            edges.sort((a, b) -> {
                if (a[2] < b[2])
                    return -1; // 자리를 안바꿈
                else if (a[2] > b[2])
                    return 1; // 자리를 바꿔주자
                return 0; // 값이 같다
            });
 
            double answer = 0;
 
            // 오름차순 정렬된 간선들을 순서대로 탐색
            for (double[] edge : edges) {
                int a = (int) edge[0];
                int b = (int) edge[1];
                double weight = edge[2];
 
                // a와 b가 같은 집합에 있으면 사이클이 생기므로
                // 다른 집합에 있을 때만 union 해줘야함
                if (findParent(a) != findParent(b)) {
                    union(a, b);
                    answer += weight;
                }
            }
 
            System.out.println("#" + test_case + " " + Math.round(answer));
        }
 
    }
}