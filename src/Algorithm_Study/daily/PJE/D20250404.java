package Algorithm_Study.daily.PJE;
import java.util.TreeSet;

public class D20250404 {
	static int[] solution(int[] numbers) {
		int len = numbers.length;
		TreeSet<Integer> set = new TreeSet<Integer>();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				sum = numbers[i]+numbers[j];
				set.add(sum);
			}
		}
		int [] ans = new int [len];
		for (int i = 0; i < len; i++) {
			ans[i] = set.pollLast();
		}
		return ans;
	}

}
