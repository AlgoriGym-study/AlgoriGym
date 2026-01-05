package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2026_01_05 {
	static int w, h;

	static int toLinear(int dir, int dist) {
		int p = 2 * (w + h);
		if (dir == 1)
			return dist;
		else if (dir == 4)
			return w + dist;
		else if (dir == 2)
			return w + h + (w - dist);
		else
			return w + h + w + (h - dist);
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
			shops[i] = toLinear(dir, dist);
		}
		st = new StringTokenizer(br.readLine());
		int gDir = Integer.parseInt(st.nextToken());
		int gDist = Integer.parseInt(st.nextToken());
		int guard = toLinear(gDir, gDist);

		int per = 2 * (w + h);
		int sum = 0;
		for (int s : shops) {
			int d = Math.abs(guard - s);
			sum += Math.min(d, per - d);
		}
		System.out.println(sum);
	}
}
