import java.util.Arrays;
import java.util.Scanner;

public class D20250303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));

//		int T = sc.nextInt();
//		sc.nextLine();

        for (int test_case = 1; test_case <= 10; test_case++) {

            int N = sc.nextInt();
            sc.nextLine();

            int[] arr = new int[100];
            String str = sc.nextLine();
            String[] strArr = str.split(" ");

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }

            int count = 0;
            while (count < N) {

                Arrays.sort(arr);
                arr[0] = arr[0] + 1;
                arr[99] = arr[99] - 1;
                count++;
            }
            Arrays.sort(arr);
            int result = arr[99] - arr[0];
            System.out.println("#" + test_case + " " + result);

        }
    }   //main
}
