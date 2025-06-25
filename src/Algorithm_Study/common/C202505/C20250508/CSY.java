package Algorithm_Study.common.C202505.C20250508;
import java.util.*;
public class CSY {
    // import java.util.*;

// class Solution {

//     static int[] dr = {-1, 1, 0, 0};
//     static int[] dc = {0, 0, -1, 1};
//     static Map<Integer, int[]> map = new HashMap<>();
//     static int[][] dist;
//     static Queue<int[]> move;

//     public int solution(int[][] points, int[][] routes) {
//         int answer = 0;
//         for(int i = 1; i <= points.length; i++){
//             map.put(i, points[i-1]); // points
//         }
//         // System.out.println(Arrays.toString(map.get(1)));

//         for(int[] r : routes){
//             int start = r[0];
//             int end = r[1];
//             dist = new int[100][100]; // 거리 배열 초기화
//             move = new LinkedList<>();
//             //Arrays.fill(dist, -1);
//             bfs(map.get(start), map.get(end));
//             //System.out.println(dist[map.get(end)[0]][map.get(end)[1]]);

//             while(!move.isEmpty()){
//                 System.out.println(Arrays.toString(move.poll()));
//             }
//             System.out.println("=====");
//         }

//         // points: 각 포인트의 위치 (각 인덱스가 포인트 번호)
//         // routes: 로봇이 이동할 경로. 1번 인덱스 -> 1번 로봇이 이동할 경로
//         // ex) 4번 포인트에서 2번 포인트로!
//         // 로봇은 1초에 한 칸씩 이동(최단거리로, 우선순위 : r > c)
//         // 충돌 위험(2대 이상 만날 경우) 횟수를 구하자!!

//         // 출발, 도착지 다 있으니까 bfs로 풀기.
//         // 문제는 충돌 위험을 어떻게...구하지?
//         // 경로를 찍어야겠다.

//         return answer;
//     }

//     public static void bfs(int[] start, int[] end){
//         Queue<int[]> queue = new LinkedList<>();
//         dist[start[0]][start[1]] = 1; // 시작 거리는 1
//         queue.add(start);

//         while(!queue.isEmpty()){
//             int[] cur = queue.poll();
//             move.add(cur);

//             if(cur[0] == end[0] && cur[1] == end[1]) break; // 도착하면 끝!

//             for(int d = 0; d < 4; d++){
//                 int nr = cur[0] + dr[d];
//                 int nc = cur[1] + dc[d];

//                 // 유효성 체크
//                 if(nr < 0 || nr >= 100 || nc < 0 || nc >= 100) continue;
//                 // 방문한 곳이면 패스
//                 if(dist[nr][nc] != 0) continue;

//                 dist[nr][nc] = dist[cur[0]][cur[1]] + 1; // 한 칸 전진!!
//                 queue.add(new int[]{nr, nc});
//             }
//         }
//     }
// }



    class Solution {

        // r > c 우선 이동
        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};
        static Map<Integer, int[]> map = new HashMap<>();

        public int solution(int[][] points, int[][] routes) {
            int answer = 0;

            // 1. 포인트 번호 -> 좌표 매핑
            for (int i = 1; i <= points.length; i++) {
                map.put(i, points[i - 1]);
            }

            // 2. 전체 로봇 경로 저장
            List<List<int[]>> allRobotPaths = new ArrayList<>();

            for (int[] route : routes) {
                List<int[]> robotPath = new ArrayList<>();
                for (int i = 0; i < route.length - 1; i++) {
                    int start = route[i];
                    int end = route[i + 1];

                    List<int[]> segment = simulateMove(map.get(start), map.get(end));

                    // 첫번째 구간 제외하고 중복된 출발 지점은 빼기 (연결 부분 겹침 방지)
                    if (!robotPath.isEmpty()) segment.remove(0);

                    robotPath.addAll(segment);
                }
                allRobotPaths.add(robotPath);
            }

            // 3. 시간대별 충돌 체크
            int maxTime = 0;
            for (List<int[]> path : allRobotPaths) {
                maxTime = Math.max(maxTime, path.size());
            }

            for (int t = 0; t < maxTime; t++) {
                Map<String, Integer> countMap = new HashMap<>();
                for (List<int[]> path : allRobotPaths) {
                    if (t < path.size()) {
                        int[] pos = path.get(t);
                        String key = key(pos[0], pos[1]);
                        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                    }
                }
                for (int count : countMap.values()) {
                    if (count >= 2) {
                        answer++;
                    }
                }
            }

            return answer;
        }

        // r > c 우선으로 이동하며 경로를 시뮬레이션하는 함수
        private List<int[]> simulateMove(int[] start, int[] end) {
            List<int[]> path = new ArrayList<>();
            int r = start[0];
            int c = start[1];
            path.add(new int[]{r, c});
            while (r != end[0] || c != end[1]) {
                if (r != end[0]) {
                    r += (end[0] > r ? 1 : -1);
                } else if (c != end[1]) {
                    c += (end[1] > c ? 1 : -1);
                }
                path.add(new int[]{r, c});
            }
            return path;
        }

        // 좌표를 문자열로 바꾸기
        private String key(int r, int c) {
            return r + "," + c;
        }
    }

}
