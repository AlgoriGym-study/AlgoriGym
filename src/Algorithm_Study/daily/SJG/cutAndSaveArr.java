class cutAndSaveArr {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length() + n - 1) / n];
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        int arrIdx = 0;
        
        for (char ch : my_str.toCharArray()) {
            sb.append(ch);
            idx++;
            
            if (idx == n) {
                answer[arrIdx++] = sb.toString();
                sb = new StringBuilder();
                idx = 0;
            }
        }
        
        if (sb.length() > 0) {
            answer[arrIdx] = sb.toString();
        }
        
        return answer;
    }
}