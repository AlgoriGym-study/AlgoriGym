package Algorithm_Study.daily.LYW;
import java.util.Scanner;

class D2025_03_14_SWEA_부분수열의합 {
    static int N, K, cnt;
    static int[] arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            cnt = 0;
            func(0, 0, false); // 부분 수열을 만들기 시작 (sum = 0, 최소 1개 이상 선택해야 하므로 flag 추가)
            System.out.println("#" + test_case + " " + cnt);
        }
    }

    private static void func(int idx, int sum, boolean selected) {
        // 종료 조건: 끝까지 탐색한 경우
        if (idx == N) {
            if (selected && sum == K) { // 최소 하나 이상 선택해야 함
                cnt++;
            }
            return;
        }

        // 현재 원소를 포함하는 경우
        func(idx + 1, sum + arr[idx], true);
        // 현재 원소를 포함하지 않는 경우
        func(idx + 1, sum, selected);
    }
}
