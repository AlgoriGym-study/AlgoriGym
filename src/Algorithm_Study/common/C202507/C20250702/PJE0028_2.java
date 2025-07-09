package Algorithm_Study.common.C202507.C20250702;
import java.util.*;

//프로그래머스 개인정보 수집 유효기간
class PJE0028_2 {
    // "2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
      
        // terms map에 저장 
        for(String term : terms){
            String[] termInfo = term.split(" ");
            String termType = termInfo[0];
            int termMonth = Integer.parseInt(termInfo[1]);
            map.put(termType, termMonth);
        }
      
        // 프라이버시에 terms 적용한 날짜 구하기
        for(int i = 0; i < privacies.length; i++){
            
            String[] privacyInfo = privacies[i].split(" ");
            String date = privacyInfo[0]; //2021.05.02
            String type = privacyInfo[1]; //A
            int addMon = map.get(type);// 약관 개월수

            int totalDays = getDays(date)+ addMon*28; // 약관 적용된 개인정보 날짜
             // 오늘날짜와 비교하여 파기할 개인정보 찾기
            int todayDays = getDays(today);
            if(totalDays <= todayDays){
                res.add(i+1);
            }
        }
      
        // 정답 반환
       int [] answer = new int[res.size()];
        for(int i = 0; i<res.size(); i++){
            answer[i] = res.get(i);
        }
        
        return answer;
    }
    
    int getDays(String date){
            String [] rawdate = date.split("\\.");
            int year = Integer.parseInt(rawdate[0]);
            int mon = Integer.parseInt(rawdate[1]);
            int day = Integer.parseInt(rawdate[2]);
            int totalDays = year*12*28 + mon*28 + day; // 전체 날짜 수 구하기
            return totalDays;
    }
}
