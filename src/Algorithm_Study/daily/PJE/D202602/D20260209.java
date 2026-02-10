package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
class D20260209 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // participant 를 map 에 정리하기 (동명이인 구분용)
        Map<String, Integer> map = new HashMap<>(); //이름, 사람수 
        for(int i = 0; i < participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        // completion 순회하면서 개수 하나씩 빼기 
        for(String c : completion){
            map.put(c, map.get(c) - 1);
        }
        // -1 이 아닌 participant만 저장 후 return
        for(String key : map.keySet()){
            if(map.get(key) != 0) 
                answer = key;
        }
        return answer;
    }
}
