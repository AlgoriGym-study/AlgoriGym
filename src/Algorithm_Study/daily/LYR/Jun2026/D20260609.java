package Algorithm_Study.daily.LYR.Jun2026;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class D20260609 {
    public int solution(int n, int k) {
        int answer = 0;
        answer = n * 12000 + k * 2000 - n/10 * 2000;
        return answer;
    }

    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        int idx = 0;
        for(int i=num1;i<=num2;i++){
            answer[idx++] = numbers[i];
        }
        return answer;
    }

    public int solution(int[] dot) {
        if(dot[0] > 0 && dot[1] > 0)
            return 1;
        else if(dot[0] < 0 && dot[1] > 0)
            return 2;
        else if(dot[0] < 0 && dot[1] < 0)
            return 3;
        else
            return 4;
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Integer> cache = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for(String c : cities){
            String city = c.toLowerCase();
            if(cache.containsKey(city)){
                answer += 1;
                queue.remove(city);
                queue.add(city);
                continue;
            }
            else
                answer += 5;
            if(cacheSize == 0)
                continue;
            if(queue.size() < cacheSize){
                cache.put(city, 1);
                queue.add(city);
            }
            else{
                cache.remove(queue.peek());
                queue.remove();
                queue.add(city);
                cache.put(city,1);
            }
        }
        return answer;
    }
}
