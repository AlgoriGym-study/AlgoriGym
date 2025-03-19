import java.io.*;
import java.util.*;

class SJG {
  static int max = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    
    for(int tc = 1; tc <= T; tc++) {
      max = 0;
      int N = Integer.parseInt(br.readLine());
      String[] inputMP = br.readLine().split(" ");
      int M = Integer.parseInt(inputMP[0]);
      int P = Integer.parseInt(inputMP[1]);
      
      int[][] arr = new int[N][2];
      String[] inputA = br.readLine().split(" ");
      String[] inputB = br.readLine().split(" ");
      for(int i = 0; i < N; i ++) {
		    arr[i][0] = Integer.parseInt(inputA[i]);
        arr[i][1] = Integer.parseInt(inputB[i]);
      }
      
      int[] result = new int[N];
      boolean[][] visited = new boolean[N][2];
      
      comb(0, visited, result, arr, N);
      sb.append("#").append(tc).append(" ").append(max).append("\n");
    }
    br.close();
    System.out.print(sb);
  }

  public static void comb(int idx, boolean[][] visited, int[] result, int[][] arr, int N) {
    if(idx == N) {
      int sum = 0;
      for(int i = 0; i < N; i++) {
          sum += result[i];
      }
      max = (max < sum) ? sum : max;
      return;
    }
    
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < 2; j++) {
        if(visited[i][j] == true) continue;
        result[idx] = arr[i][j];
        visited[i][j] = true;
        comb(idx+1, visited, result, arr, N);
        visited[i][j] = false;
      }
    }
  }
}