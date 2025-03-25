package Algorithm_Study.daily.LYW;

import java.util.Scanner;
 
public class D2025_03_24_SWEA_상원이의_생일파티 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int[][] adjArr = new int[N+1][N+1];
             
            boolean yn = false; // 상원이 친구 유무
            // 배열에 친구 관계 값 넣기, 상원이(1)가 나오는지 안나오는지 확인
            for(int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                 
                adjArr[a][b] = 1;
                adjArr[b][a] = 1;
                 
                if(a == 1 || b == 1) yn = true; // 상원이 친구 관계가 있다.
                 
            }
             
            // yn == false -> 상원이는 친구와 관계가 없다는 것 이므로 답은 0이 된다.
            if(yn == false) {
                System.out.println("#" + tc + " " + 0);
            }
            // 친구관계가 있는 경우 -> 바로 친구인 경우와 친구의 친구를 찾는 경우 2가지로 나누어 판별한다
            else {
                int cnt = 0;
                boolean[] visited = new boolean[N+1];
                for(int i = 2; i <= N; i++) {
                	// 상원이의 친구 찾기
                    if(adjArr[1][i] == 1) {
                        if(visited[i] != true) {
                            visited[i] = true;
                            cnt++;
                        }
                        // 상원이의 친구의 친구 찾기
                        for(int j = 2; j <= N; j++) {
                            if(adjArr[i][j] == 1 && visited[j] != true && j != 1) {
                                visited[j] = true;
                                cnt++;
                            }
                        }
                    }
                }
                System.out.println("#" + tc + " " + cnt);
            }
             
             
        }
    }
}