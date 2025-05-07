package Algorithm_Study.common.C20250508;

import java.util.*;

public class LYW {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        // 포인트 번호 매핑 (1-based)
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i <= points.length; i++) {
            map.put(i, points[i - 1]);
        }

        // 로봇별 전체 경로 저장
        List<List<String>> allRobotPaths = new ArrayList<>();
        for (int[] route : routes) {
            List<String> robotPath = new ArrayList<>();
            for (int i = 0; i < route.length - 1; i++) {
                int[] start = map.get(route[i]);
                int[] end = map.get(route[i + 1]);

                List<String> segment = simulateMove(start, end);

                // 연결점 중복 제거
                if (!robotPath.isEmpty()) segment.remove(0);

                robotPath.addAll(segment);
            }
            allRobotPaths.add(robotPath);
        }

        // 시간대별 충돌 확인
        int maxTime = 0;
        for (List<String> path : allRobotPaths) {
            maxTime = Math.max(maxTime, path.size());
        }

        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> positionMap = new HashMap<>();
            for (List<String> path : allRobotPaths) {
                if (t < path.size()) {
                    String pos = path.get(t);
                    positionMap.put(pos, positionMap.getOrDefault(pos, 0) + 1);
                }
            }
            for (int count : positionMap.values()) {
                if (count >= 2) answer++;
            }
        }

        return answer;
    }

    // 시뮬레이션 이동 경로 계산
    private List<String> simulateMove(int[] start, int[] end) {
        List<String> path = new ArrayList<>();
        int r = start[0];
        int c = start[1];
        path.add(r + "," + c);

        while (r != end[0] || c != end[1]) {
            if (r != end[0]) {
                r += (end[0] > r ? 1 : -1);
            } else if (c != end[1]) {
                c += (end[1] > c ? 1 : -1);
            }
            path.add(r + "," + c);
        }
        return path;
    }
}
