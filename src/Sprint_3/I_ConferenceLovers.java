package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class I_ConferenceLovers {

    static class Node {
        String key;
        int count;

        public Node(String s, int i) {
            key = s;
            count = i;
        }

        @Override
        public String toString() {
            return key;
        }
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] array = reader.readLine().split(" ");
            int k = Integer.parseInt(reader.readLine());
            SortedMap<String, Node> map = new TreeMap<>();
            for (int i = 0; i < array.length; i++) {
                Node value = map.get(array[i]);
                if (value == null) {
                    map.put(array[i], new Node(array[i], 1));
                } else {
                    value.count++;
                }
            }
            map.values().stream().sorted((node1, node2) -> {
                if (node1.count > node2.count) {
                    return -1;
                } else if (node1.count < node2.count) {
                    return 1;
                } else {
                    return node1.key.compareTo(node2.key);
                }
            }).limit(k).forEach(node -> System.out.print(node + " "));
        }
    }
}
