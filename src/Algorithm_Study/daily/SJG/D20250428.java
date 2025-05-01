package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250428 {
	public int[] solution(int[] numbers) {
        // 결과를 저장할 HashSet (중복 제거)
        HashSet<Integer> resultSet = new HashSet<>();
        
        // 모든 가능한 두 수의 조합을 더해서 결과 집합에 추가
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                resultSet.add(numbers[i] + numbers[j]);
            }
        }
        
        // HashSet을 배열로 변환
        int[] answer = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            answer[index++] = num;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
