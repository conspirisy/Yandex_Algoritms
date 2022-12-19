package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String input = reader.readLine();
            int[] r = input.isBlank() ? new int[0] : Arrays.stream(input.split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int result = 0;
            for (int i = 0; i < r.length; i++) {
                if (r[i] == 0) {
                    sum -= 1;
                } else {
                    sum += 1;
                }
                if (sum == 0) {
                    result = i + 1;
                } else if (map.containsKey(sum)) {
                    result = Math.max(result, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
            System.out.println(result);
        }
    }
}
