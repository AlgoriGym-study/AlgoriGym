package Algorithm_Study.common.C202505.C20250501;

public class LYW {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = timeToSec(video_len);
        int currTime = timeToSec(pos);
        int opStart = timeToSec(op_start);
        int opEnd = timeToSec(op_end);

        // 처음 시작 위치가 오프닝 구간이면 오프닝 끝으로 이동
        if (currTime >= opStart && currTime <= opEnd) {
            currTime = opEnd;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                currTime = Math.max(0, currTime - 10);
            } else if (command.equals("next")) {
                currTime = Math.min(videoLen, currTime + 10);
            }

            // 명령 후 오프닝 구간이면 이동
            if (currTime >= opStart && currTime <= opEnd) {
                currTime = opEnd;
            }
        }

        return secToTime(currTime);
    }

    private int timeToSec(String time) {
        String[] parts = time.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        return min * 60 + sec;
    }

    private String secToTime(int sec) {
        int min = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", min, s);
    }
}