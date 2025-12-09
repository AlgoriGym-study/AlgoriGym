package Algorithm_Study.daily.LYW;

public class D2025_12_04 {
    public int solution(int n, int w, int num) {
        int rows = (n + w - 1) / w;

        int row = (num - 1) / w;
        int pos = (num - 1) % w;
        int col = (row % 2 == 0) ? pos : (w - 1 - pos);

        int count = 0;
        for (int r = row; r < rows; r++) {
            if (existsBoxAt(r, col, n, w)) count++;
        }
        return count;
    }

    private boolean existsBoxAt(int r, int c, int n, int w) {
        int start = r * w + 1; 
        int k = (r % 2 == 0) ? (start + c) : (start + (w - 1 - c));
        return 1 <= k && k <= n;
    }
}
