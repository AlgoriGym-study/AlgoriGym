package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // id_list 기준으로 이름 -> 숫자로 저장 
        Map <String, Integer> idMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            idMap.put(id_list[i],i);
        }
        
        // map1 {신고한 유저 : {신고당한 유저1, 2, 3,..}}, {},..
        Map <String,Set<String>> reportMap = new HashMap<>();
        
        // map2 {신고 당한 유저1 : 횟수} , {유저2 : 횟수}, ..
        Map <String,Integer> reportedMap = new HashMap<>();
        
        for(String r : report){
            String[] str = r.split(" ");
            String reporter = str[0];
            String reported = str[1];
        
        
            if (reportMap.computeIfAbsent(reporter, i -> new HashSet<>()).add(reported)) {
                reportedMap.put(reported, reportedMap.getOrDefault(reported, 0) + 1);
            }   
        }
        
        int [] answer = new int [id_list.length];
        // map1의 value를 key로 map2의 value가 k번 이상일때 answer 배열에서 key번째 요소를 늘리기 
        for(String key : reportMap.keySet()){
            Set<String> reported = reportMap.get(key);
            for(String num : reported){
                if(reportedMap.get(num) >= k) {answer[idMap.get(key)]++; 
                                               // System.out.println(reportedMap.get(num));
                                              }
            }
        }
        return answer;
    }
}
