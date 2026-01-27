package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2026_01_21 {
    static int w, h;

    static int toPerimeterPos(int dir, int dist) {
        if (dir == 1) return dist;                // 북: 왼쪽->오른쪽
        if (dir == 4) return w + dist;            // 동: 위->아래
        if (dir == 2) return w + h + (w - dist);  // 남: 오른쪽->왼쪽
        return 2 * w + h + (h - dist);            // 서: 아래->위
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine().trim());
        int[] shops = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shops[i] = toPerimeterPos(dir, dist);
        }

        st = new StringTokenizer(br.readLine());
        int ddir = Integer.parseInt(st.nextToken());
        int ddist = Integer.parseInt(st.nextToken());
        int dong = toPerimeterPos(ddir, ddist);

        int perimeter = 2 * (w + h);
        int sum = 0;

        for (int s : shops) {
            int diff = Math.abs(dong - s);
            sum += Math.min(diff, perimeter - diff);
        }

        System.out.println(sum);
    }
}
