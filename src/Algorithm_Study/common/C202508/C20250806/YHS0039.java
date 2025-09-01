package Algorithm_Study.common.C202508.C20250806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class YHS0039 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int appleN = Integer.parseInt(br.readLine());

        //시계방향
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] arr = new int[N][N];

        for (int i = 0; i < appleN; i++) {
            String[] s = br.readLine().split(" ");
            arr[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
        }

        int commandN = Integer.parseInt(br.readLine());

        Queue<Move> moves = new LinkedList<>();
        for (int i = 0; i < commandN; i++) {
            String[] s1 = br.readLine().split(" ");
            moves.add(new Move(Integer.parseInt(s1[0]), s1[1]));
        }

        //다음 명령을 위한
        Move poll = moves.poll();
        int ntsec = poll.sec;
        String ntdir = poll.dir;

        //현재정보
        int nowSec = 0;
        int x = 0;
        int y = 0;
        int directionInd = 0;
        String dir;

        //뱀 몸통의 정보
        Queue<int[]> snake = new LinkedList<int[]>();
        snake.add(new int[] {0,0});

        while (true) {
            //1초 흐름
            nowSec++;

            //방향에 따른 증감
            x = x + dx[directionInd];
            y = y + dy[directionInd];

            //벽 부딪힐시 게임 종료
            if (x < 0 || x >= N || y < 0 || y >= N)
                break;
            //자기 몸에 부딪힐시 게임 종료
            if (contains(snake, x, y))
                break;

            //뱀 머리 이동
            snake.add(new int[]{x, y});

            //사과가 있을때
            if (arr[y][x] == 1) {
                arr[y][x] = 0;
            }
            else {
                snake.poll();
            }

            //명령 실행 시간이라면 방향 바꿔주기
            if (nowSec == ntsec) {
                dir = ntdir;
                //방향에 따른 인덱스 증감
                if (dir.equals("D")) {
                    directionInd = (directionInd + 1) % 4;
                } else if (dir.equals("L")) {
                    directionInd = (directionInd + 3) % 4;
                }
                if(!moves.isEmpty()) {
                    poll = moves.poll();
                    ntsec = poll.sec;
                    ntdir = poll.dir;
                }
            }
        }
        System.out.println(nowSec);
    }

    private static boolean contains(Queue<int[]> snake, int x, int y) {
        for (int[] body : snake) {
            if (body[0] == x && body[1] == y) {
                return true;
            }
        }
        return false;
    }

    //명령
    public static class Move {
        int sec;
        String dir;

        public Move(int sec, String dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }
}