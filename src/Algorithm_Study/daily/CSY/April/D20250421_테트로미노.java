package Algorithm_Study.daily.CSY.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250421_테트로미노 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0, M = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        } // input

        int[][][] tetromino = {
            // ㅡ
            {{0,0}, {0,1}, {0,2}, {0,3}},
            // ㅣ
            {{0,0}, {1,0}, {2,0}, {3,0}},

            // 정사각형
            {{0,0}, {0,1}, {1,0}, {1,1}},

            // L자
            {{0,0}, {1,0}, {2,0}, {2,1}},
            {{0,1}, {1,1}, {2,1}, {2,0}},
            {{0,0}, {0,1}, {1,0}, {2,0}},
            {{0,0}, {0,1}, {1,1}, {2,1}},
            {{0,0}, {0,1}, {0,2}, {1,0}},
            {{0,0}, {0,1}, {0,2}, {1,2}},
            {{1,0}, {1,1}, {1,2}, {0,2}},
            {{0,0}, {1,0}, {1,1}, {1,2}},

            // 번개자 (S자/Z자)
            {{0,0}, {0,1}, {1,1}, {1,2}},
            {{0,1}, {1,0}, {1,1}, {2,0}},
            {{0,0}, {1,0}, {1,1}, {2,1}},
            {{0,1}, {0,2}, {1,0}, {1,1}},

            // ㅗ자
            {{0,0}, {0,1}, {0,2}, {1,1}},
            {{1,0}, {1,1}, {1,2}, {0,1}},
            {{0,0}, {1,0}, {2,0}, {1,1}},
            {{0,1}, {1,1}, {2,1}, {1,0}}
        };

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for(int te = 0; te < tetromino.length; te++) {
                    int r = i, c = j;
                    int block = 0;

                    t : for(int t = 0; t < 4; t++) {
                        int nr = r + tetromino[te][t][0];
                        int nc = c + tetromino[te][t][1];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M) break t;
                        block += board[nr][nc];
                    }
                    max = Math.max(max, block);

                }
            } // j
        } // i

        System.out.println(max);

    }

}

