package Algorithm_Study.common.C202509.C20250910;

import java.io.*;
import java.util.*;

// 백준 17478번 재귀함수가 뭔가요?
public class KMR0042 {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        recursion(0);
        br.close();
    }//main

    static void recursion(int count) {
        if (count == N) {
            printQuestion(count);
            printAnswer(count);
            printEnd(count);
            return;
        }

        if (count == 0) {
            System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        }

        printQuestion(count);
        printStory(count);
        recursion(count + 1);
        printEnd(count);

    }

    static void printUnderBar(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("____");
        }
    }

    static void printQuestion(int count) {
        printUnderBar(count);
        System.out.println("\"재귀함수가 뭔가요?\"");
    }

    static void printAnswer(int count) {
        printUnderBar(count);
        System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
    }

    static void printStory(int count) {
        printUnderBar(count);
        System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        printUnderBar(count);
        System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        printUnderBar(count);
        System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
    }

    static void printEnd(int count) {
        printUnderBar(count);
        System.out.println("라고 답변하였지.");
    }

}
