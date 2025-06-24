package Algorithm_Study.common.C20250625;

import java.util.*;
// SWEA 암호문3
class PJE0026 {
    static final int NODE_MAX = 5000;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class MyLinkedList {
        Node head;
        Node tail;
        Node[] nodeArr = new Node[NODE_MAX];
        int nodeCnt = 0;

        Node getNewNode(int data) {
            nodeArr[nodeCnt] = new Node(data);
            return nodeArr[nodeCnt++];
        }
// idx 다음으로 nums 추가하기
        void insert(int idx, int[] nums) { 
            int st = 0;
            if(idx == 0) {  // 맨 앞에 붙이는 경우
                // 한 개만 추가하고 head 재조정
                if (head != null) { 
                    Node newNode = getNewNode(nums[0]);
                    newNode.next = head;
                    head = newNode;
                } else {
                    head = getNewNode(nums[0]);
                }
                
                // 남은 수들을 head 뒤에 차례로 이어 붙이기
                idx = 1;
                st = 1;
            }
            
            Node cur = head;
            // idx개 만큼 이동하기
            for(int i=1; i<idx; i++) {
                cur = cur.next;
            }
            // nums 추가하기
            for(int i=st; i<nums.length; i++) {
                Node newNode = getNewNode(nums[i]);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = newNode;
            }
            if (cur.next == null) {
                tail = cur;
            }
        }
		// idx 뒤로 cnt만큼의 숫자들 삭제하기
        void delete(int idx, int cnt) { 
            Node cur = head;
            if(idx == 0) {  // 맨 앞이 삭제되는 경우
                for(int i=0; i<cnt; i++) {
                    cur = cur.next;
                }
                head = cur;
                return;
            }
            // idx개 만큼 이동하기
            for(int i=1; i<idx; i++) {
                cur = cur.next;
            }
            Node anchor = cur;  // 삭제되기 직전 위치 기억하기
            for(int i=0; i<cnt; i++) {
                cur = cur.next;
            }
            anchor.next = cur.next;
            
            if (anchor.next == null) {
                tail = anchor;
            }
        }
        
        // 맨뒤에 이어붙이기
        void add(int data) {
            Node newNode = getNewNode(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        void print() {
            Node cur = head;
            int cnt = 10;
            while (cnt > 0 && cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
                cnt--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            MyLinkedList list = new MyLinkedList();

            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }

            int M = sc.nextInt();
            for (int i = 0; i < M; i++ ) {
                String cmd = sc.next();
                if (cmd.equals("I")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    int[] nums = new int[y];
                    for (int j = 0; j < y; j++) {
                        nums[j] = sc.nextInt();
                    }
                    list.insert(x, nums);
                    
                } else if (cmd.equals("D")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    list.delete(x, y);
                    
                } else if (cmd.equals("A")) {
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        list.add(sc.nextInt());
                    }
                    
                }
            }

            System.out.print("#" + tc + " ");
            list.print();
            System.out.println();
        }
    }
}
