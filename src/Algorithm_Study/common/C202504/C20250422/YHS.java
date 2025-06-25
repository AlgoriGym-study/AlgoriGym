package Algorithm_Study.common.C202504.C20250422;

import java.util.*;
import java.io.*;

public class YHS {
    static final int HEIGHT = 12;
    static final int WIDTH = 6;
    static char[][] map;
    static boolean[][] visited;
    static List<Puyo> list;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            String line = br.readLine();
            for (int j = 0; j < WIDTH; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        while (true) {
            boolean isFinished = true;
            visited = new boolean[HEIGHT][WIDTH];
            for (int i = HEIGHT-1; i >= 0; i--) {
                for (int j = 0; j < WIDTH; j++) {
                    char ch = map[i][j];
                    if (ch != '.') {
                        //연쇄가 일어날 수 있는지 확인
                        list = new ArrayList<>();
                        bfs(ch,i,j);
                        //같은 색깔 4개가 모이면 연쇄 발생
                        if (list.size() >= 4) {
                            isFinished = false;
                            //리스트에 있는 뿌요들을 .으로 바꿔줌(터짐)
                            for (Puyo puyo : list) {
                                map[puyo.x][puyo.y] = '.';
                            }
                        }
                    }
                }
            }
            //더이상 연쇄가 일어나지 않으면 종료
            if (isFinished)
                break;
            //뿌요 떨어트리기
            FallPuyos();
            count++;
        }

        System.out.println(count);
    }

    static void bfs(char color, int x, int y) {
        Queue<Puyo> q = new LinkedList<>();
        q.add(new Puyo(x, y));
        visited[x][y] = true;
        list.add(new Puyo(x,y));

        while (!q.isEmpty()) {
            Puyo puyo = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = puyo.x + dr[d];
                int ny = puyo.y + dc[d];

                if (nx < 0 || nx >= HEIGHT || ny < 0 || ny >= WIDTH) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != color) continue;

                visited[nx][ny] = true;
                list.add(new Puyo(nx, ny));
                q.add(new Puyo(nx, ny));
            }
        }
    }

    static void FallPuyos() {
        //열부터 탐색
        for (int i = 0; i < WIDTH; i++) {
            //마지막 행부터 탐색
            for (int j = HEIGHT-1; j >= 0; j--) {
                //빈칸이면 해당 칸 위에 뿌요가 있는지 확인
                if (map[j][i] == '.') {
                    for (int k = j-1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    static class Puyo {
        int x, y;

        public Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
