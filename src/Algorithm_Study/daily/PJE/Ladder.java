package Algorithm_Study.daily.PJE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int tc = sc.nextInt();
            
            //입력
            int[][] board = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            
            
            int answer = 0;
            
            for (int startCol = 0; startCol < 100; startCol++) {
                if (board[0][startCol] == 1) {  // 시작 지점 확인
                    int row = 0;
                    int col = startCol;

                    //방향 확인 변수 (무한루프 방지)
                    boolean goRight = false;
                    boolean goLeft = false;

                    while (row < board.length-1) { 
                    	if (!goLeft && col < board.length-1 && board[row][col + 1] == 1) { //왼쪽에서 온게 아니고, 오른쪽으로 가도 된다면
                            goRight = true; //오른쪽 표시
                            goLeft = false; //왼쪽 초기화
                            col++;
                        } else if (!goRight && col > 0 && board[row][col - 1] == 1) { //오른쪽에서 온게 아니고, 왼쪽으로 가도 된다면
                            goLeft = true; //왼쪽 표시
                            goRight = false; //오른쪽 초기화
                            col--; 
                        } else { // 오,왼 둘다 못가는 상황이면
                            goRight = false; //오른쪽 초기화
                            goLeft = false; //왼쪽 초기화
                            row++; //한칸 아래로 내려감
                        }
                    }

                    if (board[row][col] == 2) {
                        answer = startCol;
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
