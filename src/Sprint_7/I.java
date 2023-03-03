package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class I {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = s[0];
            int m = s[1];
            int[][] points = new int[n][m];
            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                for (int j = 0; j < m; j++) {
                    points[i][j] = line.charAt(j) % 48;
                }
            }
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int y = n - i - 1;
                    int x = j;

                    int down = 0;
                    if (y + 1 != n) {
                        down = dp[y + 1][x];
                    }

                    int left = 0;
                    if (x != 0) {
                        left = dp[y][x - 1];
                    }

                    dp[y][x] = Math.max(left, down) + points[y][x];
                }
            }
            System.out.println(dp[0][m - 1]);
            StringBuilder path = new StringBuilder();
            int y = 0;
            int x = m - 1;

            while (y != n || x != 0) {
                if (x == 0) {
                    path.append("U");
                    y++;
                    continue;
                }

                int down = 0;
                if (y + 1 < n) {
                    down = dp[y + 1][x];
                }

                int left = 0;
                if (x > 0) {
                    left = dp[y][x - 1];
                }

                if (down > left) {
                    y++;
                    path.append("U");
                } else {
                    x--;
                    path.append("R");
                }
            }
            path.deleteCharAt(path.length() - 1);
            System.out.println(path.reverse());

        }
    }
}
