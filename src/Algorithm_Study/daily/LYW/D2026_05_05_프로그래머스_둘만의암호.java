package Algorithm_Study.daily.LYW;

public class D2026_05_05_프로그래머스_둘만의암호 {
	
	class Solution {
	    public String solution(String s, String skip, int index) {
	        StringBuilder answer = new StringBuilder();

	        for (int i = 0; i < s.length(); i++) {
	            char ch = s.charAt(i);
	            int count = 0;

	            while (count < index) {
	                ch++;

	                if (ch > 'z') {
	                    ch = 'a';
	                }

	                // skip에 포함되지 않은 알파벳만 count
	                if (!skip.contains(String.valueOf(ch))) {
	                    count++;
	                }
	            }

	            answer.append(ch);
	        }

	        return answer.toString();
	    }
	}

}
