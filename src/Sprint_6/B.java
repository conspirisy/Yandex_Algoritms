package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] result = new int[nm[0]][nm[0]];
            for (int i = 0; i < nm[1]; i++) {
                int[] pair = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                result[pair[0] - 1][pair[1] - 1] = 1;
            }
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    output.append(result[i][j]).append(" ");
                }
                output.append("\n");
            }
            System.out.println(output);
        }
    }
}
