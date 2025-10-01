package Algorithm_Study.common.C202510.C20251001;

public class LYW0048 {
	class Solution {
	    public String solution(String s) {
	        // 공백을 기준으로 문자열을 나눔
	        String[] arr = s.split(" ");
	        
	        // 첫 번째 숫자로 초기화
	        int min = Integer.parseInt(arr[0]);
	        int max = Integer.parseInt(arr[0]);
	        
	        // 나머지 숫자들 비교
	        for (int i = 1; i < arr.length; i++) {
	            int num = Integer.parseInt(arr[i]);
	            if (num < min) {
	                min = num;
	            }
	            if (num > max) {
	                max = num;
	            }
	        }
	        
	        // "(최소값) (최대값)" 형태로 반환
	        return min + " " + max;
	    }
	}

}
