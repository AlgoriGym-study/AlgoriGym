package Algorithm_Study.common.C202507.C20250702;

public class KMR0029_2 {

    public int solution(String[] arr) {
        int numLen = (arr.length + 1) / 2;
        int opLen = numLen - 1;

        int[] number= new int[numLen];
        String[] operator = new String[opLen];
        for (int i = 0; i < opLen; i++) {
            number[i] = Integer.parseInt(arr[2 * i]);
            operator[i] = arr[2 * i + 1];
        }
        number[opLen] = Integer.parseInt(arr[arr.length - 1]);
        // 입력 끝

        // 사칙 연산 접근
        // 연산자 2종류에 대해 최대 + 최대, 최대 - 최소, 최소 + 최대, 최소 - 최소
        // 계산하기 전까지 어느 값이 최대, 최소인지 알 수 없다.
        // 이때 최솟값도 구하는 이유는 최댓값을 구하는데 필요할 수 있기 때문이다.

        int[][] dpMax = new int[numLen][numLen];
        int[][] dpMin = new int[numLen][numLen];

        for (int i = 0; i < numLen; i++) {
            dpMax[i][i] = number[i];
            dpMin[i][i] = number[i];
        }

        for (int length = 2; length <= numLen; length++) {
            // i = 맨 끝 - 더하고자 하는 길이 = 더하고자 하는 첫번째 자리
            // i = row 역할
            for (int i = 0; i < numLen - length; i++) {
                int j = i + length - 1; // 더하고자 하는 마지막 숫자 인덱스

                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;

                // 더하고자 하는 문자 시작: i ~ 더하고자 하는 문자 마지막 j
                // i~k : 왼쪽 구간 (괄호)
                // k+1~j : 오른쪽 구간 (괄호)
                // k = 괄호를 치는 것
                for (int k = i; k < j; k++) {
                    //length = 2일때 dp[0][0] + dp[1][1]을 하면 dp[0][1]에 저장
                    int[] candidates = {
                            calculate(dpMax[i][k], dpMax[k + 1][j], operator[k]),
                            calculate(dpMax[i][k], dpMin[k + 1][j], operator[k]),
                            calculate(dpMin[i][k], dpMax[k + 1][j], operator[k]),
                            calculate(dpMin[i][k], dpMin[k + 1][j], operator[k])
                    };

                    // dp[i][j] 의미: i부터 j까지 더했을 때 결과를 의미한다.
                    for (int candidate : candidates) {
                        dpMax[i][j] = Math.max(dpMax[i][j], candidate);
                        dpMin[i][j] = Math.min(dpMin[i][j], candidate);
                    }
                }// k : 괄호 모든 경우의 수 구하기
            }// i
        }// length

        return dpMax[0][numLen - 1]; // 의미: 모든 수를 더했을 때 최댓값
    }

    public int calculate(int a, int b, String operator) {
        if(operator.equals("+")) return a + b;
        return a - b;
    }

}
