package Algorithm_Study.daily.CSY;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D20250330_파핑파핑지뢰찾기 {
    static int N;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};

    static boolean inBoard(int r, int c){
        return (r >= 0 && r < N && c >= 0 && c < N);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++){

            N = sc.nextInt();
            char[][] board = new char[N][N];
            int[][] count = new int[N][N]; // 주변 폭탄 수 센 배열
            for(int i = 0; i < N; i++){
                board[i] = sc.next().toCharArray();
                for(int j = 0; j < N; j++){
                    if(board[i][j] == '*'){
                        for(int d = 0; d < 8; d++){
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if(inBoard(nr,nc)) count[nr][nc]++;
                        }
                    }
                }
            }// input

            int click = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(count[i][j] == 0 && board[i][j] != '*'){
                        click++;
                        Queue<int[]> q = new LinkedList<>();
                        board[i][j] = '*';
                        q.add(new int[]{i, j});
                        while(!q.isEmpty()){
                            int r = q.peek()[0];
                            int c = q.peek()[1];
                            q.poll();

                            for(int d = 0; d < 8; d++){
                                int nr = r + dr[d];
                                int nc = c + dc[d];

                                if(!inBoard(nr, nc) || board[nr][nc] == '*') continue;
                                board[nr][nc] = '*';
                                if(count[nr][nc] == 0) q.add(new int[]{nr, nc});
                            }

                        }
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board[i][j] != '*') click++;
                }
            }

            sb.append("#").append(tc).append(" ").append(click).append("\n");
        }
        System.out.println(sb.toString());
    }
}
