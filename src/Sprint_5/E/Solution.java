package Sprint_5.E;

public class Solution {
    public static boolean treeSolution(Node head) {
        boolean result = true;
        if (head.left != null) {
            int max = getMax(head.left);
            result = head.value > max;
        }
        if (!result) {
            return result;
        }
        if (head.right != null) {
            int min = getMin(head.right);
            result = head.value < min;
        }
        if (result && head.left != null) {
            result = treeSolution(head.left);
        }
        if (result && head.right != null) {
            result = treeSolution(head.right);
        }
        return result;
    }

    public static int getMin(Node head) {
        int max = head.value;
        if (head.left == null && head.right == null) {
            return head.value;
        }
        if (head.left != null) {
            max = Math.min(max, getMin(head.left));
        }
        if (head.right != null) {
            max = Math.min(max, getMin(head.right));
        }
        return max;
    }

    public static int getMax(Node head) {
        int max = head.value;
        if (head.left == null && head.right == null) {
            return head.value;
        }
        if (head.left != null) {
            max = Math.max(max, getMax(head.left));
        }
        if (head.right != null) {
            max = Math.max(max, getMax(head.right));
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
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }
}
