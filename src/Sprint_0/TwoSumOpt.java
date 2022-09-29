package Sprint_0;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoSumOpt {
    public static void main(String[] args) throws IOException {
        int n;
        int k;
        List<Integer> arr;
        Set<Integer> previous = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            k = Integer.parseInt(reader.readLine().strip());
        }
        String result = "None";
        for (Integer el : arr) {
            int y = k - el;
            if (previous.contains(y)) {
                result = "" + y + " " + el;
                break;
            } else {
                previous.add(el);
            }
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(result);
        writer.flush();
    }
}
