package Algorithm_Study.daily.YHS;

public class D20251105_유연근무제 {
    static int solution(int[] schedules, int[][] timelogs, int startday) {
        int ans = 0;
        for (int i = 0; i < schedules.length; i++) {
            boolean isLate = false;
            int baseTime = toMinutes(schedules[i]);
            int limitTime = baseTime + 10;

            for (int j = 0; j < 7; j++) {
                int dayOfWeek = (startday + j - 1) % 7 + 1;

                if (dayOfWeek == 6 || dayOfWeek == 7) continue;

                int checkTime = toMinutes(timelogs[i][j]);
                if (checkTime > limitTime) {
                    isLate = true;
                    break;
                }
            }

            if (!isLate)
                ans++;
        }

        return ans;
    }

    static int toMinutes(int time) {
        return (time / 100) * 60 + (time % 100);
    }
}
