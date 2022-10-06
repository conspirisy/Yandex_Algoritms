package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_SubSeq {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(check(reader.readLine(), reader.readLine()));
        }
    }

    public static String check(String s, String t) {
        var result = true;
        var i = 0;
        var j = 0;
        while (result) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i >= s.length()) {
                    break;
                }
            }
            if (j < t.length() - 1) {
                j++;
            } else {
                result = false;
            }

        }
        return result ? "True" : "False";
    }
}
