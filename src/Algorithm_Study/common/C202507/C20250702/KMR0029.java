package Algorithm_Study.common.C202507.C20250702;

public class KMR0029 {
    static int len;
    static int[] num;
    static String[] opr;
    static int[][] dpMax, dpMin;

    public int solution(String[] arr) {
        len = (arr.length + 1) / 2; // 숫자의 개수
        num = new int[len];
        opr = new String[len - 1];

        // 입력
        for (int i = 0; i < len; i++) {
            num[i] = Integer.parseInt(arr[2 * i]);
        }
        for (int i = 0; i < len - 1; i++) {
            opr[i] = arr[2 * i + 1];
        }

        // DP 배열 초기화 (최대값과 최소값 모두 추적)
        dpMax = new int[len][len];
        dpMin = new int[len][len];

        // 단일 숫자 초기화
        for (int i = 0; i < len; i++) {
            dpMax[i][i] = num[i];
            dpMin[i][i] = num[i];
        }

        // Bottom-up DP: 구간 길이별로 처리
        for (int length = 2; length <= len; length++) { // length: 포함되는 숫자의 개수, 연산하는 숫자 개수임
            for (int i = 0; i <= len - length; i++) {
                int j = i + length - 1;

                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;

                // 모든 분할점에서 최대/최소값 계산
                for (int k = i; k < j; k++) {
                    int[] candidates = {
                            cal(dpMax[i][k], dpMax[k + 1][j], opr[k]),
                            cal(dpMax[i][k], dpMin[k + 1][j], opr[k]),
                            cal(dpMin[i][k], dpMax[k + 1][j], opr[k]),
                            cal(dpMin[i][k], dpMin[k + 1][j], opr[k])
                    };

                    for (int candidate : candidates) {
                        dpMax[i][j] = Math.max(dpMax[i][j], candidate);
                        dpMin[i][j] = Math.min(dpMin[i][j], candidate);
                    }
                }
            }
        }

        return dpMax[0][len - 1];
    }

    static int cal(int n1, int n2, String operator) {
        if (operator.equals("-")) return n1 - n2;
        return n1 + n2;
    }
}
