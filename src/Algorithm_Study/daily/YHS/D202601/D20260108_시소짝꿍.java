package Algorithm_Study.daily.YHS.D202601;

import java.util.*;

public class D20260108_시소짝꿍 {
    public static long solution(int[] weights) {
        long answer = 0;

        Map<Double, Integer> map = new HashMap<>();

        double[] divide = new double[]{1.0, 2.0/3, 1.0/2, 3.0/4};

        Arrays.sort(weights);
        for (int w : weights) {
            for (double d : divide) {
                if (map.containsKey(w * d)) {
                    answer += map.get(w * d);
                }
            }
            map.put((double) w, map.getOrDefault((double) w, 0)+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{100,180,360,100,270};
        long result = solution(weights);
        System.out.println(result);
    }
}
