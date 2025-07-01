package Algorithm_Study.common.C202507.C20250702;

import java.util.*;

public class LYW0029 {
    public int solution(String[] arr) {
        List<Integer> nums = new ArrayList<>();  // 숫자들 저장 리스트
        List<Character> ops = new ArrayList<>(); // 연산자들 저장 리스트

        // 입력 배열에서 숫자와 연산자를 번갈아 구분하여 리스트에 저장
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) { // 짝수 인덱스: 숫자
                nums.add(Integer.parseInt(arr[i]));
            } else { // 홀수 인덱스: 연산자
                ops.add(arr[i].charAt(0));
            }
        }

        int n = nums.size(); // 숫자 개수 (DP 테이블 크기)

        // 최대값과 최소값을 저장할 DP 테이블 초기화
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        // 자기 자신 하나만 있는 구간은 그 값이 최대이자 최소
        for (int i = 0; i < n; i++) {
            maxDp[i][i] = nums.get(i);
            minDp[i][i] = nums.get(i);
        }

        // 길이 2 이상인 구간에 대해 DP 진행
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // 끝 인덱스
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                // i ~ j 사이의 가능한 모든 k 위치에서 나누어 계산
                for (int k = i; k < j; k++) {
                    char op = ops.get(k); // 해당 위치의 연산자

                    // 가능한 조합 4가지 (최대/최소 * 최대/최소)
                    int[] candidates = {
                        calc(maxDp[i][k], maxDp[k + 1][j], op),
                        calc(maxDp[i][k], minDp[k + 1][j], op),
                        calc(minDp[i][k], maxDp[k + 1][j], op),
                        calc(minDp[i][k], minDp[k + 1][j], op)
                    };

                    // 모든 결과를 비교해 최대/최솟값 갱신
                    for (int val : candidates) {
                        maxDp[i][j] = Math.max(maxDp[i][j], val);
                        minDp[i][j] = Math.min(minDp[i][j], val);
                    }
                }
            }
        }

        // 전체 수식을 괄호 쳤을 때 만들 수 있는 최댓값 리턴
        return maxDp[0][n - 1];
    }

    // 사칙연산 계산 함수
    private int calc(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0; // 기본값 (도달하지 않음)
    }
}
