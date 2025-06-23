package Algorithm_Study.common.C20250625;

import java.util.*;

public class KMR0026 {

    static class Node {
        Node next;
        int value;

        public Node(Node next) {
            this.next = next;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }

    } // Node - 단방향 연결 리스트 구현

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();

            // 기본 암호문 입력
            Node head = new Node(null, sc.nextInt());
            Node pre = head;
            for (int i = 0; i < N - 1; i++) {
                Node node = new Node(null, sc.nextInt());
                pre.next = node;
                pre = node;
            }

            int M = sc.nextInt(); // 명령어 개수
            for (int m = 0; m < M; m++) {
                String command = sc.next();

                if(command.equals("I")) {
                    int position = sc.nextInt();
                    int num = sc.nextInt();

                    if(position == 0) { // 0번째 입력 : head가 바뀜 주의
                        Node after = head;
                        head = new Node(null, sc.nextInt());

                        Node cur = head;
                        for(int i = 0; i < num - 1; i++) {
                            Node node = new Node(null, sc.nextInt());
                            cur.next = node;
                            cur = node;
                        }
                        cur.next = after;

                    } else { // 0번째가 아닌 위치 입력
                        Node node1 = head;
                        for (int i = 0; i < position - 1; i++) {
                            node1 = node1.next;
                        }

                        // 해당 위치의 노드 next 값 기억 후 마지막에 할당
                        Node after = node1.next;
                        for (int i = 0; i < num; i++) {
                            Node node = new Node(null, sc.nextInt());
                            node1.next = node;
                            node1 = node;
                        }
                        node1.next = after;
                    }

                } else if(command.equals("D")) {
                    int position = sc.nextInt();
                    int num = sc.nextInt();

                    Node node1 = new Node(head);
                    for(int i = 0; i < position; i++) {
                        node1 = node1.next;
                    }

                    Node node2 = node1;
                    for(int i = 0; i < num + 1; i++) {
                        node2 = node2.next;
                        if (node2 == null) break; // 삭제 시 끝 노드가 null이면 멈춘다
                    }

                    node1.next = node2;

                    // 0번째부터 삭제 시 head가 바뀜
                    if(position == 0) {
                        head = node2;
                    }

                } else {
                    int num = sc.nextInt();

                    Node end = new Node(head);
                    while(end.next != null) {
                        end = end.next;
                    }

                    for (int i = 0; i < num; i++) {
                        Node node = new Node(null, sc.nextInt());
                        end.next = node;
                        end = node;
                    }

                } // if문
            } //while문

            System.out.printf("#%d ", tc);
            Node cur = head;
            for (int i = 0; i < 10; i++) {
                System.out.print(cur.value + " ");
                cur = cur.next;
            }
            System.out.println();
        } // tc
        sc.close();
    } // main
}