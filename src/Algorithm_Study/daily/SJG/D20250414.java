package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250414 {
  static int N;
  static int[][] adj;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
        
    int N = Integer.parseInt(br.readLine());
        
    adj = new int[N][N];
    for(int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for(int j = 0; j < N; j++) adj[i][j] = Integer.parseInt(input[j]);
    }    // 입력완료!

    for(int k = 0; k < N; k++) {
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          if(adj[i][k] == 1 && adj[k][j] == 1) adj[i][j] = 1;
        }
      }
    }
        
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        sb.append(adj[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
    br.close();
  }
}
