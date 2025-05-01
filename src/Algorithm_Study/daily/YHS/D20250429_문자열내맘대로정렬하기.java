package Algorithm_Study.daily.YHS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class D20250429_문자열내맘대로정렬하기 {
    public List<String> solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        
        for (String str : strings) {
            list.add(str);
        }
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                }
                return o1.charAt(n) - o2.charAt(n);
            }
        });
        
        return list;
    }
}
