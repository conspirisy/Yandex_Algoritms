package Sprint_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* https://contest.yandex.ru/contest/22450/run-report/70648197/
* */
public class FinalBLuckyHands {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            final int COUNT_PERSONS = 2;
            final int COUNT_SYMBOLS = 9;
            final int COUNT_LINES = 4;
            int pushAbility = Integer.parseInt(reader.readLine()) * COUNT_PERSONS;
            int[] countDigit = new int[COUNT_SYMBOLS];
            for (int i = 0; i < COUNT_LINES; i++) {
                for (char c : reader.readLine().toCharArray()) {
                    if (Character.isDigit(c)) {
                        countDigit[Integer.parseInt(String.valueOf(c)) - 1]++;
                    }
                }
            }
            int result = 0;
            for (int i : countDigit) {
                if (i > 0 && pushAbility >= i) result++;
            }
            System.out.println(result);
        }
    }
}
