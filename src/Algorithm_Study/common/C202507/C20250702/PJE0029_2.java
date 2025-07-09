package Algorithm_Study.common.C202507.C20250702;
import java.util.*;

// 프로그래머스 사칙연산
class PJE0029_2 {
    int[][] maxDp; //구간 최대값 
    int[][] minDp; //구간 최소값
    String [] arr; // 문자열 배열
    int[] nums; // 숫자
    String[] ops; // 연산자
    public int solution(String arr[]) {
        this.arr = arr;
        int n = (arr.length+1)/2;
        
        //숫자 연산자 분리 
        nums = new int[n];
        ops = new String [n-1];
        
        for(int i = 0; i < arr.length; i++){
            if(i%2 == 0) nums[i/2] = Integer.parseInt(arr[i]);
            else ops[i/2] = arr[i];
        }
        
        //dp배열 초기화 
        maxDp = new int[n][n];
        minDp = new int[n][n];
        for(int[] row : maxDp) 
            Arrays.fill(row,Integer.MIN_VALUE);
        for(int[] row : minDp)
            Arrays.fill(row, Integer.MAX_VALUE);
        //최댓값 리턴
        return getMax(0,n-1);
    }
    int getMax(int i, int j){ // i~j까지 괄호로 나올 수 있는 최대값 
        if(maxDp[i][j] != Integer.MIN_VALUE) return maxDp[i][j];
        if( i == j ) return maxDp[i][j] = nums[i];
        
        for(int k = i; k < j; k++){
            int leftMax = getMax(i,k);
            int leftMin = getMin(i,k);
            int rightMax = getMax(k+1,j);
            int rightMin = getMin(k+1, j);
            
            String op = ops[k];
            if(op.equals("+")){
                maxDp[i][j] = Math.max(maxDp[i][j], leftMax+rightMax);
            }else{
                maxDp[i][j] = Math.max(maxDp[i][j], leftMax-rightMin);
            }
        }
        return maxDp[i][j];
    }
    int getMin(int i, int j){
        if(minDp[i][j]!=Integer.MAX_VALUE) return minDp[i][j];
        if(i ==j) return minDp[i][j] = nums[i];
        for(int k = i; k < j; k++){
            int leftMax = getMax(i,k);
            int leftMin = getMin(i,k);
            int rightMax = getMax(k+1,j);
            int rightMin = getMin(k+1,j);
            
            String op = ops[k];
            if(op.equals("+")){
                minDp[i][j] = Math.min(minDp[i][j], leftMin + rightMin);
            }else{
                minDp[i][j] = Math.min(minDp[i][j], leftMin - rightMax);
            }
        }
        return minDp[i][j];
    }
}
