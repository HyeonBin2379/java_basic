package java_advanced_01.day15.collection.linkedlistEx;

public class SingleLinkedListEx<T> {

    public Node<T> head;

    public class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }
        Node<T> node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<>(data);
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
            System.out.println();
        }
    }

    public Node<T> search(T data) {
        Node<T> node = this.head;
        while (node.next != null) {
            if (node.data.equals(data)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // 1,2,3 -> addNodeInside(5, 1) -> 1, 5, 2, 3
    public void addNodeInside(T data, T isData) {
        Node<T> target = search(isData);    // 타겟 노드 탐색

        // 새로운 노드를 타겟 노드의 다음 위치에 삽입
        if (target != null) {
            Node<T> newNode = new Node<>(data);
            newNode.next = target.next;
            target.next = newNode;
        }
    }

    public void deleteNode(T isData) {
        Node<T> curr = this.head;
        if (curr == null) {
            return;
        }

        // 삭제할 노드의 이전 노드 검색
        Node<T> prev = curr;
        while (curr.next != null) {
            if (curr.data.equals(isData)) {
                break;
            }
            // 탐색할 노드를 다음 노드로 갱신
            prev = curr;
            curr = curr.next;
        }

        // 노드 삭제
        if (curr != this.head) {
            prev.next = curr.next;  // 삭제할 대상이 첫번째 노드가 아님
        } else {
            this.head = curr.next;  // 삭제할 대상이 첫번째 노드 -> 헤드를 두번째 노드로 변경
        }
    }

    public static void main(String[] args) {
        SingleLinkedListEx<Integer> myLinkedList = new SingleLinkedListEx<>();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);
        myLinkedList.printAll();

        myLinkedList.addNodeInside(5, 1);
        myLinkedList.printAll();

        myLinkedList.deleteNode(5);
        myLinkedList.deleteNode(3);
        myLinkedList.deleteNode(4);
        myLinkedList.deleteNode(1);
        myLinkedList.printAll();
    }
}
