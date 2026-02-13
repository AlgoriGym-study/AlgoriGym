package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
public class D20260211 {
    public int[] solution(String msg) {
        Map<String,Integer> map = new HashMap<>();
        
        // 알파벳 map에 저장하기
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf((char)('A'+i)),i+1);
        }
        
        List<Integer> list = new ArrayList<>(); // 프린트할 list
        //사전에 등록되어있는지 찾기 
        // msg.substring(i,j)로 키 찾기
        for(int i = 0; i < msg.length();){
           String w = "";
            
            // j 를 하나씩 늘려가면서 사전에 있는지 확인
            for(int j = i+1; j <= msg.length(); j++){
                String cur = msg.substring(i,j);
                if(map.containsKey(cur)){
                    w = cur; // 사전에 있으면 일단 w에 저장
                }else{
                    // 사전에 없는 단어를 만나면 
                    // 새로운 단어 사전에 등록
                    map.put(cur, map.size()+1);
                    // j루프에서 벗어나기
                    break;
                }
            }
           // 다음 인덱스 찾기 전 찾은 단어를 list에 저장 
            list.add(map.get(w));
            // i 인덱스는 w의 길이만큼 점프
            i += w.length();
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
