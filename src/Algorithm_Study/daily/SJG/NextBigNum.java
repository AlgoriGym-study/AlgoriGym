class NextBigNum {
    public int solution(int n) {
        int origin = Integer.bitCount(n);
        
        while (true) {
            n++;

            if (Integer.bitCount(n) == origin) {
                return n;
            }
        }
    }
}