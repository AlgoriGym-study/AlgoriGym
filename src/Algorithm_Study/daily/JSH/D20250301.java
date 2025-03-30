//import java.util.Scanner;
//import java.util.Stack;
//
//public class D20250301 {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();
//        sc.nextLine();
//
//        for (int test_case = 1; test_case <= T; test_case++) {
//
//            String str = sc.nextLine();
//
//            char[] charArr = str.toCharArray();
//
//            Stack<Character> stack = new Stack<>();
//
//            int count = 0;
//            for (int i = 0; i < charArr.length; i++) {
//
//                if (charArr[i] == '(') {
//                    stack.push(charArr[i]);
//
//                } else {
//                    stack.pop();
//
//                    if (charArr[i - 1] == '(' && i > 0) {
//
//                        int size = stack.size();
//                        count = count + size;
//
//                    } else {
//                        count++;
//                    }
//                }
//
//            }
//            System.out.println("#" + test_case + " " + count);
//        }
//    }
//}
