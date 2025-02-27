package Algorithm_Study.daily.LYW;
import java.util.Scanner;
import java.io.FileInputStream;
 

class D2025_02_27_SWEA_18575_풍선팡_보너스_게임
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
         
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
             
            int max = 0;
            int min = Integer.MAX_VALUE;
             
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int sumr = 0;
                    int sumc = 0;
                    // arr[i][j]를 기준으로 행,열의 합을 구하기
                    for(int a = 0; a < N; a++) {
                        sumr += arr[i][a];
                        sumc += arr[a][j];
                    }
                    int sum = sumr + sumc - arr[i][j];
                    max = Math.max(max, sum);
                    min = Math.min(min, sum);
                }
            }
             
            System.out.println("#" + test_case + " " + (max - min));
 
        }
    }
}