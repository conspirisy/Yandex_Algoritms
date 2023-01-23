package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class C {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer>[] result = new ArrayList[nm[0]];
            for (int i = 0; i < result.length; i++) {
                result[i] = new ArrayList<>();
            }
            boolean[] color = new boolean[nm[0]];
            for (int i = 0; i < nm[1]; i++) {
                int[] pair = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                result[pair[0] - 1].add(pair[1]);
                result[pair[1] - 1].add(pair[0]);
            }
            int s = Integer.parseInt(reader.readLine());
            StringBuilder output = new StringBuilder();
            mainDfs(result, color, s, output);
            System.out.println(output);
        }
    }

    public static void mainDfs(ArrayList<Integer>[] graf, boolean[] color, int s, StringBuilder output) {
        color[s-1] = true;
        output.append(s).append(" ");
        Collections.sort(graf[s - 1]);
        for (Integer v :
                graf[s - 1]) {
            if (!color[v - 1]) {
                mainDfs(graf, color, v, output);
            }
        }
    }
}
