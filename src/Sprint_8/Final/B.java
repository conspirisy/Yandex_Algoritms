package Sprint_8.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* https://contest.yandex.ru/contest/26133/run-report/83231528/
*
* -- ПРИНЦИП РАБОТЫ --
* Строится префиксное дерево слов из словаря. Далее подается на вход строка, создается логический массив длинной строки + 1.
* Затем происходит заполнение ячеек массива. Во внешнем цикле берется ячейка массива и ее индекс, если в ячейке TRUE, то происходит
* перебор символов входной строки и конкатенцаии их в слово, затем это слово проверяется на наличие в префиксном дереве, если слово
* присутствует (узел является терминальным), то ячейка массива под индексом последнего присоединенного символа помечается TRUE.
* После перебора всех символов и всех ячеек массива, последняя ячейка будет содержать искомый ответ.
* -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
* Префиксное дерево это дерево, ребра которого содержат символы, а узлы обозначают слова, полученные конкатенацией символов на пути к нему.
* Узел считается терминальным, если конкатенация символов на пути к нему составляет слово.
* Префиксное дерево позволяет хранить список слов, экономя при этом память. Так же можно однозначно определить, есть ли искомое слово в дереве,
* путем посимвольного перебора слова и продвижения по дереву. Последний символ приведет в узел дерева, который может быть терминальным, что
* будет означать, что слово существует, во всех остальных случаях можно считать, что слова в словаре нет.
* -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* Составление префиксного дерева занимает O(N) времени. N - суммарная длинна слов во множестве
* Поиск слова занимает O(N) времени. N - длина слова.
* Сложность функции isSeparable O(N^2)
* -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* Хранение дерева занимает O(n⋅∣Σ∣) n - максимальная длина слова, ∣Σ∣ - мощность алфавита
* */
public class B {

    public static class Node {
        private final HashMap<Character, Node> edges = new HashMap<>();
        private boolean isTerminal;

        public boolean isTerminal() {
            return isTerminal;
        }

        public void setTerminal(boolean terminal) {
            isTerminal = terminal;
        }

        public HashMap<Character, Node> getEdges() {
            return edges;
        }
    }

    private static class Trie {
        private final Node root = new Node();

        public void add(String word) {
            Node node = root;
            for (var ch : word.toCharArray()) {
                node = node.getEdges().computeIfAbsent(ch, k -> new Node());
            }
            node.setTerminal(true);
        }

        public Node getRoot() {
            return root;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            Trie trie = new Trie();
            for (int i = 0; i < n; i++) {
                trie.add(reader.readLine());
            }
            System.out.println(isSeparable(trie.getRoot(), text) ? "YES" : "NO");
        }
    }

    private static boolean isSeparable(Node root, String text) {
        boolean[] dp = new boolean[text.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]) {
                Node currentNode = root;
                for (int j = i; j < text.length(); j++) {
                    currentNode = currentNode.getEdges().get(text.charAt(j));
                    if (currentNode != null) {
                        if (currentNode.isTerminal()) {
                            dp[j + 1] = true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
