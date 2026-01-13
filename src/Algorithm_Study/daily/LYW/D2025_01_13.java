package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2025_01_13 {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for (String rec : records) {
            String[] parts = rec.split(" ");
            int t = toMin(parts[0]);
            String car = parts[1];
            String type = parts[2];
            if (type.equals("IN")) {
                in.put(car, t);
            } else {
                int dur = t - in.get(car);
                total.put(car, total.getOrDefault(car, 0) + dur);
                in.remove(car);
            }
        }
        
        int end = 23 * 60 + 59;
        for (Map.Entry<String, Integer> e : in.entrySet()) {
            String car = e.getKey();
            int dur = end - e.getValue();
            total.put(car, total.getOrDefault(car, 0) + dur);
        }
        
        List<String> cars = new ArrayList<>(total.keySet());
        Collections.sort(cars);
        int[] ans = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int t = total.get(cars.get(i));
            int fee = calcFee(t, baseTime, baseFee, unitTime, unitFee);
            ans[i] = fee;
        }
        return ans;
    }
    
    private int toMin(String hhmm) {
        String[] s = hhmm.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    private int calcFee(int t, int baseTime, int baseFee, int unitTime, int unitFee) {
        if (t <= baseTime) return baseFee;
        int extra = t - baseTime;
        int units = (extra + unitTime - 1) / unitTime;
        return baseFee + units * unitFee;
    }
}
