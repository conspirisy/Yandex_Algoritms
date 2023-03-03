package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = 0;
            for (int i = 1; i < s.length; i++) {
                if (s[i] > s[i - 1]) {
                    max += s[i] - s[i - 1];
                }
            }
            System.out.println(max);
        }
    }
}
