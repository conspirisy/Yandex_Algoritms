package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class A {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer>[] result = new ArrayList[nm[0]];
            for (int i = 0; i < nm[1]; i++) {
                int[] pair = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (result[pair[0] - 1] == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(pair[1]);
                    result[pair[0] - 1] = list;
                } else {
                    result[pair[0] - 1].add(pair[1]);
                }
            }
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                if (result[i] != null) {
                    output.append(result[i].size()).append(" ");
                    result[i].stream().sorted().forEach(el -> output.append(el).append(" "));
                    output.append("\n");
                } else {
                    output.append(0).append("\n");
                }
            }
            System.out.println(output);
        }
    }
}
