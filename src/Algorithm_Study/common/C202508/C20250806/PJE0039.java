package Algorithm_Study.common.C202508.C20250806;
import java.util.*;

// 백준 뱀 
public class PJE0039{
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 보드 크기 
        int K = sc.nextInt(); // 사과 개수 
        
        int[][] board = new int[N][N]; // 0 : 빈칸, 1: 사과
        
        for(int i = 0; i < K; i++){
            int r = sc.nextInt()-1; // 행
            int c = sc.nextInt()-1; // 열
            board[r][c] = 1; // 사과 표시 
        }
        
        int L = sc.nextInt(); // 방향 전환 횟수 
        Map<Integer,Character> dirChanges = new HashMap<>();
        for(int i = 0; i < L; i++){
            int X = sc.nextInt();        // X초 뒤
            char C = sc.next().charAt(0); // 'L' 또는 'D'
            dirChanges.put(X,C);
        }
        
        // 뱀의 몸을 큐로 관리(머리-> 꼬리)
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0,0}); // 시작 위치(1행 1열 -> 0,0)
        
        int time = 0; //시간
        int dir = 0; //초기 방향 : 오른쪽(0)
        int headX = 0, headY = 0;
        
        while(true){
            time++; 
            
            // 머리를 현재 방향으로 한칸 이동 
            headX += dx[dir];
            headY += dy[dir];
            
            // 1. 벽에 부딪히면 종료
            if(headX < 0 || headX >= N || headY < 0 || headY >= N)
                break;
            
            // 2. 자기몸과 부딪히면 종료
            for(int[] pos : snake){
                if(pos[0] == headX && pos[1] == headY){
                    // 새 머리 위치가 몸 일부와 겹침 
                    System.out.println(time);
                    return;
                }
            }
            
            // 3. 머리 위치 추가 
            snake.addFirst(new int[]{headX,headY});
            
            // 4. 사과가 있는지 확인 
            if(board[headX][headY] == 1){
                board[headX][headY] = 0; // 사과 먹기 
                //꼬리는 그대로 두어 길이 증가 
            } else {
                //사과가 없으면 꼬리 제거 
                snake.removeLast();
            }
            // 5. 방향전환 시간 확인 
            if(dirChanges.containsKey(time)){
                char turn = dirChanges.get(time);
                if(turn == 'L'){
                    dir = (dir+3)%4; // 왼쪽 회전 
                }else if(turn == 'D'){
                    dir = (dir+1)%4; // 오른쪽 회전 
                }
            }
        }
        //게임 종료 시간 출력 
        System.out.println(time);
    }
}
