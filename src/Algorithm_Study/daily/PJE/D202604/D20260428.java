package Algorithm_Study.daily.PJE.D202604;
public class D20260428 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0; // cards1의 현재 위치
        int idx2 = 0; // cards2의 현재 위치
        
        for (String word : goal) {
            // 1. cards1에서 가져올 수 있는 경우 (아직 남았고, 단어가 일치할 때)
            if (idx1 < cards1.length && word.equals(cards1[idx1])) {
                idx1++;
            }
            // 2. cards2에서 가져올 수 있는 경우 (아직 남았고, 단어가 일치할 때)
            else if (idx2 < cards2.length && word.equals(cards2[idx2])) {
                idx2++;
            }
            // 3. 둘 다 아니면 규칙 위반
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}
