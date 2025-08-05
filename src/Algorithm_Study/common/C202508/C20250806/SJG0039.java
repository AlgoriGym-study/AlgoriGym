package Algorithm_Study.common.C202508.C20250806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SJG0039 {
    static int N, K, L;
    static boolean[][] apple;
    static Queue<int[]> directions;
    static Deque<int[]> snake;
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int currentDir = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        
        apple = new boolean[N+1][N+1];
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apple[x][y] = true;
        }
        
        L = Integer.parseInt(br.readLine());
        directions = new LinkedList<>();
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char turn = st.nextToken().charAt(0);
            directions.offer(new int[]{time, turn == 'L' ? -1 : 1}); // L:-1, D:1
        }
        
        snake = new ArrayDeque<>();
        snake.offer(new int[]{1, 1});
        
        System.out.println(simulate());
    }
    
    static int simulate() {
        int time = 0;
        
        while(true) {
            time++;
            
            int[] head = snake.peekFirst();
            int newX = head[0] + dx[currentDir];
            int newY = head[1] + dy[currentDir];
            
            if(newX < 1 || newX > N || newY < 1 || newY > N) {
                break;
            }
            
            for(int[] body : snake) {
                if(body[0] == newX && body[1] == newY) {
                    return time;
                }
            }
            
            snake.offerFirst(new int[]{newX, newY});
            
            if(apple[newX][newY]) {
                apple[newX][newY] = false;
            } else {
                snake.pollLast();
            }
            
            if(!directions.isEmpty() && directions.peek()[0] == time) {
                int turn = directions.poll()[1];
                currentDir = (currentDir + turn + 4) % 4;
            }
        }
        
        return time;
    }
}
