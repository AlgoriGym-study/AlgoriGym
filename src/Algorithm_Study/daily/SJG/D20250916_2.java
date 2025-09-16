package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class D20250916_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        CQueue q = new CQueue();
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]) {
                case "push":
                    q.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    sb.append(q.pop()).append("\n");
                    break;
                case "size":
                    sb.append(q.getSize()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty()).append("\n");
                    break;
                case "front":
                    sb.append(q.getFront()).append("\n");
                    break;
                case "back":
                    sb.append(q.getBack()).append("\n");
                    break;
            }
        }
        br.close();
        System.out.print(sb);
    }
	public static class CQueue {
        int front;
        int back;
        private List<Integer> list = new LinkedList<>();
        
        public CQueue() {
            this.front = -1;
            this.back = -1;
        }
        
        public void push(int n) {
            if(front == -1) front++;
            list.add(n);
            back++;
        }
        
        public int pop() {
            if(isEmpty() == 1) return -1;
            int value = list.remove(0);
            back--;
            if(back < front) {
                front = -1;
                back = -1;
            }
            return value;
        }
        
        public int getFront() {
            if(isEmpty() == 1) return -1;
            return list.get(front);
        }
        
        public int getBack() {
            if(isEmpty() == 1) return -1;
            return list.get(back);
        }
        
        public int getSize() {
            return back + 1;
        }
        
        public int isEmpty() {
            return list.isEmpty() ? 1 : 0;
        }
    }
}
