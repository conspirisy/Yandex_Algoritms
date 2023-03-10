package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class E {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            ArrayList<Insertion> insertions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] in = reader.readLine().split(" ");
                insertions.add(new Insertion(Integer.parseInt(in[1]), in[0]));
            }
            insertions.sort(Comparator.comparingInt(Insertion::getPos));
            System.out.println(getString(s, insertions));
        }
    }

    static class Insertion {
        public int getPos() {
            return pos;
        }

        int pos;
        String value;

        public Insertion(int pos, String value) {
            this.pos = pos;
            this.value = value;
        }
    }

    public static String getString(String s, ArrayList<Insertion> insertions) {
        StringBuilder result = new StringBuilder();
        int current = 0;
        for (Insertion insertion: insertions) {
            while (current != insertion.pos) {
                result.append(s.charAt(current));
                current++;
            }
            if (current == insertion.pos) {
                result.append(insertion.value);
            }
        }
        for (int i = current; i < s.length(); i++) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
