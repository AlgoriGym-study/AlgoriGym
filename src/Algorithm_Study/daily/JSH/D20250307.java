import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D20250307 {
	public int[] solution(int n, int m) {
		int length = 0;
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		int[] answer = new int[2];

		if (n > m) {
			length = n;

			for (int i = 1; i <= length; i++) {
				if (n % i == 0 && m % i == 0) {
					list1.add(i);
				}
			}
			answer[0] = list1.get(list1.size() - 1);
			if (list1.size() == 0) {
				list1.add(1);
			}
			for (int i = n * m; i > 0; i--) {
				if (i % n == 0 && i % m == 0) {
					list2.add(i);
				}
			}
			answer[1] = list2.get(list2.size() - 1);

		} else {
			length = m;
			for (int i = 1; i <= length; i++) {
				if (n % i == 0 && m % i == 0) {
					list1.add(i);
				}
			}
			answer[0] = list1.get(list1.size() - 1);
			if (list1.size() == 0) {
				list1.add(1);
			}

			for (int i = n * m; i > 0; i--) {
				if (i % n == 0 && i % m == 0) {
					list2.add(i);
				}
			}
			answer[1] = list2.get(list2.size() - 1);
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
