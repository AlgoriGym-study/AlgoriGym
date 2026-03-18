package Algorithm_Study.daily.LYR.Mar2026;

public class D20260318 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] arr = s.toCharArray();
        boolean[] check = new boolean[26];
        for(int i=0;i<arr.length;i++){
            if(!check[arr[i] - 'a']){ //나온 적 없는 경우
                answer[i] = -1;
                check[arr[i] - 'a'] = true;
            }
            else { //나온 적 있는 경우
                int count = 0;
                for(int j=i-1;j>=0;j--){
                    count++;
                    if(arr[i] == arr[j]){
                        answer[i] = count;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
