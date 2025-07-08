package Algorithm_Study.common.C20250702;

import java.util.*;

// 프로그래머스 사칙연산
class PJE0029 {
    int[][] maxDp; // 구간 최대값 
    int[][] minDp; // 구간 최소값
    String[] arr; // 문자열배열
    int[] nums; // 숫자
    String[] ops; // 연산자
    
    public int solution(String arr[]) {
        this.arr = arr;
        int n = (arr.length+1)/2;
        
        // 숫자랑 연산자 분리하기
        nums = new int[n];
        ops = new String [n-1];
        
        for(int i = 0; i < arr.length; i++){
            if(i%2 == 0) nums[i/2] = Integer.parseInt(arr[i]);
            else ops[i/2] = arr[i];
        }
        
        // dp 배열 초기화 
        maxDp = new int[n][n];
        minDp = new int[n][n];
        
        for(int[] row : maxDp) Arrays.fill(row, Integer.MIN_VALUE);
        for(int[] row : minDp) Arrays.fill(row, Integer.MAX_VALUE);
        
        // 전체 구간에서 구할 수 있는 최댓값 리턴하기
        return getMax(0,n-1);
    }
    // nums[i]부터 nums[j]까지 괄호로 나올 수 있는 최대값 구하기 
    private int getMax(int i, int j) {
        if (maxDp[i][j] != Integer.MIN_VALUE) return maxDp[i][j];// 계산되어있으면 재귀 X 메모이제이션
        if (i == j) return maxDp[i][j] = nums[i];  // 숫자 하나라는 뜻이므로 그대로 반환 

        for (int k = i; k < j; k++) { // 가능한 모든 연산 k에 대해 나누기
            int leftMax = getMax(i, k); // 괄호기준 왼쪽 max
            int leftMin = getMin(i, k); // 왼쪽 min
            int rightMax = getMax(k + 1, j); // 괄호기준 오른쪽 max
            int rightMin = getMin(k + 1, j); // 오른쪽 min

            String op = ops[k];
            if (op.equals("+")) { 
                maxDp[i][j] = Math.max(maxDp[i][j], leftMax + rightMax);
            } else {
                maxDp[i][j] = Math.max(maxDp[i][j], leftMax - rightMin);
            }
        }
        return maxDp[i][j];
    }
    // i~j까지 괄호쳐서 나올 수 있는 가장 작은값 구하기
    private int getMin(int i, int j) {
        if (minDp[i][j] != Integer.MAX_VALUE) return minDp[i][j];
        if (i == j) return minDp[i][j] = nums[i];

        for (int k = i; k < j; k++) {
            //왼쪽 오른쪽
            int leftMax = getMax(i, k);
            int leftMin = getMin(i, k);
            int rightMax = getMax(k + 1, j);
            int rightMin = getMin(k + 1, j);

            String op = ops[k];
            if (op.equals("+")) {
                minDp[i][j] = Math.min(minDp[i][j], leftMin + rightMin);
            } else {
                minDp[i][j] = Math.min(minDp[i][j], leftMin - rightMax);
            }
        }
        return minDp[i][j];
    }
}
