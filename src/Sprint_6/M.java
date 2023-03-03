package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class M {

    public static int[] colors;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            LinkedList<Integer>[] result = new LinkedList[n];
            for (int i = 0; i < result.length; i++) {
                result[i] = new LinkedList<>();
            }
            colors = new int[n];
            for (int i = 0; i < m; i++) {
                line = reader.readLine().split(" ");
                int f = Integer.parseInt(line[0]) - 1;
                int s = Integer.parseInt(line[1]) - 1;
                result[f].add(s);
                result[s].add(f);
            }
            String output = "YES";
            for (int i = 0; i < result.length; i++) {
                if (!dfs(i, result, 1)) {
                    output = "NO";
                    break;
                }
            }
            System.out.println(output);
        }
    }

    public static boolean dfs(int from, LinkedList<Integer>[] graph, int color) {
        colors[from] = colors[from] == 0 ? color : colors[from];
        for (Integer i : graph[from]) {
            if (colors[i] == colors[from]) {
                return false;
            }
            if (colors[i] == 0) {
                if (!dfs(i, graph, 3 - color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
