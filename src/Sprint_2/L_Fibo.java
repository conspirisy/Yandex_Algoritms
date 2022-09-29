package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L_Fibo {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = reader.readLine().split(" ");
            System.out.println(fibonacci(Integer.parseInt(s[0]), Double.parseDouble(s[1])));
        }
    }
    public static long fibonacci(int n, Double k) {
        if (n == 0 || n == 1) return 1;
        long minusOne = 1;
        long minusTwo = 1;
        long sum = 0;
        long stepan = (long) Math.pow(10, k);
        for (int i = 2; i <= n; i++) {
            double moded = minusTwo % stepan;
            sum = minusOne + (long) moded;
            minusOne = (long) moded;
            minusTwo = sum;
        }
        return sum % stepan;
    }
}
