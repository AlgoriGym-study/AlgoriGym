package Algorithm_Study.daily.YHS.before;

import java.util.*;
import java.io.*;

public class D20250412_차윤이의RC카 {
    static final int U = 0;
    static final int D = 1;
    static final int L = 2;
    static final int R = 3;
    static int N, Q;
    static char[][] field;
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            N = Integer.parseInt(br.readLine());

            field = new char[N][N];
            
            Car car = null;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    field[i][j] = str.charAt(j);
                    if (field[i][j] == 'X') {
                        car = new Car(i,j);
                    }
                }
            }

            Q = Integer.parseInt(br.readLine());
            for (int i = 0; i < Q; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                String command = st.nextToken();

                sb.append(move(car,U,C,command) ? 1 : 0).append(" ");
            }

            System.out.println(sb);
        }
    }

    static boolean move(Car car, int dir, int count, String command) {
        int i = 0;
        while (i < count) {
            char ch = command.charAt(i);

            if (ch == 'A') {
                int nr = car.x + drc[dir][0];
                int nc = car.y + drc[dir][1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (field[nr][nc] != 'T') {
                        car = new Car(nr,nc);
                    }
                }
            }
            else if (ch == 'L') {
                if (dir == U)
                    dir = L;
                else if (dir == D)
                    dir = R;
                else if (dir == L)
                    dir = D;
                else
                    dir = U;
            }
            else if (ch == 'R') {
                if (dir == U)
                    dir = R;
                else if (dir == D)
                    dir = L;
                else if (dir == L)
                    dir = U;
                else
                    dir = D;
            }

            i++;
        }

        if (field[car.x][car.y] == 'Y') return true;
        else return false;
    }

    static class Car {
        int x, y;

        public Car(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
