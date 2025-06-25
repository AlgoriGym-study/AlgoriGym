package Algorithm_Study.common.C202506.C20250625;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG0026 {
    // N : 원본 암호문의 개수
    // M : 명령어의 개수
    // idx : 반복문에 사용할 인덱스
    static int N, M, idx;   
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            sb.append("#").append(test_case).append(" ");
            // 입력 받기
			N = Integer.parseInt(br.readLine());
            String[] originInput = br.readLine().split(" ");
            M = Integer.parseInt(br.readLine());
			String[] command = br.readLine().split(" ");
            
            // CustomLinkedList를 사용하여 원본 암호문 저장
            CustomLinkedList list = new CustomLinkedList();
            for(int i = 0; i < N; i++) list.add(Integer.parseInt(originInput[i]));
            
            idx = 0;
			while(idx < command.length) {
                // 명령어 처리
                // I: 삽입, D: 삭제, A: 추가
                if(command[idx].equals("I")) {
                    int x = Integer.parseInt(command[idx + 1]);
                    int y = Integer.parseInt(command[idx + 2]);
                    
                    // x 위치에 y개의 숫자를 삽입
                    for(int i = 0; i < y; i++) list.insert(x + i, Integer.parseInt(command[idx + 3 + i]));
                    // idx를 y + 3만큼 증가시켜 다음 명령어로 이동
                    idx += (y + 3);
                }
                else if(command[idx].equals("D")) {
                    int x = Integer.parseInt(command[idx + 1]);
                    int y = Integer.parseInt(command[idx + 2]);
                    
                    // x 위치에서 y개의 숫자를 삭제
                    for(int i = 0; i < y; i++) list.remove(x);
                    // idx를 3만큼 증가시켜 다음 명령어로 이동
                    idx += 3;
                }
                else if(command[idx].equals("A")) {
                    int y = Integer.parseInt(command[idx + 1]);
                     
                    // y개의 숫자를 추가
                    for(int i = 0; i < y; i++) list.add(Integer.parseInt(command[idx + 2 + i]));
                    // idx를 y + 2만큼 증가시켜 다음 명령어로 이동
                    idx += (y + 2);
                }
            }
            for(int i = 0; i < 10; i++) sb.append(list.get(i).data).append(" ");
            sb.append("\n");
		}
        System.out.print(sb);
		br.close();
	}
    
    public static class Node {
        public int data;
        public Node link;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    public static class CustomLinkedList {
        private Node head;
        private int size;
        
        // add
        // 리스트의 마지막에 데이터를 추가
        public void add(int data) {
            if(size == 0) {
				addFirst(data);
                return;
            }
            
			Node node = new Node(data);
            
            Node curr = head;
            while(curr.link != null) curr = curr.link;
            
            curr.link = node;
            size++;
        }
        
        // insert
        // idx 위치에 데이터를 삽입
        public void insert(int idx, int data) {
            if(idx < 0 || idx > size) return;
            if(idx == 0) {
                addFirst(data);
                return;
            }
            if(idx == size) {
                add(data);
                return;
            }
            
            Node pre = get(idx-1);
            Node node = new Node(data);
            
            node.link = pre.link;
            pre.link = node;
            
            size++;
        }
        
        // remove
        // idx 위치의 데이터를 삭제하고 해당 데이터를 반환
        public int remove(int idx) {
            if(idx == 0) {
                int data = head.data;
                head = head.link;
                size--;
                return data;
            }
            if(idx < 0 || idx > size) return -1;
            
            Node pre = get(idx-1);
            Node rm = pre.link;
            int data = rm.data;
            pre.link = rm.link;
            size --;
            
            return data;
        }
        
        // get
        // idx 위치의 노드를 반환
        public Node get(int idx) {
            if(idx < 0 || idx >= size) return null;
            
            Node curr = head;
            for(int i = 0; i < idx; i++) curr = curr.link;
            return curr;
        }
        
        // 0번째 노드에 데이터를 추가
        private void addFirst(int data) {
            Node node = new Node(data);
            
            node.link = head;
            head = node;
            size++;
        }
    }
}
