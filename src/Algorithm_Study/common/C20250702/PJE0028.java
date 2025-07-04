package Algorithm_Study.common.C20250702;

import java.util.*;
//프로그래머스 개인정보 수집 유효기간
class PJE0028 {
    // "2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
    public int[] solution(String today, String[] terms, String[] privacies) { 
        
        // 약관 map으로 저장
        Map<String,Integer> map = new HashMap<>();
        for(String term : terms){ 
            String[] termInfo = term.split(" ");
            String termType = termInfo[0]; // 약관 종류 
            int number = Integer.parseInt(termInfo[1]); // 유효 기간 
            
            map.put(termType,number);
        }
        
        
        List<Integer> result = new ArrayList<>(); // 결과 저장할 배열 
        int todayDays = calculateDays(today); // 오늘날짜를 총 일수로 바꿔서 계산 
        
        // 각 개인정보에 대해 파기 여부 판단
        for(int i = 0; i < privacies.length; i++){
            
            String [] privacyInfo = privacies[i].split(" ");
            String dateInfo = privacyInfo[0]; // 개인정보 수집된 날짜 2021.05.02
            String termType = privacyInfo[1]; // 약관 종류 A
            
            int termMonth = map.get(termType);
            
            
            int privacyDays = calculateDays(dateInfo);
           int expirationDays = privacyDays + termMonth * 28; // 개인정보 수집날짜 일자로 바꿔서 계산
             
            if(expirationDays <= todayDays){ // 오늘이 더 크거나 같으면 파기
                result.add(i+1);
                
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
    
    int calculateDays(String dateInfo){
        String[] date = dateInfo.split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            
        return year*12*28 + month*28 + day;
    }
}
