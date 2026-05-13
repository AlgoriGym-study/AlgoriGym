package Algorithm_Study.daily.SJG;

public class ctrlZ {
    public int solution(String s) {
        int sum = 0;
        int lastAdded = 0;
        
        String[] tokens = s.split(" ");
        
        for (String token : tokens) {
            if (token.equals("Z")) {
                sum -= lastAdded; 
            } else {
                lastAdded = Integer.parseInt(token);
                sum += lastAdded;
            }
        }
        
        return sum;
    }
}
