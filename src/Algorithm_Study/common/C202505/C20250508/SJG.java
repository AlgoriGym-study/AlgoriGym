package Algorithm_Study.common.C202505.C20250508;

import java.util.*;

public class SJG {
	public int solution(int[][] points, int[][] routes) {
        int dangerCount = 0;
        int robotCount = routes.length;
        
        // 각 로봇의 전체 경로를 저장할 리스트
        List<List<int[]>> robotPaths = new ArrayList<>();
    
        // 각 로봇의 경로 생성
        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();
        
            // 각 포인트 간 최단 경로 생성
            for (int i = 1; i < route.length; i++) {
                int[] currentPoint = points[route[i-1] - 1];
                int[] nextPoint = points[route[i] - 1];
            
                // 현재 포인트에서 다음 포인트까지의 경로 생성
                generatePath(path, currentPoint, nextPoint);
            }
        
            robotPaths.add(path);
        }
    
        // 가장 긴 경로 찾기
        int maxPathLength = 0;
        for (List<int[]> path : robotPaths) {
            maxPathLength = Math.max(maxPathLength, path.size());
        }
    
        // 각 시간대별로 로봇의 위치 확인
        for (int time = 0; time < maxPathLength; time++) {
            // 각 위치에 있는 로봇 수 기록
            Map<String, Integer> positionCount = new HashMap<>();
        
            for (int robot = 0; robot < robotCount; robot++) {
                List<int[]> path = robotPaths.get(robot);
            
                // 로봇이 아직 운송 중인 경우
                if (time < path.size()) {
                    int[] position = path.get(time);
                    String posKey = position[0] + "," + position[1];
                
                    positionCount.put(posKey, positionCount.getOrDefault(posKey, 0) + 1);
                }
            }
        
            // 위험 상황 카운트
            for (int count : positionCount.values()) {
                if (count >= 2) {
                    dangerCount++;
                }
            }
        }
    
        return dangerCount;
    }

    // 두 포인트 사이의 최단 경로 생성 (r 좌표 먼저 변경)
    private void generatePath(List<int[]> path, int[] start, int[] end) {
        int r = start[0];
        int c = start[1];
    
        // 시작점이 경로에 없으면 추가
        if (path.isEmpty()) {
            path.add(new int[]{r, c});
        }
    
        // r 좌표 먼저 변경
        while (r != end[0]) {
            r += (r < end[0]) ? 1 : -1;
            path.add(new int[]{r, c});
        }
    
        // c 좌표 변경
        while (c != end[1]) {
            c += (c < end[1]) ? 1 : -1;
            path.add(new int[]{r, c});
        }
    }
}
