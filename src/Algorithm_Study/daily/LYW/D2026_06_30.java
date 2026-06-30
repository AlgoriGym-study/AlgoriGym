package Algorithm_Study.daily.LYW;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2026_06_30 {

	public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        // 이름과 점수를 map에 저장
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        // 사진마다 점수 계산
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                String person = photo[i][j];
                
                if (map.containsKey(person)) {
                    sum += map.get(person);
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}