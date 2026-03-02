package Algorithm_Study.daily.PJE.D202603;
public class D20260302 {
    public int[][] solution(int n) {
        int[][] answer = new int [n][n];
        int num = 1; 
        int rowStart = 0, rowEnd = n-1;
        int colStart = 0, colEnd = n-1;
        while(num <= n*n){
            
            // right (row 고정, col 이동)
            for(int idx = colStart; idx <= colEnd; idx++){
                answer[rowStart][idx] = num++;
            }
            rowStart++; 
            
            // down (col 고정, row 이동)
            for(int idx = rowStart; idx <= rowEnd; idx++){
                answer[idx][colEnd] = num++;
            }
            colEnd--;
            
            // left (row 고정, col 이동)
            if(rowStart <= rowEnd){
                for(int idx = colEnd; idx >= colStart; idx--){
                    answer[rowEnd][idx] = num++;
                }
                rowEnd--;
            }
            
            // up (col 고정, row 이동)
            if(colStart <= colEnd){
                for(int idx = rowEnd; idx >= rowStart; idx--){
                    answer[idx][colStart] = num++;
                }
                colStart++;
            }
  
        }
        return answer;
    }
}
