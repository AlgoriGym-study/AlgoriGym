package Algorithm_Study.common.C202502.C20250228;

import java.io.*;

public class SJG {
	public static void main(String[] args) throws Exception {
				// 입력을 받기 위해 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());
        
				// 테스트케이스 만큼 반복
        for(int tc = 1; tc <= T; tc++) {
            // N*N 2차원 배열의 크기
            int N = Integer.parseInt(br.readLine());
            // N*N의 2차원 배열 생성
            int[][] field = new int[N][N];
            
            for(int i = 0; i < N; i++) {
                // 한 줄씩 입력받음
                String[] input = br.readLine().split(" ");
                // BufferedReader는 문자열 형식으로만 입력받을 수 있으므로 한줄 씩 입력받은 값을 정수형으로 형변환 하여 정수형 2차원 배열 `field`에 할당해준다.
                for(int j = 0; j < N; j++) field[i][j] = Integer.parseInt(input[j]);
            }
                
            // 공이 한번도 못 구르면 0번이기 때문에 변수 max의 값을 0으로 할당(최소 반환 가능 값)
            int max = 0;
            // 델타 배열 - 상, 우, 하, 좌
            int[] dr = { -1, 0, 1, 0 };
            int[] dc = { 0, 1, 0, -1 };
            
            // 완전탐색
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    // 공이 구를 수 있는 횟수를 카운팅할 변수 cnt 선언
                    int cnt = 0;
                    // 현재 좌표가 지속적으로 변화 해야하므로 변수 r, c 선언
                    int r = i;
                    int c = j;
                    
                    // 델타배열을 탐색할 값
                    int nr = 0;
                    int nc = 0;
                    while(true) {
                        // 최소값이 갱신되었을 때 이동 좌표로 사용할 변수 nnr과 nnc 선언
                        int nnr = r;
                        int nnc = c;
                        // 현재 탐색 구역의 값을 변수 curr로 선언
                        int curr = field[r][c];
                        // curr보다 작은 값들을 찾아야하기 때문에 변수 min을 curr값으로 할당
                        int min = curr;
                        // 최소값이 갱신되었는지 체크하는 변수 check 선언
                        boolean check = false;
                        for(int k = 0; k < 4; k++) {
                            // 델타 배열을 순회하며 다음 순회할 인덱스를 갱신
                            nr = r + dr[k];
                            nc = c + dc[k];
                            // 해당 인덱스를 정상적으로 순회할 수 없는 경우 다음 델타배열의 인덱스 탐색을 위해 continue
                            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                            // 최소값이 갱신된다면 최소값 및 다음 이동해야할 좌표 nnr과 nnc 갱신 후 check를 true로 재할당
                            if(min > field[nr][nc]) {
                                min = field[nr][nc];
                                nnr = nr;
                                nnc = nc;
                                check = true;
                            }
                        }
                        
                        // check가 true 일때 공을 굴릴 수 있으므로 cnt + 1을 해주고 해당 인덱스를 r 과 c에 재할당 
                        if(check) {
                            cnt++;
                            r = nnr;
                            c = nnc;
                        } else break;    // 공이 더 이상 움직일 수 없는 경우 while문 종료.
                    }
                    // 최대값이 갱신되었다면 해당 값으로 재할당
                    max = (max < cnt) ? cnt : max;
                }
            }
            
            // 해당 테스트케이스에서 공이 구를 수 있는 최대횟수를 StringBuilder객체에 추가
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
