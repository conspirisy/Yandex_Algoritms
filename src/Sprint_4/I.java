package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class I {

    public static long MOD = 1000000007L;
    public static long BASE = 37;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] str1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = Integer.parseInt(reader.readLine());
            int[] str2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long[] pref1 = genPrefixes(str1, BASE, MOD);
            long[] pref2 = genPrefixes(str2, BASE, MOD);
            long[] powers1 = genPowers(str1, BASE, MOD);
            long[] powers2 = genPowers(str2, BASE, MOD);
            int maxLength = 0;
            int left = 1;
            int right = Math.min(n, m);
            while (left <= right) {
                int middle = (left + right) / 2;
                if (hasSame(pref1, pref2, powers1, powers2, middle)) {
                    maxLength = middle;
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            System.out.println(maxLength);
        }
    }

    public static boolean hasSame(long[] pref1, long[] pref2, long[] powers1, long[] powers2, int window) {
        Set<Long> hashes = new HashSet<>();
        for (int i = 1; i + window <= pref1.length; i++) {
            hashes.add(getHash(pref1, powers1, i - 1, i + window - 1, MOD));
        }

        for (int i = 1; i + window <= pref2.length; i++) {
            if (hashes.contains(getHash(pref2, powers2, i - 1, i + window - 1, MOD))) {
                return true;
            }
        }

        return false;
    }

    public static long getHash(long[] prefixes, long[] powers, int start, int end, long mod) {
        return (prefixes[end] + mod - (prefixes[start] * powers[end - start]) % mod) % mod;
    }

    public static long[] genPrefixes(int[] input, long base, long mod) {
        long[] prefixes = new long[input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            prefixes[i] = ((prefixes[i - 1] * base) % mod + input[i - 1]) % mod;
        }
        return prefixes;
    }

    public static long[] genPowers(int[] input, long base, long mod) {
        long[] powers = new long[input.length + 1];
        powers[0] = 1;
        for (int i = 1; i <= input.length; i++) {
            powers[i] = (powers[i - 1] * base) % mod;
        }
        return powers;
    }
}
