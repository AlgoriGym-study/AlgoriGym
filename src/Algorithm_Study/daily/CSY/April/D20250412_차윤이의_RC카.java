package Algorithm_Study.daily.CSY.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250412_차윤이의_RC카 {

    static char[][] arr;
    static char[] command;
    static int N;

    static int[][] go = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    }; // 상우하좌

    static int[] dir = {0, 1, 2, 3}; // 현재 방향 표시 : 상우하좌

    // 방향을 어떻게 바꿀 것인지 고민해볼 것...

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());

            arr = new char[N][N];
            int r = 0, c = 0; // 현재 위치 저장
            // input
            for(int i = 0; i < N; i++) {
                String[] str = br.readLine().split("");
                for(int j = 0; j < N; j++) {
                    arr[i][j] = str[j].charAt(0);
                    if(arr[i][j] == 'X') {
                        r = i;
                        c = j;
                    }// 현재 위치 찾기
                }
            }

            int C = Integer.parseInt(br.readLine()); // 명령 수
            for(int i = 0; i < C; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                command = new char[n];

                String[] str = st.nextToken().split("");
                for(int j = 0; j < n; j++) {
                    command[j] = str[j].charAt(0);
                }

                int ans = bfs(r, c, 0); // 현재 위치, 방향
                sb.append(ans).append(" ");
            }// 명령 입력 받기

            sb.append("\n");
        }// tc
        System.out.println(sb.toString().trim());
    }

    private static int bfs(int r, int c, int d) {

        for(char m : command) {
            switch(m) {
                case 'R' :
                    d = (dir[d]+1)%4;
                    break;
                case 'L' :
                    d = (d == 0 ? 3 : (dir[d]-1)%4);
                    break;
                case 'A' :
                    int nr = r + go[d][0];
                    int nc = c + go[d][1];

                    // 유효성 체크
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] == 'T') continue;

                    r = nr;
                    c = nc;
            }//swtich
        }

        if(arr[r][c] == 'Y') return 1;

        return 0; // 도착 못 함
    }


}

