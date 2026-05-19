package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2026_05_19_프로그래머스_공원산책 {
	
	class Solution {
	    public int[] solution(String[] name, int[] yearning, String[][] photo) {
	        int[] answer = new int[photo.length];

	        Map<String, Integer> map = new HashMap<>();

	        // 이름별 추억 점수 저장
	        for (int i = 0; i < name.length; i++) {
	            map.put(name[i], yearning[i]);
	        }

	        // 사진마다 점수 합산
	        for (int i = 0; i < photo.length; i++) {
	            int sum = 0;

	            for (int j = 0; j < photo[i].length; j++) {
	                String person = photo[i][j];

	                // 사진 속 사람이 점수표에 있으면 더하기
	                if (map.containsKey(person)) {
	                    sum += map.get(person);
	                }
	            }

	            answer[i] = sum;
	        }

	        return answer;
	    }
	}
	
}
