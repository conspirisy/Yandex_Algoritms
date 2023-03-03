package Sprint_8.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * https://contest.yandex.ru/contest/26133/run-report/82782923/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Считывается запакованное слово, распаковывается и помещается в список.
 * В процессе распаковки перебираются все символы строки. Если символ является буквой, то он конкатенируется с результирующей строкой.
 * Если символ является цифрой N, то в цикле N раз рекурсивно вызывается функция распаковки для подстроки начинающейся с i + 2 символа.
 * i - текущий индекс символа в строке.
 * Если символ является закрывающей скобкой, то функция возвращает индекс этого символа k.
 * Затем движение цикла продолжается с k + 1 символа, как бы перескочив уже обработанные элементы.
 * В процессе считывания и распаковывания определяется кратчайшее слово, которое возьмем за эталон для взятия наибольшего общего префикса.
 * Затем находится наибольший общий префикс. Для этого перебираются символы из кратчайшей строки. В каждом слове из списка сравниваются символы
 * на данной позиции. Если во всех словах символы на текущем индексе совпадают, то символ конкатенируется с результирующей строкой.
 * Как только встречается несовпадение, перебор прекращается и выводится ответ.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Так как в процессе распаковки символы конкатенируются рекурсивно, то порядок не нарушается.
 * Наибольший общий префикс находится по кратчайшей строке, так как сама кратчайшая строка может являться наибольшим общим префиксом для
 * более длинных строк.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность распаковки:
 * Худшее время выполнения O(K^(N/3)). K - однозначное натуральное число. N - длинна строки.
 * 4 = 18, 7 = 243, 10 = 2916
 * 9[k]
 * 9[9[k]]
 * 9[9[9[k]]]
 * 9[9[9[9[k]]]]
 * 9[9[9[9[9[k]]]]]
 * Временная сложность поиска наибольшего общего префикса:
 * O(N*K). N - длинна кратчайшей строки, K - количество слов.
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * O(K^(N/3)*M) K - однозначное натуральное число. N - длинна строки, M - количество строк.
 * */
public class A {

    private static final StringBuilder result = new StringBuilder();
    private static final List<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String shortestWord = "";
            int minLengthOfWord = 0;
            for (int i = 0; i < n; i++) {
                unpack(reader.readLine());
                if (minLengthOfWord == 0 || result.length() < minLengthOfWord) {
                    minLengthOfWord = result.length();
                    shortestWord = result.toString();
                }
                words.add(result.toString());
                result.delete(0, result.length());
            }
            findCommonBiggestPrefix(shortestWord, minLengthOfWord);
            System.out.println(result);
        }
    }

    private static void findCommonBiggestPrefix(String shortestWord, int minLengthOfWord) {
        boolean isEqualChars = true;
        for (int i = 0; i < minLengthOfWord; i++) {
            for (String word:words) {
                if (shortestWord.charAt(i) != word.charAt(i)) {
                    isEqualChars = false;
                    break;
                }
            }
            if (isEqualChars) {
                result.append(shortestWord.charAt(i));
            } else {
                break;
            }
        }
    }

    private static int unpack(CharSequence str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result.append(str.charAt(i));
            } else {
                if (Character.isDigit(str.charAt(i))) {
                    int start = i;
                    CharSequence substr = str.subSequence(i+2, str.length());
                    for (int j = 0; j < Integer.parseInt(str, i, i+1, Character.MAX_RADIX); j++) {
                        start = unpack(substr);
                    }
                    i = i + 2 + start;
                } else {
                    return i;
                }
            }
        }
        return str.length();
    }
}
