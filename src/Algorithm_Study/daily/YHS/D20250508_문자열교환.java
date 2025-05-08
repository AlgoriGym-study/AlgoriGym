package Algorithm_Study.daily.YHS;

import java.io.*;

public class D20250508_문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 전체 a의 개수 계산
        int totalA = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a')
                totalA++;
        }

        // 슬라이딩 윈도우로 최소 교환 횟수 계산
        int minSwap = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int bCount = 0;
            // 현재 위치에서 totalA 길이만큼의 구간에서 b의 개수를 계산
            for (int j = 0; j < totalA; j++) {
                int idx = (i + j) % str.length();
                if (str.charAt(idx) == 'b')
                    bCount++;
            }
            minSwap = Math.min(minSwap, bCount);
        }

        System.out.println(minSwap);
    }
}
