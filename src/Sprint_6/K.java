package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = -1;
                }
            }
            for (int i = 0; i < m; i++) {
                line = reader.readLine().split(" ");
                int from = Integer.parseInt(line[0]) - 1;
                int to = Integer.parseInt(line[1]) - 1;
                int weight = Integer.parseInt(line[2]);
                dist[from][to] = dist[from][to] < 0 ? weight : Math.min(dist[from][to], weight);
                dist[to][from] = dist[to][from] < 0 ? weight : Math.min(dist[to][from], weight);
            }
            for (int i = 0; i < n; i++) {
                dist[i][i] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (dist[j][i] > 0 && dist[i][k] > 0) {
                            dist[j][k] = dist[j][k] == -1 ? dist[j][i] + dist[i][k] : Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                        }
                    }
                }
            }
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    output.append(dist[i][j]).append(" ");
                }
                output.append("\n");
            }
            System.out.println(output);
        }
    }
}
