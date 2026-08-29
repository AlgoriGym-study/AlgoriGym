package Algorithm_Study.daily.PJE.D202606;
import java.util.*;
public class D20260628 {
    public int[] solution(String msg) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put((char)(65+i)+"",i+1);
        }
        
        //프린트 할 리스트
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < msg.length();){
            String w = "";
            
            for(int j = i+1; j <= msg.length(); j++){
                String cur = msg.substring(i,j);
                if(map.containsKey(cur)){
                    w = cur; // 사전에 있으면 w에 저장
                }else{
                    // 사전에 없으면 등록
                    map.put(cur,map.size()+1);
                    break;
                }
            }
            // 찾은 단어의 번호를 리스트에 저장
            list.add(map.get(w));
            // 단어 길이만큼 인덱스 점프
            i+=w.length();
            
        }
        System.out.print(list.size());
        int [] answer = new int [list.size()];
        int idx = 0;
        for(int l:list){
            answer[idx++] = l;
        }
        return answer;
    }
}
