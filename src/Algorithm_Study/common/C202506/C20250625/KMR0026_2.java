package Algorithm_Study.common.C202506.C20250625;

import java.util.Scanner;

public class KMR0026_2 {
    static int N;
    static int x;
    static int y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            SequentialList list = new SequentialList();
            N = sc.nextInt(); // 암호문 길이

            for (int i = 0; i < N; i++) {
                list.addLast(sc.nextInt());
            }// 암호문 입력

            int command = sc.nextInt(); // 명령어 개수
            for (int i = 0; i < command; i++) {
                String func = sc.next();
                x = sc.nextInt();

                if (func.equals("I")) {
                    y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        list.add(x + j, sc.nextInt()); // x 위치 = 해당 인덱스
                    }
                } else if (func.equals("D")) {
                    y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        list.remove(x); // x 위치 = 해당 인덱스
                    }
                } else {
                    for (int j = 0; j < x; j++) {
                        list.addLast(sc.nextInt());
                    }
                }

            }// 명령어

            System.out.printf("#%d ", tc);
            for (int i = 0; i < 10; i++) {
                System.out.print(list.remove() + " ");
            }
            System.out.println();
        } // tc
        sc.close();
    }// main

}

class Node {
    int data;
    Node link;

    Node(int data) {
        this.data = data;
    }
}

class SequentialList {
    Node head;
    int size;

    public SequentialList() {}

    public Node get(int idx) {
        if (idx >= size || idx < 0)
            return null;

        Node curr = head;
        for (int i = 0; i < idx; i++) { // 이동 수 = 원하는 위치 도달
            curr = curr.link;
        }
        return curr;
    }

    public void add(int idx, int data) {
        if (idx < 0 || idx > size)
            return;

        if (idx == 0 || size == 0) {
            addFirst(data);
            return;
        }

        if (idx == size) {
            addLast(data);
            return;
        }

        Node pre = get(idx - 1);
        Node node = new Node(data);
        node.link = pre.link;
        pre.link = node;
        size++;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        node.link = head;
        head = node;
        size++;
    }

    public void addLast(int data) {
        if (head == null) {
            addFirst(data);
            return;
        }

        Node node = new Node(data);
        Node postNode = get(size - 1);
        postNode.link = node;
        size++;
    }

    public int remove() {
        if (size <= 0) return -1;

        int data = head.data;
        head = head.link;
        size--;
        return data;
    }

    public int remove(int idx) {
        if (size <= 0) return -1;

        Node pre = get(idx - 1);
        int data = pre.link.data;
        pre.link = pre.link.link;
        size--;
        return data;
    }

}// LinkedList 클래스
