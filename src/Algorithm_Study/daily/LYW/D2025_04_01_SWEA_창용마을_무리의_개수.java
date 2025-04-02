package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_04_01_SWEA_창용마을_무리의_개수 {
    static int T, n, m;
    static int[] parent, chk;
 
    // 대표를 찾는 메서드
    static int findParent(int x) {
        // 인덱스와 값이 같아지는 경우는 자기자신이 대표
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }
 
     
    // 원소 x와, 원소 y를 같은 집합에 속하도록 만드는 메서드
    static void union(int x, int y) {
        // x가 속해있는 집합의 대표를 찾기
        x = findParent(x);
        // y가 속해있는 집합의 대표를 찾기
        y = findParent(y);
        parent[y] = x;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            // 마을 사람의 수
            n = sc.nextInt();
            // 관계의 수
            m = sc.nextInt();
 
            // 방문배열
            chk = new int[n + 1];
             
            // 집합을 표현할 1차원 배열
            parent = new int[n + 1];
 
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }
 
            for (int i = 0; i < m; i++) {
                // a와 b가 아는사이다
                // a와 b는 같은 집합에 속해있다
                int a = sc.nextInt();
                int b = sc.nextInt();
                union(a, b);
            }
 
            int cnt = 0;
 
            for (int i = 1; i < n + 1; i++) {
                int ip = findParent(i);
                if (ip == i) {
                    cnt++;
                }
            }
 
            System.out.println("#" + test_case + " " + cnt);
        }
    }
 
}