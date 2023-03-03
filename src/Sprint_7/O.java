package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class O {

    public static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = s[0]; int m = s[1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph.get(s[0]).add(s[1]);
            }
            boolean[] visited = new boolean[n + 1];
            long[] dp = new long[n + 1];
            s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = s[0]; int to = s[1];
            dp[to] = 1;
            dfs(from, graph, visited, dp);
            System.out.println(dp[from]);
        }
    }

    public static void dfs(int from, ArrayList<ArrayList<Integer>> graph, boolean[] visited, long[] dp) {
        visited[from] = true;
        for (Integer to : graph.get(from)) {
            if (!visited[to]) {
                dfs(to, graph, visited, dp);
            }
            dp[from] += dp[to];
            dp[from] %= MOD;
        }
    }
}
