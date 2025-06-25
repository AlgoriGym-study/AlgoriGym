package Algorithm_Study.common.C202506.C20250618;

class YHS0025_2 {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        for(int i=1;i<=n-4;i++){ // 첫번째 선택
            for(int j=i+1;j<=n-3;j++){ // 두번째 선택
                for(int k=j+1;k<=n-2;k++){ // 세번째 선택
                    for(int l=k+1;l<=n-1;l++){ // 네번째 선택
                        for(int m=l+1;m<=n;m++){ // 다섯번째 선택
                            boolean check = true;

                            // 검증
                            for(int o=0;o < q.length;o++) {
                                int matchCnt = 0;
                                for(int p=0;p < 5;p++) {
                                    if(matchCnt > ans[o]) break;
                                    if(   q[o][p] == i
                                            || q[o][p] == j
                                            || q[o][p] == k
                                            || q[o][p] == l
                                            || q[o][p] == m) matchCnt++;
                                }

                                if(ans[o] != matchCnt) {
                                    check = false;
                                    break;
                                }
                            }

                            if(check) answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
