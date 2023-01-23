package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {

    public static Stack<Integer> stack = new Stack<>();
    public static int[] color;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer>[] result = new ArrayList[nm[0]];
            color = new int[nm[0]];
            for (int i = 0; i < result.length; i++) {
                result[i] = new ArrayList<>();
            }
            for (int i = 0; i < nm[1]; i++) {
                int[] pair = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                result[pair[0] - 1].add(pair[1]);
                result[pair[1] - 1].add(pair[0]);
            }
            StringBuilder output = new StringBuilder();
            mainTopSort(result);
            Map<Integer, List<Integer>> map = new HashMap<>();
            int maxColor = 0;
            for (int i = 0; i < color.length; i++) {
                maxColor = Math.max(maxColor, color[i]);
                if (map.containsKey(color[i])) {
                    map.get(color[i]).add(i + 1);
                } else {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(i + 1);
                    map.put(color[i], subList);
                }
            }
            output.append(map.keySet().size()).append("\n");
            for (int i = 1; i <= maxColor; i++) {
                for (Integer g: map.get(i)) {
                    output.append(g).append(" ");
                }
                output.append("\n");
            }
            System.out.println(output);
        }
    }

    public static void mainTopSort(ArrayList<Integer>[] graf) {
        int colorGroup = 0;
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0) {
                colorGroup++;
                topSort(graf, i + 1, colorGroup);
            }

        }
    }

    public static void topSort(ArrayList<Integer>[] graf, int s, int colorGroup) {
        color[s - 1] = colorGroup;
        if (graf[s - 1] != null) {
            for (Integer v : graf[s - 1]) {
                if (color[v - 1] == 0) {
                    topSort(graf, v, colorGroup);
                }
            }
        }
    }
}
