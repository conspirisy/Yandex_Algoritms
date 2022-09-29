package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Matrix {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int stringCount = Integer.parseInt(reader.readLine());
            int columnCount = Integer.parseInt(reader.readLine());
            String[][] matrix = new String[stringCount][columnCount];
            for (int i = 0; i < stringCount; i++) {
                String[] line = reader.readLine().split(" ");
                for (int j = 0; j < columnCount; j++) {
                    matrix[i][j] = line[j];
                }
            }
            for (int i = 0; i < columnCount; i++) {
                StringBuilder lineToPrint = new StringBuilder();
                for (int j = 0; j < stringCount; j++) {
                    lineToPrint.append(matrix[j][i]).append(" ");
                }
                System.out.println(lineToPrint.toString().trim());
            }
        }
    }
}
