package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            String[] s = input.split(" ");
            StringBuilder output = new StringBuilder(input.length());
            for (int i = s.length - 1; i >= 0 ; i--) {
                output.append(s[i]).append(" ");
            }
            System.out.println(output);
        }
    }
}
