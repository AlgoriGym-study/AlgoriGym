package Algorithm_Study.common.C202510.C20251001;
import java.util.*;

// 프로그래머스 최댓값과 최솟값
public class PJE0048 {
    public String solution(String s) {
        String[] numArr = s.split(" ");
        int len = numArr.length;
        
        // int 변환
        int[] numbers = new int[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = Integer.parseInt(numArr[i]);
        }

        // 정렬
        Arrays.sort(numbers);

        int smallest = numbers[0];
        int biggest = numbers[len - 1];

        // 합치기
        return smallest + " " + biggest;
    }
}
