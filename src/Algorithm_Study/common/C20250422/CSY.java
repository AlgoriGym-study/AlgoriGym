package Algorithm_Study.common.C20250422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CSY {

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static char[][] board;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[12][6];
        visited = new boolean[12][6];

        int x = 0, y = 0;
        for (int i = 0; i < 12; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                board[i][j] = str[j].charAt(0);
                if (board[i][j] != '.') {
                    x = i;
                    y = j;
                }
            }
        }
//		bfs(x, y);
        ans = 0;
        while (true) {
            int change = 0;
            for (int i = 0; i < 12; i++) { // 완전 탐색
                for (int j = 0; j < 6; j++) {
                    // 방문한 적없는 색깔이면 해당 좌표로 bfs
                    if (!visited[i][j] && board[i][j] != '.') {
                        change += bfs(i, j);
                    }
                }
            }//for i

            if (change == 0) // 더이상 터질 게 없으면 브레이크
                break;
            else {
                ans++; // 터질 때마다 ans++
                visited = new boolean[12][6]; // drop에서 사용하기 위해 다시 초기화
            }

            for (int i = 0; i < 6; i++) {
                while(!drop(i)); // x좌표 한 줄씩 보는 함수(중력이니까 세로줄만 보면 됨)
            }

        } // while
        System.out.println(ans);
    }

    private static boolean drop(int x) {
        int start = -1, yo = -1;
        for(int i = 11; i >= 0; i--){
            if(board[i][x] == '.') { // 한 x좌표에서 y좌표(행) 체크
                start = i; // 문자가 아니면 시작 좌표(여기로 끌어당겨야 함. 위에 문자가 있다면)
                for(int k = start; k >= 0; k--) {// 시작 좌표부터 마지막 행까지 탐색
                    if(board[k][x] != '.') {// 문자를 발견!!
                        yo = k;// yo에 해당 좌표 삽입
                        break;
                    }
                }
                break;
            }
        }
        if(yo == -1 || start == -1) return true; // 만약 yo나 start가 -1이면 더 잡아당길 문자가 없다는 뜻.


        while(board[yo][x] != '.') { // yo가 계속 연속적으로 문자인 경우 아래로 당김.
            board[start][x] = board[yo][x]; // 스타트에 요 넣어주고
            board[yo][x] = '.'; // 요도 바꿔주기
            start--; // 위로 한칸씩
            yo--; // 올라가기

            if(yo < 0) // 더 이상 올라갈 수 없음.
                return true;
        }// 끊기는 이유는 문자가 듬성듬성 있을 수도 있음. yy..yy 이런식으로
        return false;
    }

    static int bfs(int x, int y) {
        visited[x][y] = true; // 방문 체크
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });// 큐에 추가
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {x, y});
        int cnt = 0;
        char c = board[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || visited[nr][nc])
                    continue;

                if (board[nr][nc] == c) {
                    cnt++;
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                    list.add(new int[] {nr, nc});
                }
            } // d

        } // q

        if(list.size() >= 4) {
            for(int[] p : list) {
                board[p[0]][p[1]] = '.'; // bomb~
            }
            return 1;
        }

        return 0;
    }

}
