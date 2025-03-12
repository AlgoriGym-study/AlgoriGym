package Algorithm_Study.daily.LYW;
import java.util.Arrays;
import java.util.Scanner;

public class D2025_03_10_백준1920_수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N과 N배열 입력값 받기
		int N = sc.nextInt();
		int[] arrN = new int[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = sc.nextInt();
		}

		// M과 M배열 입력값 받기
		int M = sc.nextInt();
		int[] arrM = new int[M];
		for (int i = 0; i < M; i++) {
			arrM[i] = sc.nextInt();
		}

		// N,M int배열을 String 배열로 바꾼뒤 검사한다.
		String[] strArrN = new String[N];
		String[] strArrM = new String[M];

		for (int i = 0; i < N; i++) {
			strArrN[i] = Integer.toString(arrN[i]);
		}
		for (int i = 0; i < M; i++) {
			strArrM[i] = Integer.toString(arrM[i]);
		}

		for (int j = 0; j < M; j++) {
			int answer = 0;
			for (int i = 0; i < N; i++) {

				if (strArrN[i].contains(strArrM[j]) == true) {
					answer = 1;
					break;
				}
			}
			System.out.println(answer);
		}

	}
	
	// 이진 탐색 사용 방법
	
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // N과 N배열 입력
//        int N = sc.nextInt();
//        int[] arrN = new int[N];
//        for (int i = 0; i < N; i++) {
//            arrN[i] = sc.nextInt();
//        }
//
//        // 정렬 (이진 탐색을 위한 준비)
//        Arrays.sort(arrN);
//
//        // M과 M배열 입력
//        int M = sc.nextInt();
//        StringBuilder sb = new StringBuilder();  // 출력 최적화를 위해 StringBuilder 사용
//        for (int i = 0; i < M; i++) {
//            int target = sc.nextInt();
//            if (binarySearch(arrN, target)) {
//                sb.append("1\n");
//            } else {
//                sb.append("0\n");
//            }
//        }
//
//        // 한 번에 출력
//        System.out.print(sb.toString());
//    }
//
//    // 이진 탐색 메서드
//    private static boolean binarySearch(int[] arr, int key) {
//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//
//            if (arr[mid] == key) {
//                return true;
//            } else if (arr[mid] < key) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return false;
//    }
}
