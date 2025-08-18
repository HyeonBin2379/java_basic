package java_advanced_01.day15.collection.treeEx.bst;

public class NodeMgmt {

    private Node head;  // 시작(루트) 노드의 주소값을 저장

    // 노드 클래스 생성
    public class Node {
        Node left, right;   // 왼쪽, 오른쪽 브랜치 -> 연결된 노드의 주소값을 저장
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int data) {
        // 1. 트리의 노드가 0개일 때 -> 추가해야 할 노드가 루트 노드
        System.out.println("newData = " + data);
        if (this.head == null) {
            this.head = new Node(data);
            System.out.println("headNode = " + data);
            return true;
        }

        // 2. 트리에 노드가 1개라도 존재
        Node curr = this.head;
        while (true) {
            System.out.println("curr = " + curr.value);
            if (curr.left == null || curr.right == null) {
                break;
            }

            if (data < curr.value) {
                curr = curr.left;
                System.out.println("curr = " + curr.value);
            } else if (data > curr.value) {
                curr = curr.right;
                System.out.println("curr = " + curr.value);
            } else {
                return false;
            }
        }

        if (curr.left == null) {
            curr.left = new Node(data);
            System.out.println("curr.left = " + curr.left.value);
        } else {
            curr.right = new Node(data);
            System.out.println("curr.right = " + curr.right.value);
        }
        return true;
    }

    public static void main(String[] args) {
        NodeMgmt tree = new NodeMgmt();
        tree.insert(60);
        tree.insert(30);
        tree.insert(70);
        tree.insert(40);
    }
}
