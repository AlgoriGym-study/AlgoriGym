package Algorithm_Study.common.C202507.C20250702;

public class LYW0029_2 {
    public int solution(String[] arr) {
        int n = arr.length;

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for (int i = 0; i < n; i += 2) {
            maxDp[i][i] = Integer.parseInt(arr[i]);
            minDp[i][i] = Integer.parseInt(arr[i]);
        }

        for (int len = 3; len <= n; len += 2) {      
            for (int i = 0; i <= n - len; i += 2) { 
                int j = i + len - 1;                 

                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k += 2) {
                    String op = arr[k];  

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

        return maxDp[0][n - 1];
    }

    private int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else return a - b;
    }
}

