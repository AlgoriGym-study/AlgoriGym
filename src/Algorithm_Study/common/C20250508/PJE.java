package Algorithm_Study.common.C20250508;
import java.util.*;

class PJE{
    public int solution(int[][] points, int[][] routes){
     //실제 좌표로 저장
    Map<Integer, int[]>pointMap = new HashMap<>();
    for(int i = 0; i < points.length; i++){
        pointMap.put(i+1, points[i]);
    }
    // 시간 , 위치,해당 위치에 몇 대의 로봇이 있었는지
    Map<Integer,Map<String,Integer>> timeline = new HashMap<>();
        
    for(int[] route : routes){
        int time = 0;
        int [] current = pointMap.get(route[0]); // 출발 지점 좌표
        
        // 다음 포인트로 이동 
        for(int i = 1; i < route.length; i++){
            int[] target = pointMap.get(route[i]); //다음 목적지 좌표
            
            //r 좌표 먼저 이동 
            while(current[0] != target[0]){
                markPosition(timeline,time,current); //현재 위치 기록
                current = new int [] {
                    current[0] + (target[0] > current[0]?1:-1),
                    current[1]
                };
                time++;
            }
            
            // c 좌표 이동
            while(current[1]!=target[1]){
                markPosition(timeline,time,current); // 현재위치 기록
                current = new int[] {
                    current[0],
                    current[1]+ (target[1] > current[1] ? 1:-1)
                };
                time++;
            }
        }
        //마지막 위치 기록 
        markPosition(timeline,time,current);
    }
        //위험 상황 (동일 좌표에 2대 이상 존재) 세기
        int danger = 0;
        for(Map<String,Integer> map : timeline.values()){
            for(int count : map.values()){
                if(count>=2) danger++;
            }
        }
        return danger;
    }   
    
    // 시간대별 위치 기록 함수
    private void markPosition(Map<Integer, Map<String,Integer>> timeline, int time, int[] position){
        timeline.putIfAbsent(time,new HashMap<>());
        String key = position[0] + ","+position[1]; //좌표를 문자열로 표현
        Map<String,Integer> map = timeline.get(time);
        map.put(key,map.getOrDefault(key,0)+1); // 해당 좌표에 로봇 수 증가 
    }
    
    
    
}