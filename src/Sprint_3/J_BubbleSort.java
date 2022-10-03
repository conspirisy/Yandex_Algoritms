package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J_BubbleSort {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sort(input);
        }
    }
    
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var f = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    var swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                    f = 1;
                }
            }
            if (f == 0) {
                if (i == 0) {
                    System.out.println(Arrays.toString(array).replaceAll("[,\\[\\]]", ""));
                }
                break;
            } else {
                System.out.println(Arrays.toString(array).replaceAll("[,\\[\\]]", ""));
            }
        }
        return array;
    }
}
