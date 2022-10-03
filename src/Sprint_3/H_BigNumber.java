package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H_BigNumber {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] array = reader.readLine().split(" ");
            sort(array);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
            }
        }
    }

    public static void sort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            var itemToInsert = array[i];
            var j = i;
            while (j > 0 && compare(itemToInsert, array[j-1])) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = itemToInsert;
        }
    }

    public static boolean compare(String first, String second) {
        return first.concat(second).compareTo(second.concat(first)) > 0;
    }
}
