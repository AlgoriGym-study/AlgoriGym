package Algorithm_Study.common.C202507.C20250723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SJG0034_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> sortedList = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            
            // 이진 탐색으로 삽입 위치 찾기
            int pos = Collections.binarySearch(sortedList, input);
            if(pos < 0) pos = -(pos + 1);
            sortedList.add(pos, input);
            
            // 중간값 출력
            int median = sortedList.get(i / 2);
            sb.append(median).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}
