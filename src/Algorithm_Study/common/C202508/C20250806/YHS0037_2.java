package Algorithm_Study.common.C202508.C20250806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class YHS0037_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        /*집중국의 수가 센서의 수 이상이라면 각 센서 하나당 집중국 하나가
         *설치될 수 있으므로, 최소 거리의 합은 0
         */
        if (K >= N) {
            System.out.println(0);
            return;
        }

        int[] sensors = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        Integer[] diff = new Integer[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(diff);

        int ans = 0;
        for (int i = 0; i < N - K; i++) {
            ans += diff[i];
        }

        System.out.println(ans);
    }
}
