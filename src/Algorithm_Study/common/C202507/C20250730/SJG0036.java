package Algorithm_Study.common.C202507.C20250730;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SJG0036 {
    static int N, M;
    static int[][] grid;
    static int[][][] tetrominos = {
      // O자형
      {{0,0},{0,1},{1,0},{1,1}},
      // I자형 (가로·세로)
      {{0,0},{0,1},{0,2},{0,3}},
      {{0,0},{1,0},{2,0},{3,0}},
      // T자형 4가지
      {{0,0},{0,1},{0,2},{1,1}},
      {{0,1},{1,0},{1,1},{2,1}},
      {{1,0},{1,1},{1,2},{0,1}},
      {{0,0},{1,0},{1,1},{2,0}},
      // S/Z자형 4가지
      {{0,0},{0,1},{1,1},{1,2}},
      {{1,0},{1,1},{0,1},{0,2}},
      {{0,1},{1,1},{1,0},{2,0}},
      {{0,0},{1,0},{1,1},{2,1}},
      // L/J자형 8가지
      {{0,0},{1,0},{2,0},{2,1}},
      {{0,1},{1,1},{2,1},{2,0}},
      {{0,0},{0,1},{1,0},{2,0}},
      {{0,0},{0,1},{1,1},{2,1}},
      {{0,0},{1,0},{1,1},{1,2}},
      {{0,2},{1,2},{1,1},{1,0}},
      {{0,0},{0,1},{0,2},{1,0}},
      {{0,0},{0,1},{0,2},{1,2}},
    };
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        // 모든 칸, 모든 모양을 대입
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int t = 0; t < tetrominos.length; t++){
                    int sum = 0;
                    boolean ok = true;
                    // 4칸씩 체크
                    for(int k = 0; k < 4; k++){
                        int ni = i + tetrominos[t][k][0];
                        int nj = j + tetrominos[t][k][1];
                        if(ni < 0 || ni >= N || nj < 0 || nj >= M){
                            ok = false;
                            break;
                        }
                        sum += grid[ni][nj];
                    }
                    if(ok) answer = Math.max(answer, sum);
                }
            }
        }
        
        System.out.print(answer);
    }
}
