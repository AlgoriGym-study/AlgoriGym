package Algorithm_Study.common.C202506.C20250625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CSY0026 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++){
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine().split(" ")[0]); // 암호문 개수 N

            String[] codes = br.readLine().split(" "); // 암호문 입력 받기
            LinkedList<Integer> list = new LinkedList<>(); // 암호문 뭉치
            for(int i = 0; i < N; i++){
                list.add(Integer.parseInt(codes[i]));
            }

            int M = Integer.parseInt(br.readLine().split(" ")[0]); // 명령어 개수 M

            String[] commands = br.readLine().split(" "); // 명령어 입력 받기
            int i = 0; // 명령어 인덱스
            for (int k = 0; k < M; k++){
                String op = commands[i++];
                switch (op){
                    case "I": {
                        int x = Integer.parseInt(commands[i++]);
                        int y = Integer.parseInt(commands[i++]);
                        for(int j = 0; j < y; j++){ // x번째 암호문 다음에 y개의 암호문 삽입
                            list.add(x + j, Integer.parseInt(commands[i++]));
                        }
                        break;
                    }
                    case "D": {
                        int a = Integer.parseInt(commands[i++]);
                        int b = Integer.parseInt(commands[i++]);
                        for(int j = 0; j < b; j++){ // a번째 암호문 다음부터 y개의 암호문 삭제
                            list.remove(a); // 한 개씩 계속 삭제되기 때문에 인덱스 증감 필요없음
                        }
                        break;
                    }
                    case "A": {
                        int y = Integer.parseInt(commands[i++]);
                        for(int j = 0; j < y; j++){// 맨 뒤에 r개의 암호문 추가
                            list.add(Integer.parseInt(commands[i++]));
                        }
                        break;
                    }
                }
            }// while

            for(int a = 0; a < 10; a++){
                sb.append(list.get(a)).append(" ");
            }
            sb.append("\n");
        }// tc
        System.out.println(sb);
    }
}
