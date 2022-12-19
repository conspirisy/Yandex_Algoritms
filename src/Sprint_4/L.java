package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class L {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] nk = reader.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String input = reader.readLine();
            long base = 31;
            long mod = 100000000000000007L;
            long hash = genHash(input.substring(0, n), base, mod);
            long power = genPower(n, base, mod);
            HashMap<Long, Integer> counter = new HashMap<>();
            HashMap<Long, Integer> position = new HashMap<>();
            ArrayList<Integer> result = new ArrayList<>();
            counter.put(hash, 1);
            position.put(hash, 0);
            for (int i = 1; i + n - 1 < input.length(); i++) {
                hash = (hash + mod - input.charAt(i - 1) * power % mod) % mod;
                hash = (hash * base % mod + input.charAt(i + n - 1)) % mod;
                int count = counter.getOrDefault(hash, 0);
                if (count == 0) {
                    counter.put(hash, 1);
                } else {
                    counter.replace(hash, count + 1);
                }

                if (counter.getOrDefault(hash, 0) == 1) {
                    position.put(hash, i);
                }

                if (counter.getOrDefault(hash, 0) == k) {
                    result.add(position.get(hash));
                }
            }
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                output.append(result.get(i)).append(" ");
            }
            System.out.println(output);
        }
    }

    public static long genHash(String input, long base, long mod) {
        long hash = 0;
        for (int i = 0; i < input.length(); i++) {
            hash = ((hash * base) % mod + input.charAt(i)) % mod;
        }
        return hash;
    }

    public static long genPower(int n, long base, long mod) {
        long power = 1;
        for (int i = 1; i < n; i++) {
            power = (power * base) % mod;
        }
        return power;
    }
}
