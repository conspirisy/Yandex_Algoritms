package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Neighbor {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int countLines = Integer.parseInt(reader.readLine());
            int countColumns = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[countLines][countColumns];
            for (int i = 0; i < countLines; i++) {
                String input = reader.readLine();
                StringTokenizer stringTokenizer = new StringTokenizer(input);
                for (int j = 0; j < countColumns; j++) {
                    matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            int indexOfLine = Integer.parseInt(reader.readLine());
            int indexOfColumn = Integer.parseInt(reader.readLine());
            ArrayList<Integer> neighbours = new ArrayList<>();
            if (indexOfLine > 0) neighbours.add(matrix[indexOfLine - 1][indexOfColumn]);
            if (indexOfLine < countLines - 1) neighbours.add(matrix[indexOfLine + 1][indexOfColumn]);
            if (indexOfColumn > 0) neighbours.add(matrix[indexOfLine][indexOfColumn - 1]);
            if (indexOfColumn < countColumns - 1) neighbours.add(matrix[indexOfLine][indexOfColumn + 1]);
            Collections.sort(neighbours);
            StringBuilder result = new StringBuilder();
            for (int c : neighbours) {
                result.append(c).append(" ");
            }
            System.out.println(result.toString().trim());
        }
    }
}
