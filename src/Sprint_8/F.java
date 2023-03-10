package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class F {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String in = reader.readLine();
                if (map.containsKey(in)) {
                    map.replace(in, map.get(in) + 1);
                } else {
                    map.put(in, 1);
                }
            }
            ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
            entries.sort((e1, e2) -> {
                int res = Integer.compare(e2.getValue(), e1.getValue());
                return res != 0 ? res : e1.getKey().compareTo(e2.getKey());
            });
            System.out.println(entries.get(0).getKey());
        }
    }
}
