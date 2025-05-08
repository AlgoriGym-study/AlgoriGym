package Algorithm_Study.daily.PJE;

import java.util.*;
// 프로그래머스 개인정보 수집 유효기간 
public class D20250508 {
	public static void main(String[] args) {
		Solution10 s = new Solution10();
		String today = "2022.05.19";
		String [] terms = {"A 6", "B 12", "C 3"};
		String [] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		int [] answer = s.solution(today, terms, privacies);
		System.out.println(Arrays.toString(answer));
	}
}

class Solution10 {
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 2022.05.19 , ["A 6", "B 12"], ["2021.05.02 A", "2022.07.04 A"] 
        // terms => Map으로 저장
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String term = terms[i].split(" ")[0];
            int month = Integer.parseInt(terms[i].split(" ")[1]);
            map.put(term,month);
        }
        
        List<Integer> list = new ArrayList<>(); // 파기할 개인정보
        
        // privacies에서 term 적용
        for(int i = 0; i < privacies.length; i++){
            String date = privacies[i].split(" ")[0];
            String term = privacies[i].split(" ")[1];
            int termMonth = map.get(term); // 적용해야 하는 개월 수
            // 날짜 계산 
            // date를 split 해서 1번째 방을 month 더해서 12 넘어가면 0번째 방을 +1 , 1번째 방을 -12 12 안넘으면 그냥 더해주기 
            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);
            // 계산 하면서 오늘 날짜와 비교
            String [] todayArr = today.split("\\.");
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < todayArr.length; j++){
                sb.append(todayArr[j]);
            }
            if (isExpired(year,month, termMonth,day, today)){
                list.add(i+1);
            }
            
        }
        int [] answer = new int [list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    // 약관 적용해서 날짜 계산하기
    boolean isExpired(int year, int month, int termMonth, int day, String today){
        int totalMonths = year*12 + (month + termMonth);
        int newYear = totalMonths/12;
        int newMonth = totalMonths%12;
        if(newMonth == 0) {
        	newYear--;
        	newMonth = 12;
        }
        int newDay = day-1;
        if(newDay == 0){
        	newMonth--;
        	if(newMonth == 0) {
        		newMonth =12;
        		newYear--;
        	}
        	newDay = 28;
        }
        int todayInt = Integer.parseInt(today.replace(".",""));
        String expiredDate = String.format("%04d%02d%02d", newYear,newMonth,newDay);
        int expiredInt = Integer.parseInt(expiredDate);
        return expiredInt < todayInt;
        		
    }
}
