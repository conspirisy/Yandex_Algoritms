package Sprint_2.C_FuckingWork;


class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {
    public static Node<String> solution(Node<String> head, int idx) {
        Node<String> resultHead = head;
        if (idx == 0) {
            resultHead = head.next;
            head.next = null;
            return resultHead;
        }
        Node<String> previous = head;
        while (idx != 0) {
            previous = head;
            head = head.next;
            idx--;
        }
        previous.next = head.next;
        head.next = null;
        return resultHead;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 1);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }
}
