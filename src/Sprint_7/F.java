package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class F {

    public static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long[] steps = new long[s[0] + 1];
            steps[0] = 0;
            steps[1] = 1;
            for (int i = 2; i <= s[0]; i++) {
                long sum = 0;
                for (int j = 1; j <= s[1]; j++) {
                    if (i - j >= 0) {
                        sum = (sum + steps[i - j]) % MOD;
                    }
                }
                steps[i] = sum;
            }
            System.out.println(steps[s[0]]);
        }
    }
}
