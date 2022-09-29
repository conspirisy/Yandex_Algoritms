package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class L_TwoBikes {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String countDays = reader.readLine();
            int[] stat = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int price = Integer.parseInt(reader.readLine());
            StringBuilder result = new StringBuilder();
            result.append(find(stat, price, 0, stat.length, -1));
            result.append(" ");
            result.append(find(stat, price * 2, 0, stat.length, -1));
            System.out.println(result);
        }
    }

    public static int find(int[] arr, int x, int left, int right, int first) {
        if (right <= left) return first == -1 ? first : first + 1;
        var mid = (right + left) / 2;
        if (arr[mid] >= x) first = mid;
        if (x <= arr[mid]) {
            return find(arr, x, left, mid, first);
        } else {
            return find(arr, x, mid + 1, right, first);
        }
    }
}
