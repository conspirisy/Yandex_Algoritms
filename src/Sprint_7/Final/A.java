package Sprint_7.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://contest.yandex.ru/contest/25597/run-report/82463926/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Использован алгоритм Вагнера-Фишера.
 * Составляется матрица размером (M + 1)*(N + 1) (M - длина первой строки, N - длина второй строки)
 * Первая строка заполняется порядковыми числами от 0 до N.
 * Первый столбец заполняется порядковыми числами от 0 до M.
 * Для всех остальных ячеек используется формула min(D(i,j-1)+1, D(i-1,j)+1, D(i-1,j-1) + m(S[i],T[j])).
 * Где m(S[i],T[j]) = 1, если символы S[i] T[j] не равный друг другу, и m(S[i],T[j]) = 0, если равны.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Писать и копипастить придется много,поэтому ссылка
 * https://ru.wikipedia.org/wiki/%D0%A0%D0%B0%D1%81%D1%81%D1%82%D0%BE%D1%8F%D0%BD%D0%B8%D0%B5_%D0%9B%D0%B5%D0%B2%D0%B5%D0%BD%D1%88%D1%82%D0%B5%D0%B9%D0%BD%D0%B0
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность равна O(M*N) (M - длина первой строки, N - длина второй строки)
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Для сокращения потребляемой памяти вместо целой матрицы используется только две строки: текущая и предыдущая.
 * Если строки на вход поступают разной длины, то в качестве длины строки матрицы берется кратчайшая из входных строк.
 * Таким образом требуется O(N) дополнительной памяти. (N - длина кратчайшей строки)
 * */
public class A {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();

            System.out.println(getDistLevenstain(s, t));
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
