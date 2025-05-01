package Algorithm_Study.common.C20250501;

public class PJE {
	public static void main(String[] args) {
		Solution7 s = new Solution7();
		String [] command = {"next", "prev"};
		
		String res = s.solution("34:33","13:00", "00:55", "02:55",command);
		System.out.println(res);
	}
}

class Solution7 {
	int time;
	int video_len_toInt, op_start_toInt, op_end_toInt;
	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		split(video_len,pos,op_start,op_end);
        for (int i = 0; i < commands.length; i++) {
        	isBetween();

        	if(commands[i].equals("prev"))
        		prev();
        	else if(commands[i].equals("next"))
        		next();
        	
        	isBetween();	
			
		}
        
        int hour = time/60;
        int min = time%60;
        
        String answer = "";
        String hourToStr = ( hour < 10 )? "0"+hour : hour+"";
        String minToStr = (min < 10 )? "0"+min : min+"";
        answer  = hourToStr + ":"+ minToStr;
        
        return answer;
    }

    private void split(String video_len, String pos, String op_start, String op_end) {
		String [] timeArr = pos.split(":");
        time = Integer.parseInt(timeArr[0])*60 + Integer.parseInt(timeArr[1]);
        video_len_toInt = Integer.parseInt(video_len.split(":")[0])*60 + Integer.parseInt(video_len.split(":")[1]);
        op_start_toInt = Integer.parseInt(op_start.split(":")[0])*60 + Integer.parseInt(op_start.split(":")[1]);
        op_end_toInt = Integer.parseInt(op_end.split(":")[0])*60 + Integer.parseInt(op_end.split(":")[1]);
	}

	private void prev() {
    	time -= 10;
    }

    private void next() {
    	time += 10;
    }
	
    private void isBetween() {
    	if(op_start_toInt <= time && time <= op_end_toInt )
    		time = op_end_toInt;
    	else if( time < 0)
    		time = 0;
    	else if ( video_len_toInt < time )
    		time = video_len_toInt;
    	
	}
}


