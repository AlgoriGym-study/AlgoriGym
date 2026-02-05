package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
public class D20260205 {
    public int solution(String[] friends, String[] gifts) {
        // 친구 idx 맵 만들기
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < friends.length; i++) map.put(friends[i],i);
        
        // 주고받은 기록 record 및 선물지수 giftScore 만들기
        int [][] record = new int [friends.length][friends.length];
        int [] giftScore = new int [friends.length];
        for(String gift : gifts){
            int giverIdx = map.get(gift.split(" ")[0]);
            int recieverIdx = map.get(gift.split(" ")[1]);
            record[giverIdx][recieverIdx]++;
            giftScore[giverIdx]++;
            giftScore[recieverIdx]--;
        }
        
        // 다음달 선물 계산 
        int[] nextMonthGifts = new int[friends.length];
        for(int i = 0; i < friends.length; i++){
            for(int j = i+1; j < friends.length; j++){
                int iGivej = record[i][j];
                int jGivei = record[j][i];
                
                if(iGivej > jGivei){
                    nextMonthGifts[i]++;
                }else if(iGivej < jGivei){
                     nextMonthGifts[j]++;
                }else {
                    if(giftScore[i] > giftScore[j]){
                        nextMonthGifts[i]++;
                    }else if(giftScore[i] < giftScore[j]){
                        nextMonthGifts[j]++;
                    }
                }
            }
        }
        int answer = 0;
        for(int nextMonthGift : nextMonthGifts){
            answer = Integer.max(answer, nextMonthGift);
        }
        
        return answer;
    }
}
