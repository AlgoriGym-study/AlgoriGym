package Algorithm_Study.common.C202507.C20250702;

public class CSY0029 {
    public int solution(String[] arr) {
        int n = arr.length;

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        // 숫자 넣기
        for (int i = 0; i < n; i += 2) {
            maxDp[i][i] = Integer.parseInt(arr[i]);
            minDp[i][i] = Integer.parseInt(arr[i]);
        }

        for (int len = 3; len <= n; len += 2) {      // ① 부분 수식의 길이 (숫자+연산자+숫자 = 최소 3칸)
            for (int i = 0; i <= n - len; i += 2) {  // ② 시작 인덱스 i (0, 2, 4, ...)
                int j = i + len - 1;                 // ③ 끝 인덱스 j

                // ④ 이 구간의 최솟값과 최댓값 초기화
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                // ⑤ 중간에 있는 연산자 위치 k를 기준으로 왼쪽/오른쪽 구간을 나눔
                for (int k = i + 1; k < j; k += 2) {
                    String op = arr[k];  // 연산자

                    // 왼쪽: arr[i..k-1], 오른쪽: arr[k+1..j]
                    int[] left = {maxDp[i][k - 1], minDp[i][k - 1]};
                    int[] right = {maxDp[k + 1][j], minDp[k + 1][j]};

                    // ⑥ 왼쪽 최솟값/최댓값 × 오른쪽 최솟값/최댓값을 조합해서 연산
                    for (int a : left) {
                        for (int b : right) {
                            int val = calc(a, b, op);
                            maxDp[i][j] = Math.max(maxDp[i][j], val);
                            minDp[i][j] = Math.min(minDp[i][j], val);
                        }
                    }
                }
            }
        }
        // 즉, 전체 수식을 연산자 기준으로 좌우로 쪼갬 -> 그 안의 가능한 모든 괄호 조합을 계산하여 DP에 저장

        return maxDp[0][n - 1];
    }

    private int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else return a - b;
    }
}

