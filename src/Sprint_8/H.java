package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String pattern = reader.readLine();
            String insertion = reader.readLine();
            System.out.println(s.replaceAll(pattern, insertion));
        }
    }

}
