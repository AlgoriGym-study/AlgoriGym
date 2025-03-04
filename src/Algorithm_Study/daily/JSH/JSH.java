import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JSH {

    public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));

        int T=sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            sc.nextLine();

            char[][] board = new char[N][N];

            for (int i = 0; i < N; i++) {
                board[i] = sc.nextLine().toCharArray();
            }

            boolean answer = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 'o') {
                        // 1. 가로 방향
                        if (j + 4 < N && board[i][j + 1] == 'o' && board[i][j + 2] == 'o' && board[i][j + 3] == 'o'
                                && board[i][j + 4] == 'o') {
                            answer = true;
                        }
                        // 2. 세로 방향
                        if (i + 4 < N && board[i + 1][j] == 'o' && board[i + 2][j] == 'o' && board[i + 3][j] == 'o'
                                && board[i + 4][j] == 'o') {
                            answer = true;
                        }
                        // 3. 대각선 검사
                        if (i + 4 < N && j + 4 < N && board[i + 1][j + 1] == 'o' && board[i + 2][j + 2] == 'o'
                                && board[i + 3][j + 3] == 'o' && board[i + 4][j + 4] == 'o') {
                            answer = true;
                        }
                        // 4. 대각선 검사
                        if (i + 4 < N && j - 4 >= 0 && board[i + 1][j - 1] == 'o' && board[i + 2][j - 2] == 'o'
                                && board[i + 3][j - 3] == 'o' && board[i + 4][j - 4] == 'o') {
                            answer = true;
                        }


                    }
                }

            }
            String result;
            if(answer==true) {
                result="Yes";
            }else {
                result="No";
            }

            System.out.println("#" + test_case + " " +result);
        }
    }

}