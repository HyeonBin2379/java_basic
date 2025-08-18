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
        if (this.head == null) {
            this.head = new Node(data);
            return true;
        }

        Node findNode = this.head;
        while (true) {
            // 2. 트리에 저장된 노드가 존재
            // 2-1 현재 노드와 동일한 데이터
            if (findNode.value == data) {
                return false;
            }

            // 2-2 현재 노드의 왼쪽에 새로운 노드를 추가
            if (findNode.value < data) {
                if (findNode.left == null) {
                    findNode.left = new Node(data);
                    break;
                }
                findNode = findNode.left;
            }
            // 2-3 현재 노드의 오른쪽에 새로운 노드를 추가
            else {
                if (findNode.right == null) {
                    findNode.right = new Node(data);
                    break;
                }
                findNode = findNode.right;
            }
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
