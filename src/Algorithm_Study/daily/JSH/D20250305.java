import java.util.ArrayList;
import java.util.List;

public class D20250305 {
	public int[] solution(int[] numbers) {
		int[] answer = {};

		List<Integer> list = new ArrayList<>();
		List<Integer> sumList = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i == j)
					continue;
				sumList.add(list.get(i) + list.get(j));
			}
		}

		int[] arr = new int[10000];
		for (int i = 0; i < sumList.size(); i++) {
			int idx = sumList.get(i);
			arr[idx]++;
		}

		List<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arrList.add(i);
			}
		}
		answer = new int[arrList.size()];
		for (int i = 0; i < arrList.size(); i++) {
			answer[i] = arrList.get(i);
		}
		return answer;
	}
}
