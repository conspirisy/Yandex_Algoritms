package Sprint_5.Final.Final_B;

/*
 * https://contest.yandex.ru/contest/24810/run-report/80435753/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Принцип работы заключается в том, чтобы найти удаляемый узел. Затем найти в одном из его поддеревьев замещающий узел.
 * Для левого поддерева нужно найти крайний правый узел, а для правого поддерева крайний левый узел.
 * Если у листа осталась ветка, нужно переместить на место листа корневой элемент этой ветки.
 * Самому листу присвоить потомков удаляемого узла. Если на удаляемый узел ссылался другой, то заменить ссылкой на перемещенный лист.
 * Если потомков у удаляемого узла нет, то просто удалить ссылку на него из родительского элемента.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Требование о сохранении свойств бинарного дерева поиска было соблюдено. Так как самая правая вершина из левого поддерева будет
 * меньше удалемого узла и больше всех узлов в левом поддереве. Аналогично для самого левого элемента из правого поддерева, он будет больше
 * удаляемого и меньше всех элементов из своего поддерева.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность O(h) h - высота дерева.
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Пространственная сложность O(1). Для всего алгоритма потребуются всего четыре дополнительных переменных для хранения ссылок на узлы.
 * */
public class Solution {

    private static Node findRightOfLeft(Node pParent, Node d) {
        Node p = d.getLeft();
        while (p.getRight() != null) {
            pParent = p;
            p = p.getRight();
        }
        if (pParent.getLeft() == p) {
            pParent.setLeft(p.getLeft());
        } else if (pParent.getRight() == p) {
            pParent.setRight(p.getLeft());
        }
        p.setLeft(null);
        return p;
    }

    private static Node findLeftOfRight(Node pParent, Node d) {
        Node p = d.getRight();
        while (p.getLeft() != null) {
            pParent = p;
            p = p.getLeft();
        }
        if (pParent.getLeft() == p) {
            pParent.setLeft(p.getRight());
        } else if (pParent.getRight() == p) {
            pParent.setRight(p.getRight());
        }
        p.setRight(null);
        return p;
    }
    public static Node remove(Node root, int key) {
        Node d = root;
        Node dParent = null;
        while (d != null && d.getValue() != key) {
            if (key < d.getValue()) {
                dParent = d;
                d = d.getLeft();
            } else {
                dParent = d;
                d = d.getRight();
            }
        }
        if (d == null) return root;
        Node p = null;
        Node pParent = d;
        if (d.getLeft() != null) {
            p = findRightOfLeft(pParent, d);
        } else if (d.getRight() != null) {
            p = findLeftOfRight(pParent, d);
        }
        if (p != null) {
            p.setLeft(d.getLeft());
            p.setRight(d.getRight());
        }
        if (dParent != null) {
            if (dParent.getLeft() == d) {
                dParent.setLeft(p);
            } else if (dParent.getRight() == d) {
                dParent.setRight(p);
            }
        } else {
            return p;
        }
        return root;
    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
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
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}