package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class F {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] second = reader.readLine().split(" ");
            HashMap<Long, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < second.length; i++) {
                long hash = getHash(second[i]);
                if (map.containsKey(hash)) {
                    map.get(hash).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(hash, list);
                }
            }
            map.values().stream().sorted((o1, o2) -> {
                if (Objects.equals(o1.get(0), o2.get(0))) return 0;
                return o1.get(0).compareTo(o2.get(0));
            }).forEach(list -> {
                list.stream().sorted().forEach(el -> System.out.print(el + " "));
                System.out.println("");
            });
        }
    }

    public static long getHash(String input) {
        long result = 1;
        for (int i = 0; i < input.length(); i++) {
            result = result * input.charAt(i) % 1000000007L;
        }
        return result * input.length();
    }
}
