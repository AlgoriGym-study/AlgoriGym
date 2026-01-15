package Algorithm_Study.daily.PJE.D202601;
import java.util.*;

public class D20260115 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // report를 set에 넣어서 중복 제거하기 
        Set<String> reportSet = new HashSet<>();
        for(int i = 0; i< report.length; i++){
            reportSet.add(report[i]);
        }
        
        // 신고인 : [피신고인] 으로 reportMap에 저장하기
        Map<String, List<String>> reportMap = new HashMap<>();
        
        // 신고당한 횟수도 같이 저장하기 
        Map<String, Integer> accusedMap = new HashMap<>();
        
        for(String s : reportSet){
            String reporter = s.split(" ")[0]; // 신고자 
            String reported = s.split(" ")[1]; // 신고당한자 
            
            accusedMap.put(reported,accusedMap.getOrDefault(reported,0)+1); // 신고당한 횟수 카운트하기    
            // 신고자를 조회해서 없으면 새로운 배열을 만들어주고 있으면 기존 리스트에 피신고인 추가하기 
            List<String> list = reportMap.get(reporter);
            if ( list == null ){
                list = new ArrayList<>();
                reportMap.put(reporter,list);
            }
            list.add(reported);   
            
        }
                
        // k횟수가 넘은 사람들 추출하면서 피신고인으로 몇 번 등장하는지 세기
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i]; // 현재 확인하는 유저
            
            // 이 유저가 신고한 목록이 있다면
            if (reportMap.containsKey(user)) {
                for (String target : reportMap.get(user)) {
                    // 내가 신고한 사람(target)의 누적 신고 횟수가 k 이상인지 확인
                    if (accusedMap.get(target) >= k) {
                        answer[i]++;
                    }
                }
            }
        }
         return answer;
    }
}
