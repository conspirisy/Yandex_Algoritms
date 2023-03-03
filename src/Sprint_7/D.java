package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

    public static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            long lhs = 1;
            long rhs = 1;
            for (int i = 0; i < n; i++) {
                long temp = rhs;
                rhs = lhs; lhs = temp;
                rhs = (rhs + lhs) % MOD;
            }
            System.out.println(lhs);
        }
    }
}
