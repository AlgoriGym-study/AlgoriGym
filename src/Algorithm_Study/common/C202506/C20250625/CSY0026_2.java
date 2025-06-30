package Algorithm_Study.common.C202506.C20250625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CSY0026_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++){
            sb.append("#").append(tc).append(" ");
            br.readLine(); // 암호문 길이 날리기
            LinkedList<String> list = new LinkedList<>(); // 암호문 뭉치
            StringTokenizer original = new StringTokenizer(br.readLine());
            while(original.hasMoreTokens()){
                list.add(original.nextToken()); // 암호문들을 list에 저장
            }

            br.readLine(); // 명령어 개수 날리기

            StringTokenizer command = new StringTokenizer(br.readLine());
            while (command.hasMoreTokens()){
                String op = command.nextToken(); // 명령어 종류
                switch (op){
                    case "I":
                        int x = Integer.parseInt(command.nextToken()); // 삽입 위치
                        int y = Integer.parseInt(command.nextToken()); // 삽입할 개수
                        for(int i = 0; i < y; i++){
                            list.add(x+i, command.nextToken());
                        }
                        break;
                    case "A":
                        int a = Integer.parseInt(command.nextToken()); // 삽입할 개수
                        for(int i = 0; i < a; i++){
                            list.add(command.nextToken());
                        }
                        break;
                    case "D":
                        int c = Integer.parseInt(command.nextToken()); // 삭제 위치
                        int d = Integer.parseInt(command.nextToken()); // 삭제 개수
                        for(int i = 0; i < d; i++){
                            list.remove(c);
                        }
                        break;
                }
            }//while

            for(int i = 0; i < 10; i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }//tc
        System.out.println(sb.toString());
    }
}
