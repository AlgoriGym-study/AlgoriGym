package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D20250306 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] room = new int[N][2];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            room[i][0] = Integer.parseInt(input[0]);
            room[i][1] = Integer.parseInt(input[1]);
        }
        
        Arrays.sort(room, (o1, o2) -> {
           if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int cnt = 0;
        int lastEndTime = 0;
        for(int i = 0; i < N; i++) {
            if(room[i][0] >= lastEndTime) {
                lastEndTime = room[i][1];
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
