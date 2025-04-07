package Algorithm_Study.daily.CSY.March;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D20250302_큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){

            String command = sc.next();
            switch (command){
                case "push":
                    int val = sc.nextInt();
                    queue.add(val);
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.remove());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).peekLast());

            }


        }
    }
}

/*
* push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
* */

/*
*
* 15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front
* */