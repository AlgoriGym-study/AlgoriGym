package Algorithm_Study.common.C202505.C20250501;

class YHS {
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String ans = "";

        String[] videoLen = video_len.split(":");
        String[] posString = pos.split(":");
        String[] startString = op_start.split(":");
        String[] endString = op_end.split(":");

        int videolen = (Integer.parseInt(videoLen[0]) * 60) + Integer.parseInt(videoLen[1]);
        int posToSec = (Integer.parseInt(posString[0]) * 60) + Integer.parseInt(posString[1]);
        int start = (Integer.parseInt(startString[0]) * 60) + Integer.parseInt(startString[1]);
        int end = (Integer.parseInt(endString[0]) * 60) + Integer.parseInt(endString[1]);

        // 초기 오프닝 점프
        if (start <= posToSec && posToSec <= end) {
            posToSec = end;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                posToSec = Math.max(0, posToSec - 10);
            } else if (command.equals("next")) {
                posToSec = Math.min(videolen, posToSec + 10);
            }

            // 오프닝 범위 재진입 시 스킵
            if (start <= posToSec && posToSec <= end) {
                posToSec = end;
            }
        }

        String minute = String.format("%02d", posToSec / 60);
        String second = String.format("%02d", posToSec % 60);
        ans = minute + ":" + second;

        return ans;
    }

    //출력
    public static void main(String[] args) {
        String ans = solution("07:22","04:05","00:15","04:07",new String[] {"next"});

        System.out.println(ans);
    }
}