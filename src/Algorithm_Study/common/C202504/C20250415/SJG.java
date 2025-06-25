package Algorithm_Study.common.C202504.C20250415;

import java.io.*;
import java.util.*;

class State {
    int r, c, dir, cut, count;

    State(int r, int c, int dir, int cut, int count) {
        this.r = r;
        this.c = c;
        this.dir = dir; // 0:상, 1:우, 2:하, 3:좌
        this.cut = cut; // 베어낸 나무 수
        this.count = count; // 조작 횟수
    }
}

class SJG
{
    static int N, K, startR, startC, endR, endC;
    static char[][] map;
    static int[][][][] visited;
    static final int INF = Integer.MAX_VALUE;
    // 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] inputNK = br.readLine().split(" ");
            N = Integer.parseInt(inputNK[0]);
            K = Integer.parseInt(inputNK[1]);
            
            map = new char[N][N];	// map 초기화
            visited = new int[N][N][4][K + 1];	// 방문배열 초기화
            for(int i = 0; i < N; i++) {
                char[] input = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) {
                    map[i][j] = input[j];
                    // 시작지점 찾기
                    if(map[i][j] == 'X') {
                        startR = i;
                        startC = j;
                        map[i][j] = 'G';	// 출발지를 이동가능한 땅으로 처리
                        // 도착지점 찾기
                    } else if(map[i][j] == 'Y') {
                        endR = i;
                        endC = j;
                    }
                }
            }	// 입력완료
            
            // 방문배열(visited)을 정수의 최대값으로 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int d = 0; d < 4; d++) {
                        Arrays.fill(visited[i][j][d], INF);
                    }
                }
            }
            
            int result = bfs();
            
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
        System.out.print(sb);
        br.close();
	}
    
    private static int bfs() {
        Queue<State> q = new LinkedList<>();
        // 시작 상태 설정 (방향 0 = 위)
        int initialDir = 0;
        if (visited[startR][startC][initialDir][0] > 0) {
            visited[startR][startC][initialDir][0] = 0; // 시작점 조작 횟수 0으로 초기화
            q.offer(new State(startR, startC, initialDir, 0, 0));	// 열, 행, 방향, 베어낸 나무 수, 조작횟수
        }

        while (!q.isEmpty()) {
            State current = q.poll();
            int r = current.r;
            int c = current.c;
            int dir = current.dir;
            int cut = current.cut;
            int count = current.count;

            // 도착 지점 확인
            if (r == endR && c == endC) {
                return count; // 최소 조작 횟수 반환
            }

            // 1. 좌회전
            int nextDirLeft = (dir + 3) % 4;
            int nextCountTurn = count + 1;
            if (visited[r][c][nextDirLeft][cut] > nextCountTurn) {
                visited[r][c][nextDirLeft][cut] = nextCountTurn;
                q.offer(new State(r, c, nextDirLeft, cut, nextCountTurn));
            }

            // 2. 우회전
            int nextDirRight = (dir + 1) % 4;
             if (visited[r][c][nextDirRight][cut] > nextCountTurn) {
                visited[r][c][nextDirRight][cut] = nextCountTurn;
                q.offer(new State(r, c, nextDirRight, cut, nextCountTurn));
            }

            // 3. 전진
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            int nextCountMove = count + 1;

            // 맵 범위 체크
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                // 다음 칸이 땅('G') 또는 도착지('Y')
                if (map[nr][nc] == 'G' || map[nr][nc] == 'Y') {
                    if (visited[nr][nc][dir][cut] > nextCountMove) {
                        visited[nr][nc][dir][cut] = nextCountMove;
                        q.offer(new State(nr, nc, dir, cut, nextCountMove));
                    }
                }
                // 다음 탐색할 인덱스의 값(?)이 T이며, 아직 나무를 벨 수 있는 횟수가 남아 있을 때
                else if (map[nr][nc] == 'T' && cut < K) {
                    int nextCut = cut + 1;
                     if (visited[nr][nc][dir][nextCut] > nextCountMove) {
                        visited[nr][nc][dir][nextCut] = nextCountMove;
                        q.offer(new State(nr, nc, dir, nextCut, nextCountMove));
                    }
                }
            }
        }
        return -1;
    }
}