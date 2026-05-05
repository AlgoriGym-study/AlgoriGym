package Algorithm_Study.daily.SJG;

import java.util.ArrayList;
import java.util.List;

public class buildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int targetIndex = 0;
        
        for (int i = 1; i <= n; i++) {
            if (targetIndex == target.length) break;

            result.add("Push");

            if (target[targetIndex] == i) targetIndex++;
            else result.add("Pop");
        }
        
        return result;
    }
}
