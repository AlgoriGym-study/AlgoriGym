package Algorithm_Study.common.C202507.C20250702;

public class SJG0029 {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2;  // 숫자의 개수
        
        // 숫자만 추출하여 별도 배열에 저장 (접근 속도 향상)
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[2 * i]);
        }
        
        // 연산자만 추출하여 별도 배열에 저장
        char[] ops = new char[n - 1];
        for (int i = 0; i < n - 1; i++) {
            ops[i] = arr[2 * i + 1].charAt(0);
        }
        
        // DP 테이블 초기화
        // maxDP[i][j]: i번째부터 j번째 숫자까지의 최대값
        // minDP[i][j]: i번째부터 j번째 숫자까지의 최소값
        int[][] maxDP = new int[n][n];
        int[][] minDP = new int[n][n];
        
        // 기저 사례: 구간 길이가 1인 경우 (자기 자신)
        for (int i = 0; i < n; i++) {
            maxDP[i][i] = nums[i];
            minDP[i][i] = nums[i];
        }
        
        // 구간 길이를 2부터 n까지 증가시키며 DP 테이블 채우기
        // Bottom-up 방식으로 작은 구간부터 큰 구간으로 확장
        for (int len = 2; len <= n; len++) {           // 구간 길이
            for (int i = 0; i <= n - len; i++) {       // 시작 인덱스
                int j = i + len - 1;                   // 끝 인덱스
                
                // 최대/최소값 초기화
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;
                
                // 구간 [i, j]를 k 위치에서 분할하여 최적값 찾기
                // k는 연산자의 인덱스 (i부터 j-1까지)
                for (int k = i; k < j; k++) {
                    char op = ops[k];  // k번째 연산자
                    
                    // 왼쪽 구간: [i, k], 오른쪽 구간: [k+1, j]
                    int leftMax = maxDP[i][k];
                    int leftMin = minDP[i][k];
                    int rightMax = maxDP[k + 1][j];
                    int rightMin = minDP[k + 1][j];
                    
                    if (op == '+') {
                        // 덧셈의 경우: 최대 + 최대, 최소 + 최소
                        int maxResult = leftMax + rightMax;
                        int minResult = leftMin + rightMin;
                        
                        maxDP[i][j] = Math.max(maxDP[i][j], maxResult);
                        minDP[i][j] = Math.min(minDP[i][j], minResult);
                    } else { // op == '-'
                        // 뺄셈의 경우: 최대 - 최소, 최소 - 최대
                        int maxResult = leftMax - rightMin;
                        int minResult = leftMin - rightMax;
                        
                        maxDP[i][j] = Math.max(maxDP[i][j], maxResult);
                        minDP[i][j] = Math.min(minDP[i][j], minResult);
                    }
                }
            }
        }
        
        // 전체 구간 [0, n-1]의 최대값 반환
        return maxDP[0][n - 1];
    }
}
