package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            int[] letters = new int[256];
            int result = 0;
            int start = 0;
            for (int i = 0; i < input.length(); i++) {
                start = Math.max(start, letters[input.charAt(i)]);
                letters[input.charAt(i)] = i + 1;
                result = Math.max(result, i + 1 - start);
            }
            System.out.println(result);
        }
    }
}
