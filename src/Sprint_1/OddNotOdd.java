package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class OddNotOdd {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(input);
            int a = abs(Integer.parseInt(stringTokenizer.nextToken())) % 2;
            int b = abs(Integer.parseInt(stringTokenizer.nextToken())) % 2;
            int c = abs(Integer.parseInt(stringTokenizer.nextToken())) % 2;
            boolean isTheSame = a == b && a == c;
            System.out.println(isTheSame ? "WIN" : "FAIL");
        }
    }
}
