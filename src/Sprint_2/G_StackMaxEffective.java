package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G_StackMaxEffective {
    class Node<V> {
        public V value;
        public V prevMax;
        public Node<V> prev;

        public Node(V value, V prevMax, Node<V> prev) {
            this.value = value;
            this.prevMax = prevMax;
            this.prev = prev;
        }
    }

    Node<Integer> node;

    public void push(int x) {
        if (node == null) {
            node = new Node<>(x, x, null);
        } else {
            var prev = node;
            node = new Node<>(x, Math.max(prev.value, prev.prevMax), prev);
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
            System.out.println(Math.max(node.value, node.prevMax));
        }
    }

    public static void main(String[] args) throws IOException {
        G_StackMaxEffective stack = new G_StackMaxEffective();
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
