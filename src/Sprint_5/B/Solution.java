package Sprint_5.B;

public class Solution {
    public static boolean treeSolution(Node head) {
        int leftDepth = head.left != null ? depth(head.left, 1) : 0;
        int rightDepth = head.right != null ? depth(head.right, 1) : 0;
        boolean result = Math.abs(rightDepth - leftDepth) <= 1;
        if (result) {
            if (head.left != null) {
                result = treeSolution(head.left);
            }
            if (result && head.right != null) {
                result = treeSolution(head.right);
            }
        }
        return result;
    }

    public static int depth(Node head, int cur) {
        int max = cur;
        if (head.left != null) {
            max = depth(head.left, cur + 1);
        }
        if (head.right != null) {
            max = Math.max(max, depth(head.right, cur + 1));
        }
        return max;
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
    }

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
    }
}
