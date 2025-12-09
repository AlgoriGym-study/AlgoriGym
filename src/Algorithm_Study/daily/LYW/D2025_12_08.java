package Algorithm_Study.daily.LYW;

public class D2025_12_08 {
	private int toMinutes(int hhmm) {
		int h = hhmm / 100;
		int m = hhmm % 100;
		return h * 60 + m;
	}

	public int solution(int startday, int[][] schedules, int[][] timelogs) {
		int n = schedules.length;
		int answer = 0;

		for (int emp = 0; emp < n; emp++) {
			boolean ok = true;

			for (int d = 0; d < 7; d++) {
				int day = ((startday - 1 + d) % 7) + 1;
				if (day == 6 || day == 7)
					continue;

				int wantMin = toMinutes(schedules[emp][d]);
				int limitMin = wantMin + 10;
				int realMin = toMinutes(timelogs[emp][d]);

				if (realMin > limitMin) {
					ok = false;
					break;
				}
			}

			if (ok)
				answer++;
		}

		return answer;
	}
}
