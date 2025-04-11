package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250411 {
  public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < T; tc++) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            
            Deque<Integer> dq = new ArrayDeque<>();
            if(n > 0) {
                String onlyNumArrStr = arrStr.substring(1, arrStr.length() - 1);
                String[] numStrs = onlyNumArrStr.split(",");
                for(String numStr : numStrs) dq.add(Integer.parseInt(numStr));
            }
            
            boolean checkReversed = false;
            boolean checkErr = false;
            
            for(char command : commands) {
                if(command == 'R') checkReversed = !checkReversed;
                else {
                    if(dq.isEmpty()) {
                        checkErr = true;
                        break;
                    }
                    if(!checkReversed) dq.pollFirst();
                    else dq.pollLast();
                }
            }
            
            if(checkErr) sb.append("error").append("\n");
            else {
                sb.append('[');
                while(!dq.isEmpty()) {
                    sb.append(checkReversed ? dq.pollLast() : dq.pollFirst());
                    if(!dq.isEmpty()) sb.append(",");
                }
                sb.append(']').append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
