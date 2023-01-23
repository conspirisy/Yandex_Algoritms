package Sprint_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class J {

    public static Stack<Integer> stack = new Stack<>();
    public static byte[] color;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer>[] result = new ArrayList[nm[0]];
            color = new byte[nm[0]];
            for (int i = 0; i < nm[1]; i++) {
                int[] pair = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (result[pair[0] - 1] == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(pair[1]);
                    result[pair[0] - 1] = list;
                } else {
                    result[pair[0] - 1].add(pair[1]);
                }
            }
            StringBuilder output = new StringBuilder();
            mainTopSort(result);
            while (!stack.empty()) {
                output.append(stack.pop()).append(" ");
            }
            System.out.println(output);
        }
    }

    public static void mainTopSort(ArrayList<Integer>[] graf) {
        for (int i = graf.length - 1; i >= 0; i--) {
            if (color[i] == 0) {
                topSort(graf, i + 1);
            }
        }
    }

    public static void topSort(ArrayList<Integer>[] graf, int s) {
        color[s-1] = 1;
        if (graf[s - 1] != null) {
            for (Integer v : graf[s - 1]) {
                if (color[v - 1] == 0) {
                    topSort(graf, v);
                }
            }
        }
        stack.push(s);
    }
}
