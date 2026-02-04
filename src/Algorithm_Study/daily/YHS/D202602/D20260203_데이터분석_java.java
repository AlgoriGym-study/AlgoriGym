package Algorithm_Study.daily.YHS.D202602;

import java.util.*;

public class D20260203_데이터분석_java {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();

        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        int extIdx = map.get(ext);
        int sortIdx = map.get(sort_by);

        int count = 0;
        for (int[] row : data) {
            if (row[extIdx] < val_ext) count++;
        }

        int[][] answer = new int[count][4];

        int idx = 0;
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                answer[idx++] = row;
            }
        }

        Arrays.sort(answer, (a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));


        return answer;
    }
}
