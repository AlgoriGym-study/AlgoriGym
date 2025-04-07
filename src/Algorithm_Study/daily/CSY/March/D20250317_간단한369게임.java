package Algorithm_Study.daily.CSY.March;

import java.util.Scanner;
public class D20250317_간단한369게임{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int count = 0;
            int num = i;

            // 숫자 i에 포함된 3, 6, 9의 개수를 셈
            // 만약 나머지가 3,6,9 중 하나라면 Count++
            while (num > 0) {
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    count++;
                }
                num /= 10; // 다음 자리로
            }

            // (카운트 개수)3, 6, 9가 포함되어 있으면 그 개수만큼 "-"를 출력
            if (count > 0) {
                for (int j = 0; j < count; j++) {
                    sb.append("-");
                }
                sb.append(" ");
            } else {
                sb.append(i).append(" ");
            }
        }

        // 마지막 공백을 제거하고 출력
        System.out.println(sb.toString().trim());
    }
}
