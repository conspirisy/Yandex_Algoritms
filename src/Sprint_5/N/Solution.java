package Sprint_5.N;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static List<Node> split(Node root, int k) {
        if (root == null) {
            return new ArrayList<>(Arrays.asList(null, null));
        }

        if (getSize(root.getLeft()) >= k) {
            List<Node> res = split(root.getLeft(), k);

            root.setLeft(res.get(1));
            root.setSize(getSize(res.get(0)));

            return new ArrayList<>(Arrays.asList(res.get(0), root));
        } else {
            List<Node> res = split(root.getRight(), k - getSize(root.getLeft()) - 1);

            root.setRight(res.get(0));
            root.setSize(getSize(res.get(1)));

            return new ArrayList<>(Arrays.asList(root, res.get(1)));
        }
    }

    public static int getSize(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.getSize();
        }
    }

    private static class Node {

        private Node left;
        private Node right;
        private int value;
        private int size;

        Node(Node left, Node right, int value, int size) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.size = size;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    public static void test() {
        Node node1 = new Node(null, null, 3, 1);
        Node node2 = new Node(null, node1, 2, 2);
        Node node3 = new Node(null, null, 8, 1);
        Node node4 = new Node(null, null, 11, 1);
        Node node5 = new Node(node3, node4, 10, 3);
        Node node6 = new Node(node2, node5, 5, 6);
        List<Node> res = split(node6, 4);
        assert res.get(0).getSize() == 4;
        assert res.get(1).getSize() == 2;
    }
}