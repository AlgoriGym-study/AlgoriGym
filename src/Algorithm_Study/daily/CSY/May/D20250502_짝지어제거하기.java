package Algorithm_Study.daily.CSY.May;
import java.util.*;
public class D20250502_짝지어제거하기 {



        public static void main(String[] args) {
            System.out.println(solution("baabaa"));
        }

        static public int solution(String s) {
            char[] arr = s.toCharArray();

            int answer = 0;

            Stack<Character> stack = new Stack<>();
            for(char c : arr) {
                if(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }

            if(stack.isEmpty()) answer = 1;

//		StringBuilder sb = new StringBuilder();
//
//		for(int i = 0; i < arr.length; i++) {
//			sb.append(arr[i]);
//			System.out.println(sb.toString());
//			if(i % 2 == 1) {
//				if(sb.toString().equals(sb.reverse().toString())) {
//					sb = new StringBuilder();
//				}else {
//					sb.reverse();
//				}
//			}
//		}
//
//		if(sb.length() > 0) answer = 0;
//		List<Character> list = new ArrayList<>();
//
//		for (int i = 0; i < arr.length; i++) {
//			list.add(arr[i]);
//		}
//		int answer = 1;
//
//		while (!list.isEmpty()) {
//			boolean isStop = true;
//			f: for (int i = 0; i < list.size() - 1; i++) {
//				if (list.get(i) == list.get(i + 1)) {
//					list.remove(i + 1);
//					list.remove(i);
//					isStop = false;
//					break f;
//				}
//			}
//
//			if (isStop) {
//				answer = 0;
//				break;
//			}
//		}

            return answer;
        }

    }
