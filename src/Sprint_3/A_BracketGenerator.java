package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_BracketGenerator {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            gen(n, n, "");
        }
    }
    public static void gen(int o, int c, String prefix) {
        if (o == 0 && c == 0) {
            System.out.println(prefix);
        }
        if (o > 0) {
            gen(o - 1, c, prefix + "(");
        }
        if (c > 0 && c > o) {
            gen(o, c - 1, prefix + ")");
        }
    }
}
