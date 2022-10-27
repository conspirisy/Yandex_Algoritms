package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class M_Mediana {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            String[] north = reader.readLine().split(" ");
            String[] south = reader.readLine().split(" ");
            String[] arr = merge(north, south);
            double result = arr.length % 2 == 1 ? Integer.parseInt(arr[arr.length/2])
                    : (double)(Integer.parseInt(arr[arr.length/2 - 1]) + Integer.parseInt(arr[arr.length/2]))/2;
            NumberFormat nf = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
            System.out.println(nf.format(result));
        }
    }

    public static String[] merge(String[] left, String[] right) {
        int l = 0;
        int r = 0;
        int k = 0;
        String[] arr = new String[left.length + right.length];
        while (l < left.length && r < right.length) {
            if (left[l].compareTo(right[r]) <= 0) {
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
