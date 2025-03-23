package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D20250323 {
  static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        String[] inputNM = br.readLine().split(" ");
        N = Integer.parseInt(inputNM[0]);
        M = Integer.parseInt(inputNM[1]);
        
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];
        
        String[] input = br.readLine().split(" ");
        br.close();
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        Arrays.sort(arr);
        comb(0, 0);
        System.out.print(sb);
    }
    
    private static void comb(int idx, int start) {
        if(idx == M) {
            for(int n : result) sb.append(n).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = start; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[idx] = arr[i];
            comb(idx+1, i);
            visited[i] = false;
        }
    }
}
