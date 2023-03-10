package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class D {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int s = Integer.parseInt(reader.readLine());
            ArrayList<String> words = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                words.add(reader.readLine());
            }
            words.sort(Comparator.comparingInt(String::length));
            System.out.println(getMaxPrefixLength(words));
        }
    }

    public static int getMaxPrefixLength(ArrayList<String> words) {
        if (words.isEmpty()) return 0;

        String firstWord = words.get(0);
        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 1; j < words.size(); j++) {
                if (i == words.get(j).length()) {
                    return i;
                }

                if (words.get(j).charAt(i) != firstWord.charAt(i)) {
                    return i;
                }
            }
        }

        return firstWord.length();
    }
}
