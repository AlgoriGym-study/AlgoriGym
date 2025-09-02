package Algorithm_Study.common.C202509.C20250903;

import java.io.*;
import java.util.*;

// 백준 16236 아기 상어
public class KMR0040 {
    static int N;
    static int[][] map;
    static int shark;
    static Map<Integer, List<int[]>> fish;

    static int[] dr = {-1, 0, 0, 1};  // 위, 좌, 우, 아래
    static int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int sr = 0, sc = 0;
        shark = 2;

        map = new int[N][N];
        fish = new HashMap<>();
        for (int i = 1; i <= 6; i++) fish.put(i, new ArrayList<>());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sr = i; sc = j;
                    map[i][j] = 0; // 시작지점 비우기
                } else if (map[i][j] != 0) {
                    int v = map[i][j];
                    if (1 <= v && v <= 6) fish.get(v).add(new int[]{i, j});
                }
            }
        }

        int time = 0;
        int exp = 0;

        while (hasEdibleFish()) {
            // 가장 가까운 먹을 수 있는 물고기 찾기 (거리, 행, 열 우선)
            int minDistance = Integer.MAX_VALUE;
            int minR = -1;
            int minC = -1;
            int minSize = -1;

            // 먹을 수 있는 크기만 탐색: 1..min(6, shark-1)
            int upper = Math.min(6, shark - 1);
            boolean foundAny = false;

            for (int size = 1; size <= upper; size++) {
                List<int[]> list = fish.get(size);
                if (list == null || list.isEmpty()) continue;

                for (int[] pos : list) {
                    int fr = pos[0];
                    int fc = pos[1];
                    int dist = bfs(sr, sc, fr, fc); // 이동 가능 & 거리
                    if (dist == -1) continue;

                    if (dist < minDistance ||
                            (dist == minDistance && (fr < minR || (fr == minR && fc < minC)))) {
                        minDistance = dist;
                        minR = fr;
                        minC = fc;
                        minSize = size;
                        foundAny = true;
                    }
                }
            }

            if (!foundAny) break; // 더는 갈 수 있는 먹이 없음

            // 먹기
            time += minDistance;
            exp++;

            map[minR][minC] = 0;

            // fish 목록에서도 제거(좌표값 비교로 제거)
            List<int[]> targetList = fish.get(minSize);
            if (targetList != null) {
                int finalMinR = minR;
                int finalMinC = minC;
                targetList.removeIf(p -> p[0] == finalMinR && p[1] == finalMinC);
            }

            // 레벨업
            if (exp == shark) {
                shark++;
                exp = 0;
            }

            // 상어 위치 갱신
            sr = minR; sc = minC;
        }

        System.out.println(time);
    }

    // 균일 가중치이므로 BFS로 최단거리
    static int bfs(int sr, int sc, int tr, int tc) {
        if (sr == tr && sc == tc) return 0;

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                // 상어보다 큰 물고기가 있는 칸은 지나갈 수 없음
                if (map[nr][nc] > shark) continue;

                if (dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    if (nr == tr && nc == tc) return dist[nr][nc];
                    deque.offer(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }

    // 먹을 수 있는 물고기가 남아있는지 확인
    static boolean hasEdibleFish() {
        int upper = Math.min(6, shark - 1);
        if (upper < 1) return false;
        for (int size = 1; size <= upper; size++) {
            List<int[]> list = fish.get(size);
            if (list != null && !list.isEmpty()) return true;
        }
        return false;
    }
}
