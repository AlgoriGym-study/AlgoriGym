package Algorithm_Study.daily.PJE.D202602;
public class D20260208 {
//     public int solution(String myString, String pat) {
//         int answer = 0;
//         // IndexOf로 시작 idx를 알아내고 그 다음 인덱스로부터 또 IndexOf로 다음 인덱스 알아내고..
//         while(true){
//             int idx = myString.indexOf(pat);
//             if(idx==-1) break;
//             myString = myString.substring(idx+1 ,myString.length());
//             answer++;
            
//         }
//         return answer;
//     }
    public int solution(String myString, String pat) {
        int answer = 0;
        int idx = 0;
        
        // myString을 자르지 않고 시작 위치(idx)만 갱신하며 찾기
        while ((idx = myString.indexOf(pat, idx)) != -1) {
            answer++;
            idx++; // 찾은 위치 바로 다음부터 다시 탐색
        }
        
        return answer;
    }
}
