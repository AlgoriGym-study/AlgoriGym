package Algorithm_Study.daily.LYW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class D2025_04_03_SWEA_작업순서 {
 
    static List<Integer>[] graph;
    static boolean[] check;
    static boolean[] start;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
            // 정점개수
            int V = sc.nextInt();
            // 간선개수
            int E = sc.nextInt();
 
            graph = new ArrayList[V + 1];
            check = new boolean[V + 1];
            // 다음 노드로 갈 수 있는지 확인
            start = new boolean[V + 1];
 
            // 객체 배열 초기화
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
 
            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
 
                // a로 등장한 적이 있는 노드는 다음 단계가 있다는 뜻
                start[a] = true;
                // b를 가리키는 간선의 출발점은 어디인지 저장
                graph[b].add(a);
            }
 
            System.out.print("#" + tc + " ");
            for (int v = 1; v <= V; v++) {
                if (start[v])
                    continue;
                job(v);
            }
            System.out.println();
        }
 
    }
 
    // num 번호의 일을 실행하는 재귀함수
    static void job(int num) {
        if (check[num])
            return;
 
        // num으로 도달하기 전에 거쳐야 하는 노드 순회
        for (int prev : graph[num]) {
            job(prev);
        }
 
        // 이전 단계를 다 끝냈으니까 num번 일 처리
        System.out.print(num + " ");
        check[num] = true;
    }
 
} 