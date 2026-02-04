package Algorithm_Study.daily.LYR.Jan2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D20260203 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        Map<String, Integer> type = new HashMap<>();
        type.put("code", 0);
        type.put("date", 1);
        type.put("maximum", 2);
        type.put("remain",3);

        int idx = type.get(ext);
        int sort = type.get(sort_by);

        for(int i=0;i<data.length;i++){
            if(data[i][idx] < val_ext)
                list.add(data[i]);
        }

        list.sort((o1, o2) -> o1[sort] - o2[sort]);

        int[][] answer = new int[list.size()][4];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
