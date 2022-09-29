package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChaoticWeather {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] input = reader.readLine().split(" ");
            int result = 0;
            int prev;
            int next;
            boolean checkPrev;
            boolean checkNext;
            for (int i = 0; i < n; i++) {
                prev = i - 1;
                next = i + 1;
                if (prev >= 0) {
                    checkPrev = Integer.parseInt(input[i]) > Integer.parseInt(input[prev]);
                } else {
                    checkPrev = true;
                }
                if (next < n) {
                    checkNext = Integer.parseInt(input[i]) > Integer.parseInt(input[next]);
                } else {
                    checkNext = true;
                }
                if (checkPrev && checkNext) result++;
            }
            System.out.println(result);
        }
    }
}
