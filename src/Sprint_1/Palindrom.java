package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrom {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            char[] chars = input.toLowerCase().replaceAll("\\W", "").toCharArray();
            boolean result = chars.length == 1;
            for (int i = 0; i <= chars.length / 2 - 1; i++) {
                if (chars[i] == chars[chars.length - 1 - i]) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
            System.out.println(result ? "True" : "False");
        }
    }
}
