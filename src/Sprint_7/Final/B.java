package Sprint_7.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://contest.yandex.ru/contest/25597/run-report/82403092/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Использован Псевдополиномиальный алгоритм
 * Алгоритм строит таблицу размера K/2*N, K - сумма значений, N - число элементов.
 * Значения в первой строке заполняются true.
 * Для каждой ячейки значение вычисляется
 * если (i-S[j-1]) >= 0 то P(i, j) ← P(i, j-1) или P(i-S[j-1], j-1), иначе P(i, j) ← P(i, j-1)
 * Когда вся таблица заполнена возвращаем DP[K/2][N]
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * В каждой яейке хранится булево значение, означающее можно ли собрать сумму в i строке из последовательности чисел в j столбце.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность равна O(K*N) (K - сумма элементов, N - число элементов)
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Таким образом требуется O(K*N) (K - сумма элементов, N - число элементов)
 * */
public class B {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(isSeparable(s) ? "True" : "False");
        }
    }

    public static boolean isSeparable(int[] s) {
        int n = s.length;
        if (Arrays.stream(s).sum() % 2 != 0) {
            return false;
        } else {
            int half = Arrays.stream(s).sum() / 2;
            boolean[][] dp = new boolean[half + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                dp[0][i] = true;
            }
            for (int i = 1; i <= half; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i - s[j - 1] >= 0) {
                        dp[i][j] = dp[i][j - 1] || dp[i - s[j - 1]][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[half][n];
        }
    }
}
