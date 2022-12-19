package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String first = reader.readLine();
            String second = reader.readLine();
            boolean result = first.length() == second.length();
            int[] lettersOne = new int[256];
            int[] lettersTwo = new int[256];
            for (int i = 0; i < first.length() && result; i++) {
                if (!check(lettersOne, first.charAt(i), second.charAt(i))) {
                    result = false;
                    break;
                }
                if (!check(lettersTwo, second.charAt(i), first.charAt(i))) {
                    result = false;
                    break;
                }
            }
            System.out.println(result ? "YES" : "NO");
        }
    }

    public static boolean check(int[] letters, int index, int value) {
        if (letters[index] == 0) {
            letters[index] = value;
        }
        return letters[index] == value;
    }
}
