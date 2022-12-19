package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class А {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long a = Long.parseLong(reader.readLine());
            long m = Long.parseLong(reader.readLine());
            char[] s = reader.readLine().toCharArray();
            long result = 0;
            for (int i = 0; i < s.length; i++) {
                result = ((result * a)%m + s[i])%m;
            }
            System.out.println(result);
        }
    }
}
