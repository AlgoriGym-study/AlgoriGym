package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250511_2 {
	public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        int total = 0;
        int type = 0;
        
        for (int count : counts) {
            total += count;
            type++;
            
            if (total >= k) {
                break;
            }
        }
        return type;
    }
}
