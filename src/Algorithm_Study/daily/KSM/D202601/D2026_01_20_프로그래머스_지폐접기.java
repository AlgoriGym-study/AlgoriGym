package D202601;

import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int ws = Math.min(wallet[0], wallet[1]);
        int wl = Math.max(wallet[0], wallet[1]);
        while (true) {
            int bs = Math.min(bill[0], bill[1]);
            int bl = Math.max(bill[0], bill[1]);
            if (bs <= ws && bl <= wl) break;
            if (bl == bill[0]) bill[0] /= 2;
            else bill[1] /= 2;
            answer++;
        }
        return answer;
    }
}
