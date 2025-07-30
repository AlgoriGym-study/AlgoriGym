package Algorithm_Study.common.C202507.C20250723;
import java.util.*;

// 백준 가운데를 말해요 복습
public class PJE0034_2{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정수개수
        
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((n1, n2) -> {
            return n2 - n1;
        });
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            // maxheap에 넣기  
            if(maxheap.isEmpty()||num<=maxheap.peek()){
                maxheap.offer(num);
            }else{
                minheap.offer(num);
            }
            
            // 균형맞추기 
            if(maxheap.size()>minheap.size()+1){
                minheap.offer(maxheap.poll());
            } else if (minheap.size() > maxheap.size()) {
                maxheap.offer(minheap.poll());
            }
            
            // 중간값 Stringbuilder에 넣기 
            sb.append(maxheap.peek()).append("\n");
        }
        // 출력
        System.out.println(sb);
        
    }
    
}
