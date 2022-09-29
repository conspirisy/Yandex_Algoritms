package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* https://contest.yandex.ru/contest/22450/run-report/70648191/
* */
public class FinalAClosestNull {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int streetLength = Integer.parseInt(reader.readLine());
            int[] street = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] range = new int[streetLength];
            int closestNullIndex = -1;
            for (int i = 0; i < streetLength; i++) {
                if (street[i] == 0) {
                    range[i] = 0;
                    closestNullIndex = i;
                } else {
                    range[i] = closestNullIndex == -1 ? -1 : i - closestNullIndex;
                }
            }
            closestNullIndex = -1;
            for (int i = streetLength - 1; i >= 0; i--) {
                if (street[i] == 0) {
                    closestNullIndex = i;
                } else {
                    if (closestNullIndex != -1) {
                        int dist = closestNullIndex - i;
                        range[i] = range[i] == -1 ? dist : Math.min(range[i], dist);
                    }
                }
            }
            System.out.println(
                    Arrays.toString(range)
                            .replaceAll("[,\\[\\]]", "")
            );
        }
    }
}
