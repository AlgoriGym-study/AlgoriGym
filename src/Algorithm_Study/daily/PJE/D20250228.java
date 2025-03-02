package Algorithm_Study.daily.PJE;
import java.util.Scanner;

public class D20250228 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine()); 

        for (int t = 1; t <= T; t++) {
            String s = sc.nextLine(); 
            int totalPeices = 0, cnt = 0; // 결과(총막대기갯수), 현재 막대 개수
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') { 
                        // 레이저: 현재까지 쌓인 막대 수 만큼 잘림.
                    	totalPeices += cnt;
                        i++; // 바로 다음 ')' 건너뛰기
                    } else {
                        // 새로운 막대 시작
                        cnt++;
                    }
                } else { 
                    // 막대기 끝나는 부분
                    cnt--;
                    totalPeices++;
                }
            }
            System.out.println("#" + t + " " + totalPeices);
        }
        sc.close(); // Scanner 닫기
    }
}
