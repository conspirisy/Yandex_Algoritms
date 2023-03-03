package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class J {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (s[i] > s[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
            ArrayList<Integer> output = new ArrayList<>();
            int k = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (max == dp[i]) {
                    if (k == 0 || k >= s[i]) {
                        output.add(i + 1);
                        max--;
                    }
                    k = s[i];
                }
            }
            Collections.reverse(output);
            StringBuilder res = new StringBuilder();
            for (int i:output) {
                res.append(i).append(" ");
            }
            System.out.println(res);
        }
    }
}
