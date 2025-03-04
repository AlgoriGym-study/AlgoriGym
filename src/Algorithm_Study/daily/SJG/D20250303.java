package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250303 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        
        int minBags = -1;

        for (int i = 0; i * 5 <= N; i++) {
            int remaining = N - (i * 5);
            if (remaining % 3 == 0) {
                int three = remaining / 3;
                int totalBags = i + three;
                if (minBags == -1 || totalBags < minBags) {
                    minBags = totalBags;
                }
            }
        }

        System.out.println(minBags);
    }
}
