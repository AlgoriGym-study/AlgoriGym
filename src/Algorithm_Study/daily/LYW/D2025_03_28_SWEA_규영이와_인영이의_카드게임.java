package Algorithm_Study.daily.LYW;

import java.util.Arrays;
import java.util.Scanner;

public class D2025_03_28_SWEA_규영이와_인영이의_카드게임 {

	static int[] card = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
	static int N = 9;
	static int[] deck1 = new int[9];
	static int[] deck2 = new int[9];
	
	static int[] result = new int[9];
	static boolean[] visited = new boolean[9];
	
	static int win = 0;
	static int lose = 0;
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();  // 테스트 케이스 개수

        for(int tc = 1; tc <= T; tc++) {
            
            win = 0;
            lose = 0;

            // 1. 규영이 카드 입력
            for(int i = 0; i < N; i++) {
                deck1[i] = sc.nextInt();
            }
            
            // 2. 인영이 카드 찾기 (규영이 카드에 없는 숫자로 배열 만들기)
            int idx = 0;
            for(int i = 0; i < 18; i++) {
                boolean found = false;
                for(int j = 0; j < N; j++) {
                    if(card[i] == deck1[j]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    deck2[idx++] = card[i];
                }
            }

            // 3. 인영이 카드 순열 생성 및 승패 확인
            perm(0);

            // 4. 결과 출력
            System.out.println("#" + tc + " " + win + " " + lose);
        }

        sc.close();
    }

    // **순열 생성 함수** (인영이 카드의 모든 조합을 순회)
    static void perm(int idx) {
        if (idx == N) {  // 순열이 완성되었을 때
            int resultFunc = func(); // 점수 계산
            if (resultFunc > 0) {
                win++;  // 규영이 승리
            } else if (resultFunc < 0) {
                lose++;  // 인영이 승리
            }
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = deck2[i];
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }

    // **승패 판별 함수**
    static int func() {
        int scoreKyu = 0;
        int scoreIn = 0;

        for (int i = 0; i < N; i++) {
            if (deck1[i] > result[i]) { 
                scoreKyu += deck1[i] + result[i];  // 규영이 승리한 경우 점수 증가
            } else { 
                scoreIn += deck1[i] + result[i];  // 인영이 승리한 경우 점수 증가
            }
        }

        return Integer.compare(scoreKyu, scoreIn);  // 1: 규영 승, -1: 인영 승, 0: 무승부
    }
	
	
	
	

}
