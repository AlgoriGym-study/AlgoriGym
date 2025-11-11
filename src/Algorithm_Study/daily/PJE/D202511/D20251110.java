package Algorithm_Study.daily.PJE.D202511;

public class D20251110 {
    public int solution(int n, int w, int num) {
        // 총 행(층) 수
        int rows = (n + w - 1) / w;

        // 1) num의 위치 (row, col) 구하기
        int row = (num - 1) / w;
        int pos = (num - 1) % w;
        int col = (row % 2 == 0) ? pos : (w - 1 - pos);

        // 2) 같은 col에서 row ~ 최상단(rows-1)까지,
        //    실제 상자가 존재하는 칸의 개수를 센다 (num 포함)
        int count = 0;
        for (int r = row; r < rows; r++) {
            if (existsBoxAt(r, col, n, w)) count++;
        }
        return count;
    }

    // (r, c)에 실제 상자 번호가 존재하는지 판정
    // 지그재그 규칙을 그대로 역적용해 번호 k를 계산하고, 1..n 범위면 존재
    private boolean existsBoxAt(int r, int c, int n, int w) {
        int start = r * w + 1; // 해당 행의 시작 번호(왼→오 기준)
        int k = (r % 2 == 0) ? (start + c) : (start + (w - 1 - c));
        return 1 <= k && k <= n;
    }
}
