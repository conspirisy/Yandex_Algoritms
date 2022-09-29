package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F_StackMax {

    class Node<V> {
        public V value;
        public Node<V> prev;

        public Node(V value, Node<V> prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    Node<Integer> node;

    public void push(int x) {
        if (node == null) {
            node = new Node<>(x, null);
        } else {
            var prev = node;
            node = new Node<>(x, prev);
        }
    }

    public void pop() {
        if (node == null) {
            System.out.println("error");
        } else {
            node = node.prev;
        }
    }

    public void get_max() {
        if (node == null) {
            System.out.println("None");
        } else {
            int max = node.value;
            var prev = node.prev;
            while (prev != null) {
                max = Math.max(max, prev.value);
                prev = prev.prev;
            }
            System.out.println(max);
        }
    }

    public static void main(String[] args) throws IOException {
        F_StackMax stack = new F_StackMax();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String command = reader.readLine();
                if ("get_max".equals(command)) {
                    stack.get_max();
                    continue;
                }
                if ("pop".equals(command)) {
                    stack.pop();
                    continue;
                }
                if (command.startsWith("push")) {
                    stack.push(Integer.parseInt(command.replaceAll("push ", "")));
                }
            }
        }
    }
}
