package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J_LickedQueue {
    class Node<V> {
        public V value;
        public Node<V> prev;

        public Node(V value, Node<V> prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    private Node<Integer> head;
    private Node<Integer> tail;
    private int size;

    public void get() {
        if (size > 0) {
            System.out.println(head.value);
            var node = head;
            head = head.prev;
            node.prev = null;
            size--;
        } else {
            System.out.println("error");
        }
    }

    public void put(int x) {
        if (size > 0) {
            var node = new Node(x, null);
            tail.prev = node;
            tail = node;
        } else {
            head = tail = new Node<>(x, null);
        }
        size++;
    }

    public void size() {
        System.out.println(size);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int countCommands = Integer.parseInt(reader.readLine());
            J_LickedQueue queue = new J_LickedQueue();
            for (int i = 0; i < countCommands; i++) {
                String command = reader.readLine();
                if (command.startsWith("size")) {
                    queue.size();
                    continue;
                }
                if (command.startsWith("get")) {
                    queue.get();
                    continue;
                }
                if (command.startsWith("put")) {
                    queue.put(Integer.parseInt(command.replaceAll("put ", "")));
                }
            }
        }
    }
}
