package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class TheMostLongString {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            String input = reader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(input);
            int maxLength = 0;
            String longestWord = "";
            for (Iterator<Object> it = stringTokenizer.asIterator(); it.hasNext(); ) {
                String word = (String) it.next();
                if (word.length() > maxLength) {
                    maxLength = word.length();
                    longestWord = word;
                }
            }
            System.out.println(longestWord);
            System.out.println(maxLength);
        }
    }
}
