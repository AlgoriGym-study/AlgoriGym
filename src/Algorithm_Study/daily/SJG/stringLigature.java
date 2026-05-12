package Algorithm_Study.daily.SJG;

public class stringLigature {
    public int solution(String[] strArr) {

        int[] count = new int[31];
        
        for (String str : strArr) {
            count[str.length()]++;
        }
        
        int max = 0;
        for (int c : count) {
            if (c > max) max = c;
        }
        
        return max;
    }
}
