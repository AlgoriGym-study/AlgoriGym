package Algorithm_Study.common.C202506.C20250625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class SJG0026_2 {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int T = 10;  // 테스트 케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            // 원본 암호문 개수 읽기
            int N = Integer.parseInt(br.readLine());
            // 원본 암호문을 공백 기준으로 토크나이징
            StringTokenizer st = new StringTokenizer(br.readLine());
            CustomLinkedList list = new CustomLinkedList();
            // 리스트에 초기 암호문 추가
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            // 명령어 개수 읽기
            int M = Integer.parseInt(br.readLine());
            // 명령어 문자열 토크나이징
            st = new StringTokenizer(br.readLine());

            // 토큰이 남아있는 동안 명령 처리
            while (st.hasMoreTokens()) {
                String cmd = st.nextToken();
                if (cmd.equals("I")) {
                    // I x y s : x번째 뒤에 y개의 암호문 삽입
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    // x 위치로 이동하는 이터레이터 획득
                    ListIterator<Integer> it = list.listIterator(x);
                    for (int i = 0; i < y; i++) {
                        int v = Integer.parseInt(st.nextToken());
                        it.add(v);  // y개의 암호문 삽입
                    }
                } else if (cmd.equals("D")) {
                    // D x y : x번째 뒤부터 y개의 암호문 삭제
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    // x 위치로 이동하는 이터레이터 획득
                    ListIterator<Integer> it = list.listIterator(x);
                    for (int i = 0; i < y; i++) {
                        it.next();
                        it.remove();  // y개의 암호문 삭제
                    }
                } else if (cmd.equals("A")) {
                    // A y s : 마지막에 y개의 암호문 추가
                    int y = Integer.parseInt(st.nextToken());
                    // 리스트 끝 위치로 이동하는 이터레이터 획득
                    ListIterator<Integer> it = list.listIterator(list.size());
                    for (int i = 0; i < y; i++) {
                        int v = Integer.parseInt(st.nextToken());
                        it.add(v);  // y개의 암호문 추가
                    }
                }
            }

            // 결과 출력: #tc와 함께 앞 10개 암호문
            sb.append("#").append(tc);
            for (int i = 0, count = 0; i < list.size() && count < 10; i++, count++) {
                sb.append(' ').append(list.get(i));
            }
            sb.append("\n");
        }
        // 최종 결과 한 번에 출력
        System.out.print(sb);
    }
}

// 이중 연결 리스트와 ListIterator를 지원하는 CustomLinkedList
class CustomLinkedList {
    private Node head, tail;  // 리스트의 첫 노드와 마지막 노드
    private int size;         // 리스트의 크기

    // 리스트 크기 반환
    public int size() {
        return size;
    }

    // 리스트 마지막에 데이터 추가
    public void add(int data) {
        Node node = new Node(data);
        if (size == 0) {
            // 빈 리스트인 경우 head와 tail 모두 새 노드
            head = tail = node;
        } else {
            // 기존 tail 뒤에 새 노드 연결
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    // 특정 인덱스의 데이터를 순차 탐색으로 반환
    public int get(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    // 주어진 인덱스부터 순회 가능한 ListIterator 생성
    public ListIterator<Integer> listIterator(int startIndex) {
        return new CustomIterator(startIndex);
    }

    // 이중 연결 리스트의 노드 정의
    private class Node {
        int data;
        Node prev, next;  // 이전 노드와 다음 노드 참조
        Node(int d) { data = d; }
    }

    // ListIterator
    private class CustomIterator implements ListIterator<Integer> {
        private Node nextNode;     // 다음 next()에서 반환할 노드
        private Node lastReturned; // 마지막으로 반환된 노드
        private int nextIndex;     // nextNode의 인덱스

        // 생성자: 시작 인덱스로부터 커서 이동
        CustomIterator(int index) {
            nextNode = head;
            for (int i = 0; i < index && nextNode != null; i++) {
                nextNode = nextNode.next;
            }
            nextIndex = index;
        }

        // 다음 요소가 있는지 여부
        public boolean hasNext() {
            return nextNode != null;
        }

        // 다음 요소 반환 후 커서 이동
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = nextNode;
            nextNode = nextNode.next;
            nextIndex++;
            return lastReturned.data;
        }

        // 현재 커서 위치에 새 요소 추가
        public void add(Integer e) {
            // 추가 위치 기준으로 이전 노드와 다음 노드 연결 재설정
            Node pred = (nextNode == null) ? tail : nextNode.prev;
            Node newNode = new Node(e);
            newNode.prev = pred;
            newNode.next = nextNode;
            if (pred != null) pred.next = newNode;
            else head = newNode;
            if (nextNode != null) nextNode.prev = newNode;
            else tail = newNode;
            // 추가 후 상태 업데이트
            lastReturned = null;
            nextIndex++;
            size++;
        }

        // 마지막으로 반환된 노드를 리스트에서 제거
        public void remove() {
            if (lastReturned == null) throw new IllegalStateException();
            Node pred = lastReturned.prev;
            Node succ = lastReturned.next;
            if (pred != null) pred.next = succ;
            else head = succ;
            if (succ != null) succ.prev = pred;
            else tail = pred;
            // remove 후 커서와 인덱스 보정
            if (nextNode == lastReturned) {
                nextNode = succ;
            } else {
                nextIndex--;
            }
            lastReturned = null;
            size--;
        }

        // 지원하지 않는 기능은 예외 처리
        public boolean hasPrevious() { throw new UnsupportedOperationException(); }
        public Integer previous() { throw new UnsupportedOperationException(); }
        public int nextIndex() { return nextIndex; }
        public int previousIndex() { return nextIndex - 1; }
        public void set(Integer e) { throw new UnsupportedOperationException(); }
    }
}
