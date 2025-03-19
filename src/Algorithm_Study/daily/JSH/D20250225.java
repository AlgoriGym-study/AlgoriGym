//
//import java.util.Arrays;
//
//class D20250225 {
//    public int solution(int[] numbers) {
//        int answer = 0;
//
//        Arrays.sort(numbers);
//
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < numbers.length; j++) {
//                if (i == numbers[j]) {
//                    arr[i]++;
//                }
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0) {
//                answer += i;
//            }
//        }
//
//        return answer;
//    }
//}