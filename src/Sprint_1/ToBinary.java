package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToBinary {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int input = Integer.parseInt(reader.readLine());
            StringBuilder result = new StringBuilder("");
            while (input >= 2) {
                result.append(input % 2);
                input = input / 2;
            }
            result.append(input);
            System.out.println(result.reverse());
        }
    }
}
