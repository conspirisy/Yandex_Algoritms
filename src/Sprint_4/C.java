package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

    long[] prefixes;
    long[] powers;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int base = Integer.parseInt(reader.readLine());
            int mod = Integer.parseInt(reader.readLine());
            String input = reader.readLine();
            C app = new C();
            app.prefixes = app.genPrefixes(input, base, mod);
            app.powers = app.genPowers(input, base, mod);
            int countQueries = Integer.parseInt(reader.readLine());
            for (int i = 0; i < countQueries; i++) {
                String[] indexes = reader.readLine().split(" ");
                System.out.println(app.getHash(app.prefixes, app.powers, Integer.parseInt(indexes[0]) - 1, Integer.parseInt(indexes[1]), mod));
            }
        }
    }

    public long[] genPrefixes(String input, int base, int mod) {
        long[] prefixes = new long[input.length() + 1];
        for (int i = 1; i <= input.length(); i++) {
            prefixes[i] = ((prefixes[i - 1] * base) % mod + input.charAt(i - 1)) % mod;
        }
        return prefixes;
    }

    public long[] genPowers(String input, int base, int mod) {
        long[] powers = new long[input.length() + 1];
        powers[0] = 1;
        for (int i = 1; i <= input.length(); i++) {
            powers[i] = (powers[i - 1] * base) % mod;
        }
        return powers;
    }

    public long getHash(long[] prefixes, long[] powers, int start, int end, int mod) {
        return (prefixes[end] + mod - (prefixes[start] * powers[end - start]) % mod) % mod;
    }
}
