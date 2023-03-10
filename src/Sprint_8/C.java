package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class C {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();

            System.out.println(makePalindrome(s));
        }
    }

    private static String makePalindrome(String text) {
        TreeMap<Character, Integer> counter = new TreeMap<>();
        for (Character ch:text.toCharArray()) {
            if (counter.containsKey(ch)) {
                counter.put(ch, counter.get(ch) + 1);
            } else {
                counter.put(ch, 1);
            }
        }

        StringBuilder result = new StringBuilder();
        String center = "";
        for (Map.Entry<Character, Integer> entry: counter.entrySet()) {
            if (entry.getValue() % 2 != 0 && center.isEmpty()) {
                center = entry.getKey().toString();
            }
            for (int i = 0; i < entry.getValue()/2; i++) {
                result.append(entry.getKey());
            }
        }
        String left = result.toString();
        return left + center + result.reverse();
    }
}
