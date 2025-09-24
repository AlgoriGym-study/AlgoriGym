// 프로그래머스 공원산책
public class D20250921 {
        static int R, C;
        static String [][] board;
	
        public int[] solution(String[] park, String[] routes) {
	    	// park S:출발 , X:방해물 O:이동가능 
	    	// routes 방향 거리 , 방향 거리 .. 
	    		int rl = park.length;
	    		int cl = park[0].length();
	    		
	    		board = new String [rl][cl];
	    		for (int i = 0; i < rl; i++) {
	    		    char[] row = park[i].toCharArray(); // "SOO" -> ['S','O','O']
	    		    for (int j = 0; j < cl; j++) {
	    		        board[i][j] = String.valueOf(row[j]);
	    		        if(row[j] == 'S') {
	    		        	R = i;
	    		        	C = j;
	    		        }
	    		    }
	    		}
	    		
	    		int r = R, c = C;
	    		for(String route: routes) { //"E 2","S 2","W 1"
	    			String dir = route.split(" ")[0];
	    			int n = Integer.parseInt(route.split(" ")[1]);
	    			
	    			 // 방향 벡터
	    		    int dr = 0, dc = 0;
	    		    
	    		    switch (dir) {
	    		        case "E": dc = 1;  break;
	    		        case "W": dc = -1; break;
	    		        case "S": dr = 1;  break;
	    		        case "N": dr = -1; break;
	    		    }
	    		    
	    		    
	    		    int nr = r; int nc = c;
	    		    boolean ok=true;
	    		    for(int d = 0; d < n; d++) {
	    		    	nr += dr;
	    		    	nc += dc;
	    		    	if(nr < 0 || nc < 0 || nr >= rl || nc >= cl || board[nr][nc].equals("X")) {
	    		    		ok = false;
	    		    		break;
	    		    	}
	    		    }
	    		   
	    		    if(ok){
	    		    	r = nr;
	    		    	c = nc;	
	    		    }
	    			
	    		}
	    		
	            return new int[]{r, c};
	        }
	    
	}
