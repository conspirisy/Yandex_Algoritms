package Sprint_5.H;

public class Solution {

    public static int result = 0;
    public static int treeSolution(Node head) {
        findLeaf(head, "");
        return result;
    }

    public static void findLeaf(Node head, String str) {
        str = str + head.value;
        if (head.left == null && head.right == null) {
            result += Integer.parseInt(str);
            return;
        }

        if (head.left != null) {
            findLeaf(head.left, str);
        }
        if (head.right != null) {
            findLeaf(head.right, str);
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
        Node node1 = new Node(2, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(2, null, null);
        Node node5 = new Node(1, node4, node3);
        assert treeSolution(node5) == 275;
    }
}
