package Algorithm_Study.daily.LYW;

public class D2026_05_05_프로그래머스_덧칠하기 {
	
	class Solution {
	    public int solution(int n, int m, int[] section) {
	        int answer = 0;
	        int painted = 0; // 현재까지 칠해진 마지막 위치

	        for (int i = 0; i < section.length; i++) {
	            if (section[i] > painted) {
	                answer++;
	                painted = section[i] + m - 1;
	            }
	        }

	        return answer;
	    }
	}
}
