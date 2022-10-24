package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class M_Mediana {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            int[] north = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] south = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr = merge(north, south);
            double result = arr.length % 2 == 1 ? arr[arr.length/2] : (double)(arr[arr.length/2 - 1] + arr[arr.length/2])/2;
            NumberFormat nf = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
            System.out.println(nf.format(result));
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int k = 0;
        int[] arr = new int[left.length + right.length];
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                arr[k] = left[l];
                l++;
            } else {
                arr[k] = right[r];
                r++;
            }
            k++;
        }
        while (l < left.length) {
            arr[k] = left[l];
            l++;
            k++;
        }
        while (r < right.length) {
            arr[k] = right[r];
            r++;
            k++;
        }
        return arr;
    }
}
