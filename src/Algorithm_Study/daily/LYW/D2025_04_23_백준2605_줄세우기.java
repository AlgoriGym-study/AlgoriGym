package Algorithm_Study.daily.LYW;

import java.util.ArrayList;
import java.util.Scanner;

public class D2025_04_23_백준2605_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();                // 학생 수
        int[] numbers = new int[N];          // 종이에 적힌 숫자

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        ArrayList<Integer> line = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            // line.size() - numbers[i] 위치에 학생 번호 i+1을 삽입
            line.add(line.size() - numbers[i], i + 1);
        }

        for (int student : line) {
            System.out.print(student + " ");
        }
    }
}
