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
        System.out.println("data = " + data);
        if (this.head == null) {
            this.head = new Node(data);
            System.out.println("headNode = " + data);
            return true;
        }

        // 2. 트리에 저장된 노드가 존재
        Node findNode = this.head;
        while (true) {
            if (findNode.left == null) {
                System.out.println("parentNode = " + findNode.value);
                findNode.left = new Node(data);
                break;
            } else if (findNode.right == null) {
                System.out.println("parentNode = " + findNode.value);
                findNode.right = new Node(data);
                break;
            }

            // 현재 노드에 새로운 노드를 추가
            if (data < findNode.value) {
                findNode = findNode.left;
            } else if (data > findNode.value) {
                findNode = findNode.right;
            } else {
                return false;
            }
        }
        System.out.println("newNode = " + data);
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
