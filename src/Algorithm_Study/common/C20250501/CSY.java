package Algorithm_Study.common.C20250501;

public class CSY {
    public static void main(String[] args) {
        // 	"07:22", "04:05", "00:15", "04:07", ["next"]
        String[] com = { "next" };
        String res = solution("07:22", "04:05", "00:15", "04:07", com);
        System.out.println(res);
    }

    static public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] video = video_len.split(":"); // [34, 33] mm : ss
        String[] posArr = pos.split(":"); // [13, 00]
        String[] opStart = op_start.split(":"); // [00, 55]
        String[] opEnd = op_end.split(":"); // [02, 55]

        int vv = (Integer.parseInt(video[0]) * 60) + Integer.parseInt(video[1]);
        int pp = (Integer.parseInt(posArr[0]) * 60) + Integer.parseInt(posArr[1]);
        int ss = (Integer.parseInt(opStart[0]) * 60) + Integer.parseInt(opStart[1]);
        int ee = (Integer.parseInt(opEnd[0]) * 60) + Integer.parseInt(opEnd[1]);


        for (String c : commands) {
            switch (c) {
                case "next":
                    // 오프닝 검사
                    if (pp >= ss && pp <= ee) pp = ee;

                    pp += 10;

                    // 오프닝 검사
                    if (pp >= ss && pp <= ee) pp = ee;

                    // 비디오 구간 넘어갈 때
                    if(pp > vv) pp = vv;

                    break;
                case "prev":
                    pp -= 10;

                    // 오프닝 검사
                    if (pp >= ss && pp <= ee) pp = ee;

                    if(pp < 0) pp = 0;
                    break;
            }
        }
        int mm = pp/60;
        int sec = pp%60;
        posArr[0] = String.valueOf(mm);
        posArr[1] = String.valueOf(sec);


        for (int i = 0; i < 2; i++) {
            if (posArr[i].length() == 1) {
                posArr[i] = "0" + posArr[i];
            }
        }
        // 한 자리 수일 때 앞에 0 붙여줘야 함.
        answer = posArr[0] + ":" + posArr[1];

        return answer;
    }

}
