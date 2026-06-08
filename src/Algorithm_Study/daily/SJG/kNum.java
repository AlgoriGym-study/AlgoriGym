class kNum {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int x = commands[i][0];
            int y = commands[i][1];
            int z = commands[i][2];

            int[] slicedArray = Arrays.copyOfRange(array, x - 1, y);
            
            Arrays.sort(slicedArray);
            
            answer[i] = slicedArray[z - 1];
        }
        
        return answer;
    }
}