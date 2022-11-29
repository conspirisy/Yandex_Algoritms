package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * https://contest.yandex.ru/contest/24414/run-report/76004683/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Для начала нужно считать входные данные и разместить их в определенной структуре. Структура это карта, в которой ключом является слово из документа
 * а значением является отображение номера документа и количества вхождений слова в этот документ.
 * Затем для каждого запроса нужно составить список релевантных документов. Составляем множество уникальных слов из запроса.
 * Проверяем есть ли слово из запроса во входных данных. И составляем карту номеров документов и суммы вхождений слов.
 * Для каждого запроса выводим пять релевантных документов отсортированных в порядке убывания релевантности.
 * Для сортировки используется стандартный метод sort() реализованный с помощью quicksort, сложность O(nlogn)
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Использование карты для хранения входных данных позволяет хранить уникальные слова в виде ключа, а отображение на другую карту из номеров документа
 * и кол-ва вхождений позволяет определить в каких документах и в каком количестве содержится слово. Структура карты позволяет хранить множество
 * уникальных ключей, исключая повторы слов и номеров документов.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность данного алгоритма поиска O(nlogn), так как нужно сортировать массив.
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Нужно хранить карту слов отображенную на карту документов и кол-ва вхождений слова. Так же нужно хранить множество слов для каждого запроса.
 * n - количество уникальных слов из всех документов, m - количество запросов. O(n + m) = O(n)
 * */
public class Final_A {

    static Map<String, Map<Integer, Integer>> dict = new HashMap<>();

    public static void read(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String[] s = input[i].split(" ");
            for (int j = 0; j < s.length; j++) {
                if (dict.containsKey(s[j])) {
                    Map<Integer, Integer> innerMap = dict.get(s[j]);
                    if (innerMap.containsKey(i+1)) {
                        innerMap.replace(i+1, innerMap.get(i+1) + 1);
                    } else {
                        innerMap.put(i+1, 1);
                    }
                } else {
                    HashMap<Integer, Integer> value = new HashMap<>();
                    value.put(i+1, 1);
                    dict.put(s[j], value);
                }
            }
        }
    }

    public static void write(String[] input) {
        for (int i = 0; i < input.length; i++) {
            HashSet<String> request = new HashSet<>(Arrays.asList(input[i].split(" ")));
            HashMap<Integer, Integer> index = new HashMap<>();
            for (String word : request) {
                if (dict.containsKey(word)) {
                    var innerMap = dict.get(word);
                    for (Map.Entry<Integer, Integer> entry : innerMap.entrySet()) {
                        if (index.containsKey(entry.getKey())) {
                            index.replace(entry.getKey(), index.get(entry.getKey()) + entry.getValue());
                        } else {
                            index.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(index.entrySet());
            entries.sort((e1, e2) -> {
                int res = Integer.compare(e2.getValue(), e1.getValue());
                return res != 0 ? res : Integer.compare(e1.getKey(), e2.getKey());
            });
            print(entries);
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = reader.readLine();
            }
            read(input);

            n = Integer.parseInt(reader.readLine());
            input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = reader.readLine();
            }
            write(input);
        }
    }

    public static void print(ArrayList<Map.Entry<Integer, Integer>> list) {
        int fiveMax = 5;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() > 0) {
                System.out.print(entry.getKey() + " ");
                fiveMax--;
            }
            if (fiveMax <= 0) break;
        }
    }
}
