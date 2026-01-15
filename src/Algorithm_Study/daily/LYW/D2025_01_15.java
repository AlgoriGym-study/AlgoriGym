package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2025_01_15 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine().trim());
        int[] dir = new int[6];
        int[] len = new int[6];

        int maxEW = 0, idxEW = -1;
        int maxNS = 0, idxNS = -1;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            if (dir[i] == 1 || dir[i] == 2) {
                if (len[i] > maxEW) {
                    maxEW = len[i];
                    idxEW = i;
                }
            } else {
                if (len[i] > maxNS) {
                    maxNS = len[i];
                    idxNS = i;
                }
            }
        }

        int big = maxEW * maxNS;
        int small = len[(idxEW + 3) % 6] * len[(idxNS + 3) % 6];
        int area = big - small;
        System.out.println(area * K);
    }
}
