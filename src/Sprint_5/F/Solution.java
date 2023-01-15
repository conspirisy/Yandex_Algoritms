package Sprint_5.F;

public class Solution {
    public static int treeSolution(Node head) {
        return findDepth(head, 0);
    }

    public static int findDepth(Node head, int depth) {
        depth += 1;
        if (head.left == null && head.right == null) {
            return depth;
        }
        int leftDepth = depth;
        int rightDepth = depth;
        if (head.left != null) {
            leftDepth = findDepth(head.left, depth);
        }
        if (head.right != null) {
            rightDepth = findDepth(head.right, depth);
        }
        return Math.max(leftDepth, rightDepth);
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
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5) == 3;
    }
}
