package Algorithm_Study.common.C20250417;

import java.io.*;

public class SJG {
  // 4방향 (하, 상, 좌, 우)
    private static final int[] DX = { 1, -1, 0, 0 };
    private static final int[] DY = { 0, 0, -1, 1 };
 
    // grid: 시뮬레이션 격자. true면 해당 칸에 셀이 존재함.
    // 격자 크기는 (K + N + K) x (K + M + K)로, 초기 셀 영역을 중앙에 두기 위해 K만큼 여유 공간을 둠.
    private static boolean[][] grid;
    // cells: 인덱스 1부터 10까지의 값으로, 각 생명력 값의 셀들을 연결 리스트로 관리
    private static Cell[] cells;
     
    // 시뮬레이션 파라미터 및 전체 셀 수 (살아있는 셀 수; 죽은 셀은 count에서 제외됨)
    private static int T, N, M, K, livingCount;
 
    // Cell 클래스: 각 셀의 위치, 원래 생명력(번식 시 해당 값을 사용), 현재 남은 생명 시간을 저장함.
    // 셀의 총 생명 시간은 원래 생명력의 2배(비활성 + 활성)로 설정됨.
    private static class Cell {
        int x, y;      // 격자 내 위치
        int life;      // 남은 생명 시간 (처음에는 originalLife * 2로 초기화됨)
        Cell next;     // 같은 원래 생명력을 가진 다음 셀
         
        Cell(int x, int y, int originalLife, Cell next) {
            this.x = x;
            this.y = y;
            // 총 생명 시간 = 원래 생명력 * 2 (비활성 기간: 원래 생명력, 활성 기간: 원래 생명력)
            this.life = originalLife << 1; // originalLife * 2
            this.next = next;
        }
    }
     
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 readInt() 메서드 사용
        T = readInt(); // 테스트 케이스 개수
         
        StringBuilder output = new StringBuilder();
        // 각 테스트 케이스 처리
        for (int tc = 1; tc <= T; tc++) {
            livingCount = 0;
            // cells 배열: 인덱스 1부터 10까지 사용 (생명력 0은 사용하지 않음)
            cells = new Cell[11];
            N = readInt(); // 초기 셀의 행 수
            M = readInt(); // 초기 셀의 열 수
            K = readInt(); // 시뮬레이션 시간 (시간 단위)
             
            // 격자 크기 설정: 입력 셀 영역의 양쪽에 K 칸씩 여유 공간 배정
            int gridRows = K + N + K;
            int gridCols = K + M + K;
            grid = new boolean[gridRows][gridCols];
             
            // 초기 셀 입력: 입력 영역을 중앙(K offset 적용)에 배치
            for (int x = K; x < N + K; x++) {
                for (int y = K; y < M + K; y++) {
                    int originalLife = readInt();
                    if (originalLife == 0) {
                        // 해당 칸에 셀이 없는 경우 건너뜀
                        continue;
                    }
                    // 해당 칸이 이미 사용되었음을 표시
                    grid[x][y] = true;
                    // 셀을 해당 생명력 연결 리스트의 head에 삽입 (prepending)
                    cells[originalLife] = new Cell(x, y, originalLife, cells[originalLife]);
                    livingCount++; // 살아있는 셀 수 증가
                }
            }
             
            // K시간 동안 시뮬레이션 진행
            while (K-- > 0) {
                // 생명력 큰 셀부터 번식하도록 10부터 1까지 처리
                for (int lifeValue = 10; lifeValue >= 1; lifeValue--) {
                    // 동일 생명력 값을 가진 셀들을 순회 (linked list 형태)
                    for (Cell cur = cells[lifeValue]; cur != null; cur = cur.next) {
                        // 만약 이미 셀이 죽었으면 (life == 0) 해당 생명력의 나머지 셀은 이미 처리된 것으로 간주
                        if (cur.life == 0) {
                            break;
                        }
                        // 시간 1 감소: 모든 셀은 매 시간마다 남은 생명 시간이 1씩 감소함
                        cur.life--;
                         
                        // 번식 조건: 
                        // - 셀이 막 비활성 상태에서 활성 상태로 전환되는 순간(비활성 기간이 끝난 직후)
                        //   이때는 원래 생명력 X에 대해 cur.life가 (X - 1)이 됨.
                        if (cur.life == lifeValue - 1) {
                            // 4방향 (상, 하, 좌, 우)으로 번식 시도
                            for (int d = 0; d < 4; d++) {
                                int newX = cur.x + DX[d];
                                int newY = cur.y + DY[d];
                                 
                                // 번식하려는 위치가 이미 셀이 있으면 번식하지 않음.
                                if (grid[newX][newY])
                                    continue;
                                // 해당 위치를 곧 셀이 차지하게 됨을 표시
                                grid[newX][newY] = true;
                                // 새로운 셀 생성: 새로운 셀의 원래 생명력은 cur의 원래 값(lifeValue)와 같음.
                                // 새 셀은 역시 총 생명 시간 = originalLife * 2로 초기화됨.
                                cells[lifeValue] = new Cell(newX, newY, lifeValue, cells[lifeValue]);
                                livingCount++; // 새로운 셀 생성으로 살아있는 셀 수 증가
                            }
                        }
                        // 셀의 남은 생명 시간이 0이 되면, 해당 셀은 죽은 것으로 간주되어 살아있는 셀 수 감소.
                        if (cur.life == 0) {
                            livingCount--;
                        }
                    }
                }
            }
            output.append("#").append(tc).append(" ").append(livingCount).append("\n");
        }
        System.out.print(output);
    }
     
    // 빠른 정수 입력 메서드
    private static int readInt() throws IOException {
        int n = 0;
        int c = System.in.read();
        // 공백(스페이스, 개행 등) 건너뛰기
        while (c <= ' ')
            c = System.in.read();
        // 숫자 문자를 읽어 정수로 변환 (유니코드 값 '0'을 빼서 정수값으로)
        while (c >= '0' && c <= '9') {
            n = n * 10 + (c - '0');
            c = System.in.read();
        }
        return n;
    }
}
