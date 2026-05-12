package Algorithm_Study.daily.LYW;

public class D2026_05_05_프로그래머스_카드뭉치 {
	
	class Solution {
	    public String solution(String[] cards1, String[] cards2, String[] goal) {
	        int idx1 = 0;
	        int idx2 = 0;

	        for (int i = 0; i < goal.length; i++) {
	            String word = goal[i];

	            if (idx1 < cards1.length && cards1[idx1].equals(word)) {
	                idx1++;
	            } 
	            else if (idx2 < cards2.length && cards2[idx2].equals(word)) {
	                idx2++;
	            } 
	            else {
	                return "No";
	            }
	        }

	        return "Yes";
	    }
	}

}
