package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class K {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] f = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = Integer.parseInt(reader.readLine());
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (f[i - 1] == s[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            ArrayList<Integer> res_f = new ArrayList<>();
            ArrayList<Integer> res_s = new ArrayList<>();
            int f_pos = n;
            int s_pos = m;
            while(f_pos > 0 && s_pos > 0) {
                if (f[f_pos - 1] == s[s_pos - 1]) {
                    res_s.add(s_pos);
                    res_f.add(f_pos);
                    s_pos--;
                    f_pos--;
                } else {
                    if (dp[f_pos - 1][s_pos] >= dp[f_pos][s_pos - 1]) {
                        f_pos--;
                    } else {
                        s_pos--;
                    }
                }
            }
            Collections.reverse(res_f);
            Collections.reverse(res_s);
            System.out.println(res_f.size());
            System.out.println(arrayToString(res_f));
            System.out.println(arrayToString(res_s));
        }
    }

    public static String arrayToString(ArrayList list) {
        StringBuilder builder = new StringBuilder();
        for (Object el:list) {
            builder.append(el).append(" ");
        }
        return builder.toString();
    }
}
