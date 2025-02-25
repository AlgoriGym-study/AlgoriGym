package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class D2025_02_24_10814_나이순_정렬 {
	public static void main(String[] args) throws Exception {
		// 입력 버퍼
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        // 우선순위 큐로 정렬
        Queue<Person> pq = new PriorityQueue<>((Person p1, Person p2) -> {
            if(p1.age == p2.age) return p1.id - p2.id;
            return p1.age - p2.age;
        });
        
        // 입력값 큐에 추가
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            pq.offer(new Person(input[1], Integer.parseInt(input[0])));
        }
        br.close();
        
        // 큐가 비어있지 않다면 큐 내부에서 정렬된 값들을 기준에 따라 출력
        while(!pq.isEmpty()) { 
        	sb.append(pq.peek().age).append(" ").append(pq.peek().name).append("\n"); 
        	pq.poll();
        }
        System.out.print(sb);
    }
    
	// Person 객체 생성
    public static class Person {
    	// 생성 순서 정렬을 위한 static 변수 생성
        static int sequence = 0;
        int id;
        String name;
        int age;
        
        public Person() {
            this.id = sequence++;
        }
        public Person(String name, int age) {
            this.id = sequence++;
            this.name = name;
            this.age = age;
        }
    }
}