package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250503 {
	public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> str1Map = makeSet(str1);
        Map<String, Integer> str2Map = makeSet(str2);
        
        int union = 0;
        int ununion = 0;
        
        Set<String> keys = new HashSet<>();
        keys.addAll(str1Map.keySet());
        keys.addAll(str2Map.keySet());
        
        for(String key : keys) {
            int a = str1Map.getOrDefault(key, 0);
            int b = str2Map.getOrDefault(key, 0);
            
            union += a > b ? a : b;
            ununion += a > b ? b : a;
        }
        if(union == 0) return 65536;
        return (int) ( (double) ununion / union * 65536 );
    }
    
    private Map<String, Integer> makeSet(String str) {
        Map<String, Integer> dajoongSet = new HashMap<>();
        str = str.toUpperCase();
        
        for(int i = 0; i < str.length()-1; i++) {
            String pair = str.substring(i, i+2);
            if(pair.matches("[A-Z]{2}")) 
                dajoongSet.put(pair, dajoongSet.getOrDefault(pair, 0) + 1);
        }
        return dajoongSet;
    }
}
