package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250501 {
	public int solution(int left, int right) {
        int total = 0;
        
        for (int num = left; num <= right; num++) {
            if (Math.sqrt(num) == (int)Math.sqrt(num)) {
                total -= num;
            } else {
                total += num;
            }
        }
        
        return total;
    }
}
