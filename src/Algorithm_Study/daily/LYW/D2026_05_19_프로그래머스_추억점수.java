package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2026_05_19_프로그래머스_추억점수 {
	
	class Solution {
	    public int[] solution(String[] park, String[] routes) {
	        int row = park.length;
	        int col = park[0].length();

	        int x = 0;
	        int y = 0;

	        // 시작 위치 S 찾기
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (park[i].charAt(j) == 'S') {
	                    x = i;
	                    y = j;
	                }
	            }
	        }

	        // 명령어 처리
	        for (int i = 0; i < routes.length; i++) {
	            String[] command = routes[i].split(" ");

	            String dir = command[0];
	            int distance = Integer.parseInt(command[1]);

	            int dx = 0;
	            int dy = 0;

	            if (dir.equals("N")) {
	                dx = -1;
	            } else if (dir.equals("S")) {
	                dx = 1;
	            } else if (dir.equals("W")) {
	                dy = -1;
	            } else if (dir.equals("E")) {
	                dy = 1;
	            }

	            boolean possible = true;

	            // 한 칸씩 이동 가능한지 검사
	            for (int step = 1; step <= distance; step++) {
	                int nx = x + dx * step;
	                int ny = y + dy * step;

	                // 공원 밖으로 나가는 경우
	                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
	                    possible = false;
	                    break;
	                }

	                // 장애물을 만나는 경우
	                if (park[nx].charAt(ny) == 'X') {
	                    possible = false;
	                    break;
	                }
	            }

	            // 이동 가능하면 최종 위치 갱신
	            if (possible) {
	                x = x + dx * distance;
	                y = y + dy * distance;
	            }
	        }

	        return new int[]{x, y};
	    }
	}
	
}
