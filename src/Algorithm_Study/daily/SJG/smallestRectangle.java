class smallestRectangle {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for (int[] card : sizes) {
            int length = Math.max(card[0], card[1]);
            int height = Math.min(card[0], card[1]);
            
            maxW = Math.max(maxW, length);
            maxH = Math.max(maxH, height);
        }
        
        return maxW * maxH;
    }
}