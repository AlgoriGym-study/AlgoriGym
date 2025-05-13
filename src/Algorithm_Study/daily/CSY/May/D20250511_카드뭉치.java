package Algorithm_Study.daily.CSY.May;

public class D20250511_카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx1 = 0, idx2 = 0;
        for(String g : goal){
            if(idx1 < cards1.length && g.equals(cards1[idx1]))
                idx1++;
            else if(idx2 < cards2.length && g.equals(cards2[idx2]))
                idx2++;
            else
                return "No";
//             // card 1
//             for(int i = idx1; i < cards1.length; i++){
//                 if(g.equals(cards1[i])){
//                     System.out.println(idx1 + " " + g);
//                     idx1++;
//                     continue f;
//                 }
//             }

//             // card 2
//             for(int i = idx2; i < cards2.length; i++){
//                 if(g.equals(cards2[i])){
//                     System.out.println(idx2 + " " + g);
//                     idx2++;
//                     continue f;
//                 }
//             }
//         }
//         if(idx1 == cards1.length && idx2 == cards2.length)
//             answer = "Yes";
        }
        return answer;
    }
}
