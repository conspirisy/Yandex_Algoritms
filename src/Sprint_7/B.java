package Sprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class B {

    static class Lesson implements Comparable<Lesson> {

        double start;
        double end;

        public Lesson(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lesson o) {
            if (this.end == o.end) {
                return Double.compare(this.start, o.start);
            } else {
                return Double.compare(this.end, o.end);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<Lesson> lessons = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                double[] s = Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
                lessons.add(new Lesson(s[0], s[1]));
            }
            Collections.sort(lessons);
            Lesson prev = new Lesson(0, 0);
            StringBuilder output = new StringBuilder();
            DecimalFormat format = new DecimalFormat("0.##", new DecimalFormatSymbols(Locale.US));
            int count = 0;
            for (Lesson lesson : lessons) {
                if (lesson.start >= prev.end) {
                    prev = lesson;
                    count++;
                    output.append(format.format(prev.start)).append(" ").append(format.format(prev.end)).append("\n");
                }
            }
            System.out.println(count);
            System.out.println(output);
        }
    }
}
