package Algorithm_Study.daily.PJE;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
//프로그래머스 방문 길이
class D20250409 
{
	//U:0 D:1 L:2 R:3 
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
		
	public int solution(String dirs) {
		Set<String> set = new HashSet<>();
		int r = 5;
		int c = 5;
		
		for (int i = 0; i < dirs.length(); i++) {
			
			int d  = 0;
			char dir = dirs.charAt(i); // U
			
			switch (dir) {
			case 'U': {
				d = 0;
				break;
			}
			case 'D':{
				d = 1;
				break;
			}
			case 'L':{
				d = 2;
				break;
			}
			case 'R' :{
				d = 3;
				break;
			}
			}
			int nr = r + dr[d];
			int nc = c + dc[d];
			if( nr < 0 || 11 <= nr || nc < 0 || 11 <= nc) {
				continue;
			}
			int smallerR = Math.min(nr, r);
			int biggerR = Math.max(nr, r);
			int smallerC = Math.min(nc,c);
			int biggerC = Math.max(nc, c);
			
			set.add(smallerR +" "+ smallerC +" "+ biggerR +" "+ biggerC );
			
			r = nr;
			c = nc;
			
		}
		
		return set.size();
	}
}

