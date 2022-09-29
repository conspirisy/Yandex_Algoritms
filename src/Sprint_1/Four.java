package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Four {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int input = Integer.parseInt(reader.readLine());
            boolean result = true;
            while (true) {
                if (input == 1) break;
                if (input % 4 != 0) {
                    result = false;
                    break;
                }
                input = input / 4;
            }
            System.out.println(result ? "True" : "False");
        }
    }
}
