package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_04_30_백준1330_방배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 학생 수
        int K = sc.nextInt(); // 한 방에 들어갈 수 있는 최대 인원

        int[][] students = new int[2][7]; // [성별][학년], index 1~6 사용

        for (int i = 0; i < N; i++) {
            int gender = sc.nextInt(); // 0: 여자, 1: 남자
            int grade = sc.nextInt();  // 1~6학년
            students[gender][grade]++;
        }

        int roomCount = 0;
        for (int g = 0; g < 2; g++) {
            for (int gr = 1; gr <= 6; gr++) {
                int count = students[g][gr];
                if (count > 0) {
                    roomCount += (count + K - 1) / K; // 올림 처리
                }
            }
        }

        System.out.println(roomCount);
    }
}
