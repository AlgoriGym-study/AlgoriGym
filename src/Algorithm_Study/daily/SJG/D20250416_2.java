package Algorithm_Study.daily.SJG;

import java.io.*;

public class D20250416_2 {
  public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int minSum = calc(input[0]);
        
        for(int i = 1; i< input.length; i++) minSum -= calc(input[i]);
        
        System.out.print(minSum);
        br.close();
    }
    
    private static int calc(String part) {
        int sum = 0;
        String[] num = part.split("\\+");
        for(String str : num) sum += Integer.parseInt(str);
        return sum;
    }
}
