package Sprint_0;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovingAverage {
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
        List<Double> result = new ArrayList<>();
        double avgSum = 0;
        for (int i = 0; i < k; i++) {
            avgSum += arr.get(i);
        }
        result.add(avgSum/k);
        for (int i = 0; i < n - k; i++) {
            avgSum -= arr.get(i);
            avgSum += arr.get(i + k);
            result.add(avgSum/k);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (double i : result) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }
}
