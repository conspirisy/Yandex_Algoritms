package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            String ss = reader.readLine();
            int[] template = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(search(data, template));
        }
    }

    public static boolean search(int[] data, int start, int[] template) {
        int shift = template[0] - data[start];
        for (int i = 0; i < template.length; i++) {
            if (data[start + i] != template[i] - shift) {
                return false;
            }
        }
        return true;
    }

    public static String search(int[] data, int[] template) {
        StringBuilder result = new StringBuilder();
        int size = data.length - template.length + 1;
        for (int i = 0; i < size; i++) {
            if (search(data, i, template)) {
                result.append(i + 1).append(" ");
            }
        }
        return result.toString();
    }
}
