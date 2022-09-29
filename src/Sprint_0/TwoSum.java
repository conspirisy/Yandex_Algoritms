package Sprint_0;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) throws IOException {
        int n;
        int k;
        List<Integer> arr;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            k = Integer.parseInt(reader.readLine().strip());
        }
        String result = "none";
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i) + arr.get(j) == k) {
                    result = "" + arr.get(i) + " " + arr.get(j);
                    break;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(result);
        writer.flush();
    }
}
