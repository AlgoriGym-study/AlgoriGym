package Algorithm_Study.common.C20250702;
import java.util.*;
// SWEA 암호문3
public class PJE0026{

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++){
       	int N = sc.nextInt();
        List<Integer> originalArr = new ArrayList<>(); //원본 뭉치 
        for(int i = 0; i < N; i++){
        	originalArr.add(sc.nextInt());
        }
        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            char ch = sc.next().charAt(0);
            switch(ch) {
                case 'I' :
                    int x = sc.nextInt(); //앞에서 부터 x번째 다음에
                    int y = sc.nextInt(); //y개의 암호문 삽입 
                    for(int j = 0; j < y; j++){
	                    int s = sc.nextInt(); //덧붙일 암호문 
                        originalArr.add( x+j , s);
                    }
                    break;
                case 'D' :
                    int x2 = sc.nextInt(); // 앞에서부터 x번째 다음 
                    int y2 = sc.nextInt(); // y개 삭제
                    for(int j = 0; j<y2; j++){
                        originalArr.remove(x2);
                    }
                    break;
                case 'A' :
                    int y3 = sc.nextInt(); // 맨뒤에 y개의 암호문 덧붙이기
                  	for(int j = 0; j < y3; j++){
                    	originalArr.add(sc.nextInt());
                    }
                    break;
            
            }
        
        }
    	    System.out.print("#"+tc+" ");
            for(int j = 0; j < 10; j++){
            	System.out.print(originalArr.get(j)+" ");
            }
            System.out.println();
        }
    

    }
}
