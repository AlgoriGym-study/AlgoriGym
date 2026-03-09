package Algorithm_Study.daily.PJE.D202603;
import java.util.*;
public class D20260309 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int [score.length];
        // 명예의 전당 리스트
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++){
            list.add(score[i]); // 일단 넣기 
            Collections.sort(list,Collections.reverseOrder()); // 내림차순으로 리스트 정렬
            if(list.size() > k) // 만약 크기가 더 커지면 
                list.remove(k); // 가장 작은 요소 제거하기 
            
            answer[i] = list.get(list.size()-1); // 가장 작은 요소를 기록
        }
        
        
        return answer;
    }
}
