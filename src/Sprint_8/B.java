package Sprint_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();

            if (Math.abs(s.length() - t.length()) >= 2) {
                System.out.println("FAIL");
            } else {
                System.out.println(getDistLevenstain(s, t) < 2 ? "OK" : "FAIL");
            }

        }
    }

    public static int getDistLevenstain(String str1, String str2) {
        int countColumns = Math.min(str1.length(), str2.length());
        int countLines = Math.max(str1.length(), str2.length());
        String shortest;
        String longest;
        if (str1.length() > str2.length()) {
            shortest = str2;
            longest = str1;
        } else {
            shortest = str1;
            longest = str2;
        }

        int[] currentRow = new int[countColumns + 1];
        int[] previousRow;
        for (int i = 0; i < currentRow.length; i++) {
            currentRow[i] = i;
        }

        for (int i = 1; i <= countLines; i++) {
            previousRow = Arrays.copyOf(currentRow, currentRow.length);
            currentRow = new int[countColumns + 1];
            currentRow[0] = i;

            for (int j = 1; j <= countColumns; j++) {
                int add = previousRow[j] + 1;
                int delete = currentRow[j - 1] + 1;
                int change = previousRow[j - 1];
                if (shortest.charAt(j - 1) != longest.charAt(i - 1)) {
                    change += 1;
                }
                currentRow[j] = Math.min(Math.min(add, delete), change);
            }
        }

        return currentRow[countColumns];
    }
}
