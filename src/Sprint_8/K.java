package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String lhs = reader.readLine();
            String rhs = reader.readLine();
            int res = transform(lhs).compareTo(transform(rhs));
            System.out.println(res < 0 ? -1 : res > 0 ? 1 : res);
        }
    }

    public static String transform(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch:str.toCharArray()) {
            if (ch % 2 == 0) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
