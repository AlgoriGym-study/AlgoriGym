package Algorithm_Study.daily.CSY.March;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D20250312_요리사 {

    static int[][] arr;
    static List<Integer> A; // A요리
    static List<Integer> B; // B요리
    static int N;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        String s = "";

        for(int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();
            arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }// input

            A = new ArrayList<>();
            B = new ArrayList<>();
            min = Integer.MAX_VALUE;

            A.add(0); // 중복을 방지하기 위해 A에 미리 0 추가.
            recur(1);

            s += "#" + tc + " " + min + "\n";
        }//tc
        System.out.println(s);
    }

    static void recur(int idx) {
        // 종료
        if(idx == N) { //모든 식재료를 다 썼으면, 이제 각 요리의 시너지를 구해야 함.
            int ASum = 0; // A요리
            for(int i = 0; i < N/2; i++) {
                int a = A.get(i);
                for(int j = i + 1; j < N/2; j++) {
                    int b = A.get(j);

                    ASum += arr[a][b] + arr[b][a];
                }
            }

            int BSum = 0; // B요리
            for(int i = 0; i < N/2; i++) {
                int a = B.get(i);
                for(int j = i + 1; j < N/2; j++) {
                    int b = B.get(j);

                    BSum += arr[a][b] + arr[b][a];
                }
            }

            min = Math.min(min, Math.abs(ASum - BSum));

        }

        // 재귀
        if(A.size() < N/2) {
            A.add(idx);
            recur(idx+1);
            A.remove(A.size()-1); // 원래대로 돌려주기 위해 인덱스로 원소 삭제
        }

        if(B.size() < N/2) {
            B.add(idx);
            recur(idx+1);
            B.remove(B.size()-1); // 원래대로 돌려주기 위해 인덱스로 원소 삭제
        }
    }

}
