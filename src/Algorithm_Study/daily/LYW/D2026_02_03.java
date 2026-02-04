package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2026_02_03 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = idx(ext);
        int sortIdx = idx(sort_by);

        List<int[]> filtered = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) filtered.add(row);
        }

        filtered.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[sortIdx], b[sortIdx]);
            }
        });

        int[][] answer = new int[filtered.size()][4];
        for (int i = 0; i < filtered.size(); i++) {
            answer[i] = filtered.get(i);
        }
        return answer;
    }

    private int idx(String key) {
        if (key.equals("code")) return 0;
        if (key.equals("date")) return 1;
        if (key.equals("maximum")) return 2;
        return 3; // "remain"
    }
}
