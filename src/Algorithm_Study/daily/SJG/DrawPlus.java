class DrawPlus {
    public String[] solution(String[] picture, int k) {
        String[] result = new String[picture.length * k];
        int idx = 0;

        for (String row : picture) {
            StringBuilder expandedRow = new StringBuilder();
            for (char c : row.toCharArray()) {
                for (int i = 0; i < k; i++) {
                    expandedRow.append(c);
                }
            }
            
            String finalRow = expandedRow.toString();
            for (int i = 0; i < k; i++) {
                result[idx++] = finalRow;
            }
        }
        
        return result;
    }
}