package Algorithm_Study.daily.PJE.D202606;
public class D20260601 {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int idx = 0;
        // 탈락 조건 :  1.같은 단어를 말하거나 2.단어의 마지막 알파벳과 다음 단어의 첫 알파벳이 연결되지X
        
        
        a : for(int i = 1; i < words.length; i++){
                // 2. 단어의 마지막 알파벳과 다음 단어의 첫 알파벳이 연결되지X
                if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                    idx = i;
                    break;
                }
            b : for(int j = 0; j < i; j++){
                // 1. 같은 단어일때
                if(words[i].equals(words[j])){
                    idx = i;
                    break a;
                }
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        // System.out.println(idx%n +1 + " " + (idx) / n);
        int num = 0; // 번호
        int turn = 0; // 차례
        if(idx != 0) {
            num = idx%n +1; 
            turn = idx/n +1;
        }
        
        return new int []{num, turn};
    }
}
