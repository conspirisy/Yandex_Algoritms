package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class L {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            HashSet<Integer>[] result = new HashSet[n];
            for (int i = 0; i < result.length; i++) {
                result[i] = new HashSet<>();
            }
            for (int i = 0; i < m; i++) {
                line = reader.readLine().split(" ");
                int f = Integer.parseInt(line[0]) - 1;
                int s = Integer.parseInt(line[1]) - 1;
                if (f != s) {
                    result[f].add(s);
                    result[s].add(f);
                }

            }
            String output = "YES";
            for (int i = 0; i < result.length; i++) {
                if (result[i].size() < n - 1) {
                    output = "NO";
                    break;
                }
            }
            System.out.println(output);
        }
    }
}
