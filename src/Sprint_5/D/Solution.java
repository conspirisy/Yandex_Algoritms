package Sprint_5.D;

public class Solution {
    public static boolean treeSolution(Node head1, Node head2) {
        return isEqual(head1, head2);
    }

    public static boolean isEqual(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.value == right.value) {
            return isEqual(left.left, right.left) && isEqual(left.right, right.right);
        } else {
            return false;
        }
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(1, null, null);
        Node node5 = new Node(2, null, null);
        Node node6 = new Node(3, node4, node5);
        assert treeSolution(node3, node6);
    }
}