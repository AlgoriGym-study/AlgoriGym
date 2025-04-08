package Algorithm_Study.common.C20250325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YHS {

    static int N, M, K, Rr, Rc, Nr, Nc, answer;
    static boolean[][][][] count;

    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static int[] Ndr = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int[] Ndc = { 2, 1, -1, -2, -2, -1, 1, 2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 체스판 정보 입력 받으면서 룩과 나이트의 위치 저장
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    int a = Integer.parseInt(st.nextToken());
                    if (a == 1) {
                        Rr = r;
                        Rc = c;
                    } else if (a == 2) {
                        Nr = r;
                        Nc = c;
                    }
                }
            }

            count = new boolean[N][M][N][M];

            answer = 0;

            // 모든 경우의수를 탐색할 재귀함수
            move(0, Rr, Rc, Nr, Nc);

            System.out.printf("#%d %d\n", tc, answer);
        }
    }

    static boolean inBoard(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    // 현재 룩과 나이트가 있는 위치에서 다음 이동할 수 있는 위치 탐색
    // 현재 룩의 위치 : (Rr, Rc)
    // 현재 나이트의 위치 : (Nr, Nc)
    // level : 현재 기물을 움직인 횟수
    static void move(int level, int Rr, int Rc, int Nr, int Nc) {
        // 기저조건
        // 기물을 움직인 횟수가 K번이 되었으면 return
        if (level == K) {
            if (!count[Rr][Rc][Nr][Nc]) {
                answer++;
                count[Rr][Rc][Nr][Nc] = true;
            }
            return;
        }

        // 재귀 조건

        // 룩의 이동
        for (int d = 0; d < 4; d++) {
            int rr = Rr + dr[d];
            int rc = Rc + dc[d];
            // 가보고자 하는 위치가 범위 안에 있어야 하고, 나이트의 위치와 같으면 안된다.
            while (inBoard(rr, rc) && !(rr == Nr && rc == Nc)) {
                move(level + 1, rr, rc, Nr, Nc);
                rr += dr[d];
                rc += dc[d];
            }
        }

        // 나이트의 이동
        for (int d = 0; d < 8; d++) {
            int nr = Nr + Ndr[d];
            int nc = Nc + Ndc[d];
            // 가보고자 하는 위치가 범위 안에 있어야 하고, 룩의 위치와 같으면 안된다.
            if (inBoard(nr, nc) && !(nr == Rr && nc == Rc)) {
                move(level + 1, Rr, Rc, nr, nc);
            }
        }
    }
}