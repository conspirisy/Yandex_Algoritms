package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {

    public static Queue<Integer> planned = new ArrayDeque<>(50000);
    public static byte[] color;
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]) + 1;
            int m = Integer.parseInt(line[1]);
            LinkedList<Integer>[] result = new LinkedList[n];
            color = new byte[n];
            distance = new int[n];
            for (int i = 0; i < m; i++) {
                line = reader.readLine().split(" ");
                int f = Integer.parseInt(line[0]);
                int s = Integer.parseInt(line[1]);
                if (result[f] == null) {
                    result[f] = new LinkedList<>();
                }
                result[f].add(s);
                if (result[s] == null) {
                    result[s] = new LinkedList<>();
                }
                result[s].add(f);
            }
            line = reader.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            System.out.println(n == m ? 0 : bfs(result, n, m));
        }
    }

    public static int bfs(LinkedList<Integer>[] graf, int s, int o) {
        planned.add(s);
        color[s] = 1;
        distance[s] = 0;
        while (!planned.isEmpty()) {
            int u = planned.poll();
            if (u == o) {
                return distance[u];
            }
            if (graf[u] != null) {
                for (int v: graf[u]) {
                    if (color[v] == 0) {
                        distance[v] = distance[u] + 1;
                        color[v] = 1;
                        planned.add(v);
                    }
                }
            }
        }
        return -1;
    }
}
