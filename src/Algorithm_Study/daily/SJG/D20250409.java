package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250409 {
	static int N, size, r, c;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
        
        ans = 0;
        size = 1 << N;
        recur(r, c, size);
        
        System.out.print(ans);
    }
    
    private static void recur(int r, int c, int size) {
        if(size == 1) return;
        
        int halfSize = size / 2;
        int quadSize = halfSize * halfSize;
        if(r < halfSize && c < halfSize) {    // 1사분면
            recur(r, c, halfSize);
        } else if(r < halfSize && c >= halfSize) {    // 2사분면
            ans += quadSize;
            recur(r, c - halfSize, halfSize);
        } else if(r >= halfSize && c < halfSize) {    // 3사분면
            ans += 2 * quadSize;
            recur(r - halfSize, c, halfSize);
        } else {    // 4사분면
            ans += 3 * quadSize;
            recur(r - halfSize, c - halfSize, halfSize);
        }
    }
}
