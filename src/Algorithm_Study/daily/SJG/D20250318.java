package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250318 {
	static int N, S, cnt;
    static int[] arr; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNS = br.readLine().split(" ");
        N = Integer.parseInt(inputNS[0]);
        S = Integer.parseInt(inputNS[1]);
        cnt = 0;
        
        String[] input = br.readLine().split(" ");
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        
        comb(0, 0, 0);
        System.out.print(cnt);
    }
    
    private static void comb(int idx, int sum, int count) {
    	if(idx == N) {
    		if(sum == S && count > 0) cnt++;
            return;
        }
        
        comb(idx+1, sum + arr[idx], count+1);
        comb(idx+1, sum, count);
    }
}
