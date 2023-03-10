package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            System.out.println(getRepeat(s));
        }
    }

    public static int[] kmp(String str) {
        int[] pi = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            int j = pi[i - 1];
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    public static int getRepeat(String str) {
        int[] pi = kmp(str);
        return str.length() / (str.length() - pi[pi.length - 1]);
    }
}
