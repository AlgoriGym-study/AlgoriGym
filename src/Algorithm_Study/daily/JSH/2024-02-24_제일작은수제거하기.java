import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	public int[] solution(int[] arr) {

		List<Integer> list = new ArrayList<>();

		int[] answer = {};

		if (arr.length == 1) {
			answer = new int[1];
			answer[0] = -1;
			return answer;
		} else {
			int[] checkMin = new int[arr.length];
			int[] checkArr = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				checkMin[i] = arr[i];
				checkArr[i] = arr[i];
				list.add(arr[i]);
			}
			Arrays.sort(checkMin);
			int deleteNum = checkMin[0];
			int idx = 0;
			for (int i = 0; i < checkMin.length; i++) {
				if (checkArr[i] == deleteNum) {
					idx = i;
				}
			}
			list.remove(idx);
			answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;

		}

	}

}