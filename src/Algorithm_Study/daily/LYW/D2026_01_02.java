package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2026_01_02 {

    static class Pillar {
        int l, h;
        Pillar(int l, int h) { this.l = l; this.h = h; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Pillar[] arr = new Pillar[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[i] = new Pillar(L, H);
        }

        Arrays.sort(arr, new Comparator<Pillar>() {
            @Override
            public int compare(Pillar a, Pillar b) { return a.l - b.l; }
        });

        int maxH = 0;
        for (int i = 0; i < N; i++) if (arr[i].h > maxH) maxH = arr[i].h;

        int firstMaxIdx = -1, lastMaxIdx = -1;
        for (int i = 0; i < N; i++) { if (arr[i].h == maxH) { firstMaxIdx = i; break; } }
        for (int i = N - 1; i >= 0; i--) { if (arr[i].h == maxH) { lastMaxIdx = i; break; } }

        int area = 0;

        Pillar cur = arr[0];
        for (int i = 1; i <= firstMaxIdx; i++) {
            if (arr[i].h >= cur.h) {
                area += (arr[i].l - cur.l) * cur.h;
                cur = arr[i];
            }
        }

        cur = arr[N - 1];
        for (int i = N - 2; i >= lastMaxIdx; i--) {
            if (arr[i].h >= cur.h) {
                area += (cur.l - arr[i].l) * cur.h;
                cur = arr[i];
            }
        }

        area += maxH * (arr[lastMaxIdx].l - arr[firstMaxIdx].l + 1);

        System.out.println(area);
    }
}
