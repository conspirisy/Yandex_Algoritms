package Sprint_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G_Garderob {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] array = reader.readLine().split(" ");
            ArrayList<String> zero = new ArrayList<>();
            ArrayList<String> one = new ArrayList<>();
            ArrayList<String> two = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("0")) {
                    zero.add("0");
                } else if (array[i].equals("1")) {
                    one.add("1");
                } else if (array[i].equals("2")) {
                    two.add("2");
                }
            }
            zero.addAll(one);
            zero.addAll(two);
            System.out.println(
                    zero.toString()
                            .replaceAll("[,\\[\\]]", "")
            );

        }
    }
}
