package Algorithm_Study.common.C20250625;

import java.io.*;
import java.util.*;

class YHS0026 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++) {
            br.readLine();    						// 원본 암호문의 길이 날리기
            LinkedList<String> password = new LinkedList<>();   // 암호문
            StringTokenizer original = new StringTokenizer(br.readLine());
            while(original.hasMoreTokens()) {
                password.add(original.nextToken());	// 원본 암호문 LinkedList에 저장
            }
            br.readLine();    						// 명령어의 개수 날리기
            // 명령어
            StringTokenizer command = new StringTokenizer(br.readLine());
            while(command.hasMoreTokens()) {
                String func = command.nextToken();	// 기능
                if(func.equals("I")) {
                    int x = Integer.parseInt(command.nextToken());  // 삽입 위치
                    int y = Integer.parseInt(command.nextToken());  // 삽입 개수
                    for (int i = 0; i < y; i++) {
                        password.add(x + i, command.nextToken());   // 암호문에 삽입
                    }
                } else if(func.equals("A")){
                    int x = password.size();  						// 삽입 위치 맨 뒤
                    int y = Integer.parseInt(command.nextToken());  // 삽입 개수
                    for (int i = 0; i < y; i++) {
                        password.add(x + i, command.nextToken());   // 암호문에 삽입
                    }
                } else {
                    int x = Integer.parseInt(command.nextToken());  // 삭제 위치
                    int y = Integer.parseInt(command.nextToken());  // 삭제 개수
                    for (int i = 0; i < y; i++) {
                        password.remove(x + i);		// 삭제
                    }
                }
            } // end while
            // 출력
            System.out.print("#" + test_case);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + password.get(i));
            } System.out.println();
        }
    }
}
