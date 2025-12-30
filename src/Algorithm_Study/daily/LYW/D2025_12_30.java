package Algorithm_Study.daily.LYW;

import java.util.Arrays;

public class D2025_12_30 {
	public int[] solution(int[] lottos, int[] win_nums) {
		Arrays.sort(lottos);
		Arrays.sort(win_nums);

		int zero = 0; // 0 갯수
		int num = 0; // 일치하는 숫자 개수

		for (int lotto : lottos) {
			if (lotto == 0) {
				zero++;
			} else {
				for (int win : win_nums) {
					if (lotto == win) {
						num++;
						break;
					}
				}
			}
		}

		int max = num + zero; // 최고 맞춘 개수
		int min = num; // 최저 맞춘 개수

		int maxRank = getRank(max);
		int minRank = getRank(min);

		return new int[] { maxRank, minRank };
	}

	// 순위 계산 메서드
	private int getRank(int count) {
		switch (count) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
}
