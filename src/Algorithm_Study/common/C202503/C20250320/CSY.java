package Algorithm_Study.common.C202503.C20250320;

import java.util.Arrays;
import java.util.Scanner;

public class CSY {
    static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // testcase
        String s = "";
        for (int tc = 1; tc <= T; tc++) {

            int V = sc.nextInt(); // 정점의 개수
            int E = sc.nextInt(); // 간선의 수
            int A = sc.nextInt(); // 첫번째 정점
            int B = sc.nextInt(); // 두번째 정점

            tree = new int[V + 1][3]; // [왼자, 오자, 부모]
            for (int i = 1; i <= E; i++) {
                int p = sc.nextInt();
                int ch = sc.nextInt();

                // 왼자가 없는 경우
                if (tree[p][0] == 0) {
                    tree[p][0] = ch;
                } else { // 왼자가 있는 경우
                    tree[p][1] = ch;
                }
                tree[p][2] = p; // 부모값 저장
            } // input
            // 공통 조상 찾기
            int cm = findCM(A, B);
            // 서브쿼리 사이즈 구하기
            int sub = countSub(cm);

            s += "#" + tc + " " + cm + " " + sub + "\n";
        }
        System.out.println(s);
    }// main

    static int findCM(int A, int B) {
        int cm = 0;
        boolean[] visited = new boolean[tree.length];

        int target = A; // 타겟은 A부터 시작!

        for (int i = 0; i < tree.length; i++) {
            if(target == 1) break; // 타켓이 1이면 더이상 찾을 부모가 없음.

            if (target == tree[i][0] || target == tree[i][1]) { // 왼/오자에 타겟이 있다면
                visited[i] = true; // 방문 배열에 true로 변경(B를 위해)
                target = tree[i][2]; // 다음 타겟은 찾은 값의 부모로 갱신
                i = 0; // 다시 처음부터 찾아야 하기 때문에 i값 0으로 초기화
            }
        }

        //visited를 통해 A와 B의 공통 부모 찾기
        target = B;

        for(int i = 0; i < tree.length; i++) {
            // 왼/오자에 타겟이 있다면
            if(target == tree[i][0] || target == tree[i][1]) {
                // 방문배열이 트루면 A의 부모가 있다는 뜻, 즉, 공통 부모라는 뜻
                if(visited[i]) {
                    cm = tree[i][2];
                    break;
                }else {
                    target = tree[i][2];// 다음 타겟은 찾은 값의 부모로 갱신
                    i = 0; // 다시 처음부터 찾아야 하기 때문에 i값 0으로 초기화
                }
            }
        }
        return cm;
    }

    static int countSub(int sub) {
        // 종료
        if(sub == 0) return 0;

        // 재귀
        int count = 1; // 자기자신 포함
        count += countSub(tree[sub][0]); // 왼자 탐색
        count += countSub(tree[sub][1]); // 오자 탐색

        return count;
    }
}
