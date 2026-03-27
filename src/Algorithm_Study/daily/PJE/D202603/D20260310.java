package Algorithm_Study.daily.PJE.D202603;
public class D20260310 {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        // 각 파일 위치에서 가장 작은 x 좌표 가장 작은 y 좌표 / 가장 큰 x 좌표 가장 큰 y 좌표 구하기
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE; // 시작점
        int rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE; // 끝점
        
        for(int i = 0; i < wallpaper.length; i++){
            String[] arr = wallpaper[i].split("");
            
            for(int j = 0; j < arr.length; j++){
                if(arr[j].equals("#")){ // (i, j) (i+1,j+1) (i,j+1) (i+1, j+1) 이 각 꼭짓점임 
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }
        
        return new int []{lux,luy,rdx,rdy};
    }
}
