package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2026_05_12_프로그래머스_덧칠하기 {
	
	class Solution {
	    public int solution(int n, int m, int[] section) {
	        int answer = 0;

	        // 현재까지 롤러로 칠해진 마지막 위치
	        int paintedEnd = 0;

	        for (int i = 0; i < section.length; i++) {
	            // 아직 칠해지지 않은 구역이면
	            if (section[i] > paintedEnd) {
	                answer++;

	                // section[i]부터 m칸 칠함
	                paintedEnd = section[i] + m - 1;
	            }
	        }

	        return answer;
	    }
	}

}
