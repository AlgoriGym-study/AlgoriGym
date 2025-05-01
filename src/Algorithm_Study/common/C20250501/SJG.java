package Algorithm_Study.common.C20250501;

public class SJG {
  public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        
        // "mm:ss" 형식의 문자열을 ":" 기준으로 분·초로 분리
        String[] videoLenArr = video_len.split(":");
        String[] posArr      = pos.split(":");
        String[] opStartArr  = op_start.split(":");
        String[] opEndArr    = op_end.split(":");
        
        // 분 단위 값을 초로 환산 (분 * 60 + 초)
        int videoLenSec = Integer.parseInt(videoLenArr[0]) * 60 
                        + Integer.parseInt(videoLenArr[1]);
        int posSec      = Integer.parseInt(posArr[0]) * 60 
                        + Integer.parseInt(posArr[1]);
        int opStartSec  = Integer.parseInt(opStartArr[0]) * 60 
                        + Integer.parseInt(opStartArr[1]);
        int opEndSec    = Integer.parseInt(opEndArr[0]) * 60 
                        + Integer.parseInt(opEndArr[1]);
        
        // 명령어 하나씩 처리
        for (String cmd : commands) {
            // 오프닝 구간에 위치하면 자동으로 끝나는 시점으로 이동
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
            
            switch (cmd) {
                case "next":
                    // 10초 이후로 이동
                    posSec = Math.min(posSec + 10, videoLenSec);
                    break;
                case "prev":
                    // 10초 이전으로 이동
                    posSec = Math.max(posSec - 10, 0);
                    break;
            }
            
            // 이동 후에도 오프닝 구간이면 끝나는 시점으로 강제 이동
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }
        
        // 최종 posSec을 "mm:ss" 형식으로 다시 변환
        int posMinute = posSec / 60;
        int posSecond = posSec % 60;
        
        // 두 자리 수 포맷(예: 03:07)
        sb.append(String.format("%02d:%02d", posMinute, posSecond));
        return sb.toString();
    }
}
