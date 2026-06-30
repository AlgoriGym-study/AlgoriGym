package Algorithm_Study.daily.LYW;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2026_06_30_3 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int painted = 0; // 현재까지 칠해진 마지막 위치

        for (int i = 0; i < section.length; i++) {
            if (section[i] > painted) {
                answer++;
                painted = section[i] + m - 1;
            }
        }

        return answer;
    }
}