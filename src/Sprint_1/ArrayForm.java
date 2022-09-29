package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayForm {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String count = reader.readLine();
            int x = Integer.parseInt(reader.readLine().replaceAll(" ", ""));
            int k = Integer.parseInt(reader.readLine());
            char[] result = String.valueOf(x + k).toCharArray();
            StringBuilder arrayForm = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                arrayForm.append(result[i]).append(" ");
            }
            System.out.println(arrayForm.toString().trim());
        }
    }
}
