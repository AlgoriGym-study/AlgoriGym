package Algorithm_Study.daily.CSY.April;


import java.util.*;
public class D20250414_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int aIdx = 0;
        for(int c = 0; c < commands.length; c++){
            int i = commands[c][0]-1;
            int j = commands[c][1]-1;
            int k = commands[c][2]-1;

            int[] arr = new int[j-i+1];
            int idx = 0;
            for(int a = i; a <= j; a++){
                arr[idx++] = array[a];
            }// 1번 수행 : 새 배열 만들기

            Arrays.sort(arr); // 2번 수행 : 오름차순 정렬
            answer[aIdx++] = arr[k]; // 3번 수행 : k번째 숫자를 저장.

        }

        return answer;
    }
}