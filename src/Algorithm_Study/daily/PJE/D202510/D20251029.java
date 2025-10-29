package Algorithm_Study.daily.PJE.D202510;
public class D20251029 {
    /**
     * n  : 전체 상자 수 (1..n)
     * w  : 가로(한 층) 상자 수
     * num: 꺼내려는 상자 번호
     * 반환: num을 포함해 꺼내야 하는 상자 총 개수
     */
    public int solution(int n, int w, int num) {
        
        // 실제 2차원 배열을 만들 필요 없이, 수학적으로 행/열 좌표만 계산한다. (최적화)

        // 전체 행 수 R = ceil(n / w)
        int R = (n + w - 1) / w;

        // num의 행 r (1-base, 아래에서부터 ↑)
        int r = (num - 1) / w + 1;

        // 해당 행에서의 순서 t (1..w)
        int t = (num - 1) % w + 1;

        // 지그재그 규칙으로 열 c만 산출한다.
        // 행이 홀수면 왼→오, 짝수면 오→왼
        int c;
        if ((r % 2) == 1) {        // 홀수 행: 왼→오
            c = t;
        } else {                   // 짝수 행: 오→왼
            c = w - t + 1;
        }

        // --- 3. 구하고자 하는 num값을 배열에서 찾고 해당 행을 저장한다 (사용자 아이디어)
        // r, c 를 이미 계산했으므로, r(행) 정보를 보유.

        // --- 4. (수정 핵심) '해당 행의 맨끝열이 0인지'가 아니라
        //       'num과 같은 열 c에, 최상단 행에 실제 상자가 존재하는지'를 확인해야 한다.
        //
        // 위층에 있는 상자 수 = (최상단까지의 행 수) - (num 이 있는 행) = R - r
        int boxesAbove = R - r;

        // 최상단 행의 실제 상자 개수 k (마지막 행이 꽉 차지 않았을 수 있음)
        int k = n - (R - 1) * w;
        if (k == 0) k = w;  // 딱 맞게 떨어지면 최상단도 w개로 가득 참

        // 최상단 행이 부분만 채워진 경우(k < w)에만,
        // 그 '빈 부분'에 열 c가 해당되면 위층(최상단)에는 상자가 없으므로 1개 덜 뺀다.
        if (boxesAbove > 0 && k < w) {
            boolean topRowIsOdd = (R % 2) == 1; // 최상단 행의 진행 방향: R의 홀짝과 동일
            boolean topHasBoxAtC;
            if (topRowIsOdd) {
                // 홀수행(왼→오): 채워진 열 = 1..k
                topHasBoxAtC = (1 <= c && c <= k);
            } else {
                // 짝수행(오→왼): 채워진 열 = w-k+1 .. w
                topHasBoxAtC = (w - k + 1 <= c && c <= w);
            }
            if (!topHasBoxAtC) {
                // 같은 열 c에 최상단 상자가 존재하지 않으므로,
                // '위층' 하나(최상단)는 사실상 꺼낼 필요가 없다.
                boxesAbove -= 1;
            }
        }

        // 자신 포함
        return boxesAbove + 1;
    }

}
