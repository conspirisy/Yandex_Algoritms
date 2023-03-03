package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int m = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());
            SortedMap<Integer, Integer> heaps = new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < n; i++) {
                int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (!heaps.containsKey(s[0])) {
                    heaps.put(s[0], s[1]);
                } else {
                    heaps.replace(s[0], heaps.get(s[0]) + s[1]);
                }
            }
            long result = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : heaps.entrySet()) {
                if (m >= integerIntegerEntry.getValue()) {
                    m -= integerIntegerEntry.getValue();
                    result += (long) integerIntegerEntry.getValue() * integerIntegerEntry.getKey();
                } else {
                    result += (long) m * integerIntegerEntry.getKey();
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
