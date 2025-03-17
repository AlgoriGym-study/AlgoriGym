//import java.util.Scanner;
//
//public class D20250228 {
//    public static void main(String[] args) throws Exception {
//
//        Scanner sc = new Scanner(System.in);
////		Scanner sc = new Scanner(new File("input.txt"));
//
//        int T;
//        T = sc.nextInt();
//
//        for (int test_case = 1; test_case <= T; test_case++) {
//
//            int N = sc.nextInt(); // 배열 크기
//            int M = sc.nextInt(); // 파리채 크기
//            int[][] arr = new int[N][N];
//
//            // 배열 입력 받기
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    arr[i][j] = sc.nextInt();
//                }
//            }
//
//            int max = Integer.MIN_VALUE;
//            int num = 0;
//
//            for (int k = 0; k < N - M + 1; k++) {
//                for (int l = 0; l < N - M + 1; l++) {
//                    num = 0;
//                    for (int i = 0; i < M; i++) {
//                        for (int j = 0; j < M; j++) {
//                            num = num + arr[i + k][j + l];
////							System.out.println(num + " ");
//                        }
//                        max = Math.max(max, num);
//                    }
//                }
//            }
//            System.out.println("#" + test_case + " " + max);
//        }
//    }}
