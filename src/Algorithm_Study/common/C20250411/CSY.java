package Algorithm_Study.common.C20250411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CSY {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static List<int[]> list;

    static int[] dr = {-1, 1, 0};
    static int[] dc = {0, 0, 1};
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            list = new ArrayList<>(); // 행렬 추가할 코드

            StringTokenizer st;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }// input

//          int count = 0; // 전체 행렬 수
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] != 0) {
                        bfs(i, j); // 행렬 크기 찾는(?) 함수
//                      count++;
                        countVisited(i, j);
                    }
                }
            }

            Collections.sort(list, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] * o1[1] == o2[0]*o2[1]) {
                        return Integer.compare(o1[0], o2[0]);
                    }
                    return Integer.compare(o1[0] * o1[1], o2[0]*o2[1]);
                }

            }); // 행렬의 크기대로 정렬

            sb.append("#").append(tc).append(" ").append(list.size()).append(" ");
            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)[0]).append(" ").append(list.get(i)[1]).append(" ");
            }
            sb.append("\n");

        }//tc
        System.out.println(sb.toString());
    }

    static void countVisited(int r, int c) {
        int row = 0, col = 0;
        for(int i = c; i < N; i++) {
            if(visited[r][i]) col++;
            if(!visited[r][i]) break;
        }
        for(int i = r; i < N; i++) {
            if(visited[i][c]) row++;
            if(!visited[i][c]) break;

        }
//       System.out.println(row);
//       System.out.println(col);

        list.add(new int[] {row, col});

    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true; // 방문 체크
        arr[r][c] = 0;

        q.add(new int[] {r, c});
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int d = 0; d < 3; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(arr[nr][nc] != 0) {
                    arr[nr][nc] = 0;
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }

        }// while

    }

}
