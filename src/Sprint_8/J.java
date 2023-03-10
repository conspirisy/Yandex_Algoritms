package Sprint_8;

import Sprint_8.Final.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class J {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> data = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                data.add(reader.readLine());
            }
            n = Integer.parseInt(reader.readLine());
            ArrayList<String> patterns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                patterns.add(reader.readLine());
            }
            data.sort(Comparator.naturalOrder());
            Trie trie = new Trie();
            for (int i = 0; i < data.size(); i++) {
                trie.add(data.get(i), i);
            }
            StringBuilder result = new StringBuilder();
            for (String pattern:patterns) {
                for (Integer idx:trie.search(pattern)) {
                    result.append(data.get(idx)).append("\n");
                }
            }
            System.out.println(result);
        }
    }

    static class Node {
        ArrayList<Integer> terms = new ArrayList<>();
        HashMap<Character, Node> next = new HashMap<>();
    }

    static class Trie {
        Node root = new Node();

        void add(String s, int idx) {
            Node node = root;
            root.terms.add(idx);
            for (var ch : s.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    node = node.next.computeIfAbsent(ch, k -> new Node());
                    node.terms.add(idx);
                }
            }
        }

        ArrayList<Integer> search(String pattern) {
            Node node = root;
            for (int i = 0; i < pattern.length(); i++) {
                node = node.next.get(pattern.charAt(i));
                if (node == null) break;
            }
            return new ArrayList<>(node != null ? node.terms : Collections.emptyList());
        }
    }
}
