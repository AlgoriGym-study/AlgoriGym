package Algorithm_Study.daily.LYR.Jan2026;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D20260107 {
    public long solution(long n) {
        String[] split = String.valueOf(n).split("");
        Arrays.sort(split);
        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        String num = "";
        for(String ss : list){
            num += ss;
        }

        return Long.parseLong(num);
    }
}
