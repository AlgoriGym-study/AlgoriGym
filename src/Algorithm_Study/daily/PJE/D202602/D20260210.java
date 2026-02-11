package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 친구 인덱스 Map
        Map<String,Integer> idxMap = new HashMap<>();
        for(int i = 0; i < friends.length; i++){
            idxMap.put(friends[i],i);
        }
        
        // 주고받은 선물
        int [][] giftArr = new int [friends.length][friends.length];
        for(String gift : gifts){
            String[] str = gift.split(" ");
            String giver = str[0];
            String reciever = str[1];
            
            giftArr[idxMap.get(giver)][idxMap.get(reciever)]++;
        }

        // 선물 지수 
        int [] giftScore = new int [friends.length];
        for(int i = 0; i < friends.length; i++){
            int gave = 0; // 준선물
            int recieved = 0; // 받은 선물 
            for(int j = 0; j < friends.length; j++){
                gave += giftArr[i][j];
                recieved += giftArr[j][i];
            }
            giftScore[i] = gave - recieved;
        }
        
        // 최종 계산 
        int [] tmp = new int[friends.length];
        for(int i = 0; i < friends.length; i++){
            for(int j = i+1; j < friends.length; j++){
                if(giftArr[i][j] > giftArr[j][i]){ // i 가 j 에게 더 많이 선물 줬으면 
                    tmp[i]++;
                
                }else{
                    if(giftScore[i] > giftScore[j]){
                        tmp[i]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i : tmp){
            answer = Math.max(answer,i);
        }
        
        return answer;
    }
}
