package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class Factorization {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int input = Integer.parseInt(reader.readLine());
            StringBuilder result = new StringBuilder("");
            for (int i = 2; i * i <= input; i++) {
                if (input % i == 0) {
                    input = input / i;
                    result.append(i).append(" ");
                    i = 1;
                }
            }
            System.out.println(result.append(input).toString().trim());
        }
    }
}
