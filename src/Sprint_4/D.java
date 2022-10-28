package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Set<String> k = new HashSet<>();
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String s = reader.readLine();
                if (!k.contains(s)) {
                    k.add(s);
                    list.add(s);
                }
            }
            list.forEach(System.out::println);
        }
    }
}
