package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2026_01_09 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            int dx = Math.min(p1, p2) - Math.max(x1, x2);
            int dy = Math.min(q1, q2) - Math.max(y1, y2);

            char res;
            if (dx > 0 && dy > 0) res = 'a';
            else if ((dx == 0 && dy > 0) || (dx > 0 && dy == 0)) res = 'b';
            else if (dx == 0 && dy == 0) res = 'c';
            else res = 'd';

            sb.append(res).append('\n');
        }
        System.out.print(sb.toString());
    }
}
