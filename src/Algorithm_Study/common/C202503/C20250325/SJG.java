package Algorithm_Study.common.C202503.C20250325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class SJG {
	static int N, M, K;
    static int[][] board;
    static int rookRow, rookCol, knightRow, knightCol;
    static HashSet<String> finalSpot; // 최종 위치 저장 (중복 제거)

    static int[] drRook = {-1, 1, 0, 0}; // 룩 이동 (상, 하, 좌, 우)
    static int[] dcRook = {0, 0, -1, 1};

    static int[] drKnight = {-2, -2, -1, -1, 1, 1, 2, 2}; // 나이트 이동 (8방향)
    static int[] dcKnight = {-1, 1, -2, 2, -2, 2, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] inputNMK = br.readLine().split(" ");
            N = Integer.parseInt(inputNMK[0]);
            M = Integer.parseInt(inputNMK[1]);
            K = Integer.parseInt(inputNMK[2]);

            board = new int[N][M];
            finalSpot = new HashSet<>(); // 각 테스트 케이스마다 초기화

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(input[j]);
                    if (board[i][j] == 1) {
                        rookRow = i;
                        rookCol = j;
                    } else if (board[i][j] == 2) {
                        knightRow = i;
                        knightCol = j;
                    }
                }
            }

            dfs(0, rookRow, rookCol, knightRow, knightCol);
            System.out.println("#" + t + " " + finalSpot.size());
        }
        br.close();
    }

    static void dfs(int depth, int rRow, int rCol, int kRow, int kCol) {
        if (depth == K) {
            finalSpot.add(rRow + " " + rCol + " " + kRow + " " + kCol);
            return;
        }

        // 룩 이동
        for (int dir = 0; dir < 4; dir++) {
            for (int dist = 1; dist < Math.max(N, M); dist++) {
                int nrRow = rRow + drRook[dir] * dist;
                int nrCol = rCol + dcRook[dir] * dist;

                if (nrRow < 0 || nrRow >= N || nrCol < 0 || nrCol >= M) {
                    break; // 체스판 벗어남
                }
                if (nrRow == kRow && nrCol == kCol) {
                    break; // 나이트와 같은 위치
                }

                // 가는 길에 나이트가 있는지 확인
                boolean canMove = true;
                for(int i=1; i<dist; ++i){ // dist가 1부터 시작이므로 이미 그 위치에 있는지 확인은 위에서 함.
                    int checkRow = rRow + drRook[dir] * i;
                    int checkCol = rCol + dcRook[dir] * i;
                    if(checkRow == kRow && checkCol == kCol){
                        canMove = false;
                        break;
                    }
                }
                if(canMove){
                    dfs(depth + 1, nrRow, nrCol, kRow, kCol);
                }else{
                    break;
                }
            }
        }

        // 나이트 이동
        for (int i = 0; i < 8; i++) {
            int nkRow = kRow + drKnight[i];
            int nkCol = kCol + dcKnight[i];

            if (nkRow >= 0 && nkRow < N && nkCol >= 0 && nkCol < M && !(nkRow == rRow && nkCol == rCol)) {
                dfs(depth + 1, rRow, rCol, nkRow, nkCol);
            }
        }
    }
}
