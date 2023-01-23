package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class H {

    public static int time = 0;
    public static int[] entry;
    public static int[] leave;
    public static byte[] color;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer>[] result = new ArrayList[nm[0]];
            for (int i = 0; i < result.length; i++) {
                result[i] = new ArrayList<>();
            }
            color = new byte[nm[0]];
            entry = new int[nm[0]];
            leave = new int[nm[0]];
            for (int i = 0; i < nm[1]; i++) {
                int[] pair = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                result[pair[0] - 1].add(pair[1]);
            }
            StringBuilder output = new StringBuilder();
            mainDfs(result, 1);
            for (int i = 0; i < entry.length; i++) {
                output.append(entry[i]).append(" ").append(leave[i]).append("\n");
            }
            System.out.println(output);
        }
    }

    public static void mainDfs(ArrayList<Integer>[] graf, int s) {
        entry[s-1] = time;
        time += 1;
        color[s-1] = 1;
        Collections.sort(graf[s - 1]);
        for (Integer v :
                graf[s - 1]) {
            if (color[v - 1] == 0) {
                mainDfs(graf, v);
            }
        }
        leave[s-1] = time;
        time += 1;
        color[s-1] = 2;
    }
}
