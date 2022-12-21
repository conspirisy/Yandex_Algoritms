package Sprint_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class I {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> count = new ArrayList<>();
            count.add(0);
            gen(n, n, count);
            System.out.println(count.get(0));
        }
    }
    public static void gen(int o, int c, List<Integer> count) {
        if (o == 0 && c == 0) {
            count.set(0, count.get(0) + 1);
        }
        if (o > 0) {
            gen(o - 1, c, count);
        }
        if (c > 0 && c > o) {
            gen(o, c - 1, count);
        }
    }
}
