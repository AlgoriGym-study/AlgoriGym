package Algorithm_Study.daily.PJE.D202606;
public class D20260622 {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }
    void dfs(int[] numbers, int target, int index, int currentSum) {
    // 1. 종료 조건: index가 numbers.length에 도달했을 때
    //    → currentSum이 target과 같으면 answer++
    if(index==numbers.length){
        if(currentSum==target) {
            answer++;
           
        }
         return;
    }    
    // 2. 재귀 호출 두 번
    //    → + 붙이는 경우
    dfs(numbers,target,index+1, currentSum+numbers[index]);
    //    → - 붙이는 경우
    dfs(numbers,target,index+1, currentSum-numbers[index]);
    }
}
