package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2026_05_12_프로그래머스_대충만든자판 {
	

	class Solution {
	    public int[] solution(String[] keymap, String[] targets) {
	        int[] minPress = new int[26];

	        // 처음에는 아주 큰 값으로 초기화
	        Arrays.fill(minPress, Integer.MAX_VALUE);

	        // keymap을 보면서 각 알파벳의 최소 입력 횟수 저장
	        for (String key : keymap) {
	            for (int i = 0; i < key.length(); i++) {
	                char c = key.charAt(i);
	                int index = c - 'A';

	                minPress[index] = Math.min(minPress[index], i + 1);
	            }
	        }

	        int[] answer = new int[targets.length];

	        // target 문자열마다 필요한 입력 횟수 계산
	        for (int i = 0; i < targets.length; i++) {
	            String target = targets[i];
	            int sum = 0;
	            boolean possible = true;

	            for (int j = 0; j < target.length(); j++) {
	                char c = target.charAt(j);
	                int index = c - 'A';

	                // 만들 수 없는 문자가 있으면 -1
	                if (minPress[index] == Integer.MAX_VALUE) {
	                    possible = false;
	                    break;
	                }

	                sum += minPress[index];
	            }

	            if (possible) {
	                answer[i] = sum;
	            } else {
	                answer[i] = -1;
	            }
	        }

	        return answer;
	    }
	}

}
