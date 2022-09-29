package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySum {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] one = new StringBuilder(reader.readLine()).reverse().toString().toCharArray();
            char[] two = new StringBuilder(reader.readLine()).reverse().toString().toCharArray();
            if (one.length > two.length) {
                two = Arrays.copyOf(two, one.length);
            } else {
                one = Arrays.copyOf(one, two.length);
            }
            char inMind = '0';
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < one.length; i++) {
                char a;
                char b;
                if ((int)one[i] == 0) {
                    a = inMind;
                    inMind = '0';
                } else {
                    a = one[i];
                }
                if ((int)two[i] == 0) {
                    b = inMind;
                    inMind = '0';
                } else {
                    b = two[i];
                }
                if (a == b) {
                    if ('0' == inMind) {
                        result.append("0");
                    } else {
                        result.append("1");
                    }
                    if (a == '1') {
                        inMind = '1';
                    } else {
                        inMind = '0';
                    }
                } else {
                    if ('1' == inMind) {
                        result.append("0");
                    } else {
                        result.append("1");
                    }
                }
            }
            if (inMind == '1') {
                result.append("1");
            }
            System.out.println(result.reverse());
        }
    }
}
