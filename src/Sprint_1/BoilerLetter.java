package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoilerLetter {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] a = reader.readLine().toCharArray();
            char[] b = reader.readLine().toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            char[] longest = a.length > b.length ? a : b;
            char[] shortest = a.length < b.length ? a : b;
            String wrongSymbol = "";
            for (int i = 0; i < longest.length - 1; i++) {
                if (shortest[i] != longest[i]) {
                    wrongSymbol = String.valueOf(longest[i]);
                    break;
                }
            }
            if (wrongSymbol.isBlank()) {
                wrongSymbol = String.valueOf(longest[longest.length - 1]);
            }
            System.out.println(wrongSymbol);

        }
    }
}
