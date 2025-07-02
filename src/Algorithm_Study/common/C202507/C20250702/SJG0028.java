package Algorithm_Study.common.C202507.C20250702;

import java.util.HashMap;
import java.util.Map;

public class SJG0028 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayInfo = calcDay(today); // 오늘 날짜를 일수로 변환
        
        Map<String, Integer> map = new HashMap<>(); // 약관 종류와 유효기간을 저장할 맵
        for(String term : terms) {
            String[] termInfo = term.split(" ");
            map.put(termInfo[0], Integer.parseInt(termInfo[1])*28);  // 약관 종류: 유효기간
        }
        
        int idx = 1;    // 인덱스는 1부터 시작 (0은 사용하지 않음)
        int[] counts = new int[privacies.length + 1];   // 결과를 저장할 배열 (0번째 인덱스는 사용하지 않음)
        // 각 개인정보의 날짜를 계산하고 유효기간을 비교
        for(String privacy : privacies) {
            String[] privacyInfo = privacy.split(" ");  // 개인정보 수집 날짜와 약관 종류를 공백을 기준으로 분리
            int dayInfo = calcDay(privacyInfo[0]);  // 개인정보 수집 날짜를 일수로 변환
            
            // 오늘 날짜와 개인정보 수집 날짜의 차이를 계산하고, 유효기간과 비교
            if(todayInfo - dayInfo >= map.get(privacyInfo[1])) counts[idx] = 1;
            idx++;
        }
        
        int count = 0;  // 유효기간이 지난 결과를 배열로 return해야 하므로 갯수를 세는 변수 count 선언
        for(int i = 1; i < counts.length; i++) if(counts[i] == 1) count++;  // 유효기간이 지난 개인정보의 개수를 세기
        int[] answer = new int[count];  // 유효기간이 지난 개인정보의 개수만큼 크기의 배열 생성
        idx = 0;    // answer 배열에 유효기간이 지난 개인정보의 인덱스를 저장하기 위한 인덱스 변수초기화
        for(int i = 1; i < counts.length; i++) if(counts[i] == 1) answer[idx++] = i;    // 유효기간이 지난 개인정보의 인덱스를 answer 배열에 저장
        
        return answer;
    }
    
    // 날짜를 "YYYY.MM.DD" 형식의 문자열로 받아서 일수로 변환하는 메소드
    private int calcDay(String date) {
        String[] dateInfo = date.split("\\.");  // 날짜를 "."을 기준으로 분리
            
        int year = Integer.parseInt(dateInfo[0]);   // 연도
        int month = Integer.parseInt(dateInfo[1]);   // 월
        int day = Integer.parseInt(dateInfo[2]);     // 일

        // 연도, 월, 일을 일수로 변환하여 반환(한달은 28일로 고정)
        return year * 12 * 28
            + (month - 1) * 28
            + day;
    }
}
