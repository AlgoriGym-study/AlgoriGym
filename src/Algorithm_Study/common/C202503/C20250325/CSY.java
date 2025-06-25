package Algorithm_Study.common.C202503.C20250325;

// 필요한 패키지 임포트
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSY {

    // 체스판 크기 및 각 기물 좌표, 이동 횟수, 정답 저장 변수
    static int N, M, K, Rr, Rc, Nr, Nc, answer;

    // 이미 방문한 위치 조합인지 체크하는 4차원 boolean 배열
    static boolean[][][][] count;

    // 룩의 4방향 이동 (우, 하, 좌, 상)
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    // 나이트의 8방향 이동
    static int[] Ndr = {1, 2, 2, 1,-1, -2, -2, -1};
    static int[] Ndc = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수
        String s = "";
        for (int tc = 1; tc <= T; tc++) {
            // 체스판 크기 및 이동 횟수 입력
            N = sc.nextInt(); // 행
            M = sc.nextInt(); // 열
            K = sc.nextInt(); // 총 이동 횟수 (룩 + 나이트 합쳐서)

            // 체스판을 읽으면서 룩(1)과 나이트(2) 위치 저장
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++){
                    int a = sc.nextInt();
                    if(a==1) { // 룩
                        Rr = r;
                        Rc = c;
                    }else if(a == 2) { // 나이트
                        Nr = r;
                        Nc = c;
                    }
                }
            }

            // 위치 방문 여부 배열 초기화
            count = new boolean[N][M][N][M];
            answer = 0;

            // 이동 시작 (백트래킹)
            move(0, Rr, Rc, Nr, Nc);

            s += "#" + tc + " " + answer + "\n";
        }
        System.out.println(s);
    }

    // 체스판 내 유효한 위치인지 확인하는 함수
    static boolean inBoard(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    // 현재 위치에서 이동을 수행하는 재귀 함수
    static void move(int level, int Rr, int Rc, int Nr, int Nc) {
        // 종료 조건: 이동 횟수가 K번이면 위치 저장 후 종료
        if(level == K) {
            if(!count[Rr][Rc][Nr][Nc]) {
//                printB(Rr, Rc, Nr, Nc); // 디버깅용 체스판 출력
                answer++;
                count[Rr][Rc][Nr][Nc] = true;
            }
            return;
        }

        // 룩의 이동: 4방향으로 직선 이동 가능
        for(int d = 0; d < 4; d++) {
            int rr = Rr + dr[d];
            int rc = Rc + dc[d];

            // 한 방향으로 계속 이동 (장애물 없으므로 끝까지 이동 가능)
            while(inBoard(rr, rc) && !(rr == Nr && rc == Nc)) {
                move(level+1, rr, rc, Nr, Nc); // 다음 위치에서 재귀 호출
                rr += dr[d];
                rc += dc[d];
            }
        }

        // 나이트의 이동: 8방향으로 'L자' 이동
        for(int d = 0; d < 8; d++) {
            int nr = Nr + Ndr[d];
            int nc = Nc + Ndc[d];
            if(inBoard(nr,nc) && !(nr == Rr && nc == Rc)) {
                move(level + 1, Rr, Rc, nr, nc); // 다음 위치에서 재귀 호출
            }
        }
    }

    // 디버깅용 체스판 출력 함수
    static void printB(int Rr, int Rc, int Nr, int Nc) {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if( r == Rr && c == Rc)
                    System.out.print("R"); // 룩
                else if(r == Nr && c == Nc)
                    System.out.print("N"); // 나이트
                else
                    System.out.print("."); // 빈칸
            }
            System.out.println();
        }
        System.out.println();
    }

}
