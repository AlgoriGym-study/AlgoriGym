package Algorithm_Study.common.C202507.C20250709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SJG0030_2 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> selected = new ArrayList<>();
    static int minResult = INF;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = br.readLine().split(" ");
        N = Integer.parseInt(inputNM[0]);
        M = Integer.parseInt(inputNM[1]);
        
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                int val = Integer.parseInt(input[j]);
                if (val == 1) {
                    house.add(new int[]{i, j});
                } else if (val == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        
        btk(0, 0);
        System.out.print(minResult);
        br.close();
    }

    private static void btk(int start, int count) {
        if (count == M) {
            minResult = Math.min(minResult, calcCityDistance());
            return;
        }
        
        for (int i = start; i < chicken.size(); i++) {
            selected.add(chicken.get(i));
            btk(i + 1, count + 1);
            selected.remove(selected.size() - 1);
        }
    }
    
    private static int calcCityDistance() {
        int totalDistance = 0;
        
        for (int[] h : house) {
            int hr = h[0], hc = h[1];
            int minDist = INF;
            
            for (int[] c : selected) {
                int cr = c[0], cc = c[1];
                int dist = Math.abs(hr - cr) + Math.abs(hc - cc);
                minDist = Math.min(minDist, dist);
            }
            totalDistance += minDist;
        }
        
        return totalDistance;
    }
}
