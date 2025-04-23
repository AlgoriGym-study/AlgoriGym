package Algorithm_Study.daily.LYW;

import java.util.Arrays;
import java.util.Scanner;

public class D2025_04_22_백준2309_일곱난쟁이 {
    static int[] dwarf = new int[9];
    static int[] selected = new int[7];
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 9명의 키 입력
        for (int i = 0; i < 9; i++) {
            dwarf[i] = sc.nextInt();
        }

        comb(0, 0);
    }

    // 조합: idx = 현재 뽑을 위치, start = 현재 선택할 인덱스
    static void comb(int idx, int start) {
        if (found) return;  // 이미 찾았으면 더 안 봐도 됨

        if (idx == 7) {  // 7명 뽑았을 때
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += selected[i];
            }
            if (sum == 100) {  // 합이 100이면 출력
                Arrays.sort(selected);  // 오름차순 정렬
                for (int i = 0; i < 7; i++) {
                    System.out.println(selected[i]);
                }
                found = true;  // 찾았음을 표시
            }
            return;
        }

        // 조합으로 7명을 뽑는 부분
        for (int i = start; i < 9; i++) {
            selected[idx] = dwarf[i];
            comb(idx + 1, i + 1);
        }
    }
}
