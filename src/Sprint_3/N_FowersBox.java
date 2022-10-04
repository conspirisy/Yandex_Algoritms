package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N_FowersBox {

    static class Node {
        public int x1;
        public int x2;

        public Node(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        public String toString() {
            return "" + x1 + " " + x2;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<Node> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                list.add(new Node(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
            }
            list.sort((Comparator.comparingInt(o -> o.x1)));
            for (int i = 1; i < n; i++) {
                var now = list.get(i);
                var prev = list.get(i - 1);
                if (now.x1 == prev.x2) {
                    now.x1 = prev.x1;
                    list.set(i - 1, null);
                    continue;
                }
                if (prev.x1 <= now.x1 && prev.x2 >= now.x1 && prev.x2 < now.x2) {
                    now.x1 = prev.x1;
                    list.set(i - 1, null);
                    continue;
                }
                if (prev.x1 <= now.x1 && prev.x2 >= now.x2) {
                    now.x1 = prev.x1;
                    now.x2 = prev.x2;
                    list.set(i - 1, null);
                    continue;
                }
                if (now.x1 == prev.x1 && now.x2 == prev.x1) {
                    list.set(i - 1, null);
                }
            }
            for (int i = 0; i < n; i++) {
                if (list.get(i) != null) {
                    System.out.println(list.get(i));
                }
            }
        }
    }
}
