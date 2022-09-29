package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I_SizedQueue {

    private int[] queue;
    private int maxSize;
    private int head;
    private int tail;
    private int size;

    public I_SizedQueue (int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        head = tail = 0;
    }

    public void push(int x) {
        if (size < maxSize) {
            queue[tail] = x;
            tail = (tail + 1) % maxSize;
            size++;
        } else {
            System.out.println("error");
        }
    }

    public int size() {
        return size;
    }

    public void peek() {
        if (size > 0) {
            System.out.println(queue[head]);
        } else {
            System.out.println("None");
        }
    }

    public void pop() {
        if (size > 0) {
            System.out.println(queue[head]);
            head = (head + 1) % maxSize;
            size--;
        } else {
            System.out.println("None");
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int countCommands = Integer.parseInt(reader.readLine());
            int maxSize = Integer.parseInt(reader.readLine());
            I_SizedQueue queue = new I_SizedQueue(maxSize);
            for (int i = 0; i < countCommands; i++) {
                String command = reader.readLine();
                if (command.startsWith("peek")) {
                    queue.peek();
                    continue;
                }
                if (command.startsWith("size")) {
                    System.out.println(queue.size());
                    continue;
                }
                if (command.startsWith("pop")) {
                    queue.pop();
                    continue;
                }
                if (command.startsWith("push")) {
                    queue.push(Integer.parseInt(command.replaceAll("push ", "")));
                }
            }
        }
    }
}
