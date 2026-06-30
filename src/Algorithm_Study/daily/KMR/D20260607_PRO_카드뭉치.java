package Algorithm_Study.daily.KMR;

public class D20260607_PRO_카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i1 = 0; // cards1 포인터
        int i2 = 0; // cards2 포인터

        for (String word : goal) {
            if (i1 < cards1.length && cards1[i1].equals(word)) {
                i1++;
            } else if (i2 < cards2.length && cards2[i2].equals(word)) {
                i2++;
            } else {
                // 어느 뭉치의 맨 앞과도 일치하지 않음
                return "No";
            }
        }

        return "Yes";
    }
}
