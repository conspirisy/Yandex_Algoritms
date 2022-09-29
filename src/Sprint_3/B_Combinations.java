package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Combinations {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String seq = reader.readLine();
            gen(seq, "");
        }
    }
    private static String[][] keyBoard = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
            {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
    public static void gen(String seq, String prefix) {
        if (seq.length() == 0) {
            System.out.print(prefix + " ");
        } else {
            for (String symbol: keyBoard[Integer.parseInt(seq.substring(0, 1))]) {
                gen(seq.substring(1), prefix + symbol);
            }
        }
    }
}
