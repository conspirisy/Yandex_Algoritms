package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class J {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long[] mas = new long[]{777836672, 900545483, 996739522, 998367896};
            System.out.println(mas[0] + mas[1] + mas[2] + mas[3]);
            int count = Integer.parseInt(reader.readLine());
            long target = Long.parseLong(reader.readLine());
            int[] array = count > 0 ? Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray() : new int[]{};
            List<int[]> result = new ArrayList<>();
            StringBuilder output = new StringBuilder();
            if (array.length < 4) {
                System.out.println("0");
            } else {
                HashMap<Long, List<int[]>> hashMap = new HashMap<>();
                hashMap.putIfAbsent((long)(array[0] + array[1]), new ArrayList<>(Arrays.asList(new int[]{array[0], array[1]})));
                for (int i = 2; i < array.length; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        long sum = target - array[i] - array[j];
                        int arg1 = array[i];
                        int arg2 = array[j];
                        if (hashMap.containsKey(sum)) {
                            hashMap.get(sum).forEach(arr -> result.add(new int[]{arr[0], arr[1], arg1, arg2}));
                        }
                    }
                    for (int j = 0; j < i; j++) {
                        long sum = array[i] + array[j];
                        if (hashMap.containsKey(sum)) {
                            hashMap.get(sum).add(new int[]{array[i], array[j]});
                        } else {
                            hashMap.put(sum, new ArrayList<>(Arrays.asList(new int[]{array[i], array[j]})));
                        }
                    }
                }
                Comparator<int[]> comparator = (o1, o2) -> {
                    for (int i = 0; i < o1.length; i++) {
                        if (o1[i] == o2[i]) continue;
                        if (o1[i] > o2[i]) return 1;
                        if (o1[i] < o2[i]) return -1;
                    }
                    return 0;
                };
                result.forEach(Arrays::sort);
                result.sort(comparator);
                List<String> res = result.stream()
                        .map(Arrays::toString).map(string -> string.replaceAll("[,\\[\\]]", ""))
                        .distinct().collect(Collectors.toList());
                output.append(res.size()).append("\n");
                res.forEach(string -> output.append(string).append("\n"));
                System.out.println(output);
            }
        }
    }
}
