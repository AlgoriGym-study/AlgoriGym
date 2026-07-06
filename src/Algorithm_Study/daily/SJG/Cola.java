class Cola {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int x = n / a;
            int y = n % a;
            
            answer += (x * b);
            
            n = (x * b) + y; 
        }
        return answer;
    }
}