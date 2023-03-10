package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();

            if (Math.abs(s.length() - t.length()) >= 2) {
                System.out.println("FAIL");
            } else {
                System.out.println(oneEdit(s, t) ? "OK" : "FAIL");
            }

        }
    }

    public static boolean oneEdit(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        if (str1.length() > str2.length()) {
            return oneEdit(str2, str1);
        }
        int lhsPos = 0;
        int rhsPos = 0;
        boolean oneEdit = false;
        while (lhsPos < str1.length() && rhsPos < str2.length()) {
            if (str1.charAt(lhsPos) != str2.charAt(rhsPos)) {
                if (oneEdit) {
                    return false;
                }
                oneEdit = true;
                if (str1.length() == str2.length()) {
                    lhsPos++;
                }
            } else {
                lhsPos++;
            }
            rhsPos++;
        }
        return true;
    }
}
