package Sprint_6.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * https://contest.yandex.ru/contest/25070/run-report/81546215/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Использован алгоритм Прима.
 * Вершины разделяются на две группы: добавленные в MST и еще не добавленные. В начале берем первую попавшуюся вершину, добавляем ее в MST.
 * Затем помещаем в буфер исходящие из этой вершины ребра, ведущие в еще не добавленные вершины.
 * Затем из буфера получаем ребро с максимальным весом. Если это ребро ведет в недобавленную вершину, то помещаем это ребро в MST, а вершину, в которую оно ведет помечаем как добавленную.
 * Таким образом будут обработаны все вершины и для каждой будет найдено ребро с максимальным весом.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Буфер с ребрами реализован на очереди с приоритетом, чтобы не перебирать все элемены в поисках ребра с максимальным весом.
 * Так как при добавлении вершины в список добавленных будут перебираться все ребра, чтобы добавить их в буфер, спиоск ребер хранится в виде HashMap, где ключом является исходящая вершина, а
 * значением является список ребер исходящих из этой вершины. Таким образом, при добавлении вершины в MST будут перебираться не все ребра, а только инцидентные добавлемой вершине.
 * Вершины хранятся в HashSet, для константного времени проверки вхождения вершины.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность алгоритма Прима на приоритетной очереди O(|E| * log|V|). |E| - количество ребер в графе, |V| - количество вершин.
 * Приоритетная очередь позволяет получать максимальное ребро быстрее, чем из массива. Так же список всех ребер нужно хранить не в массиве, а в HashMap, чтобы не перебирать все ребра при добавлении каждой вершины.
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * |V| - хранение всех вершин, 2 * |E| - хранение всех ребер, |E| - хранение MST и буфера ребер. Итого |V| + |E|
 * */
public class A {

    static class Edge implements Comparable<Edge> {
        int end;
        int weight;

        public int getWeight() {
            return weight;
        }

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.getWeight(), this.weight);
        }
    }

    static class Graph {
        private HashSet<Integer> added;
        private HashSet<Integer> notAdded;
        private HashMap<Integer, List<Edge>> edges;
        private ArrayList<Edge> mst;
        public PriorityQueue<Edge> tempEdges;

        public HashSet<Integer> getNotAdded() {
            return notAdded;
        }

        public HashMap<Integer, List<Edge>> getEdges() {
            return edges;
        }

        public Graph() {
            added = new HashSet<>();
            notAdded = new HashSet<>();
            edges = new HashMap<>();
            mst = new ArrayList<>();
            tempEdges = new PriorityQueue<>();
        }

        public Graph(int initialCapacity) {
            added = new HashSet<>();
            notAdded = new HashSet<>();
            edges = new HashMap<>(initialCapacity);
            mst = new ArrayList<>(initialCapacity);
            tempEdges = new PriorityQueue<>(initialCapacity);
        }

        public void addVertex(Integer v) {
            added.add(v);
            notAdded.remove(v);
            edges.get(v).forEach(e -> {
                if (notAdded.contains(e.end)) {
                    tempEdges.add(e);
                }
            });
        }

        public int findMst() throws Exception {
            Integer v = notAdded.stream().findFirst().get();
            addVertex(v);

            while (!notAdded.isEmpty() && !tempEdges.isEmpty()) {
                Edge e = tempEdges.poll();
                if (notAdded.contains(e.end)) {
                    mst.add(e);
                    addVertex(e.end);
                }
            }

            if (notAdded.isEmpty()) {
                return mst.stream().mapToInt(Edge::getWeight).sum();
            } else {
                throw new Exception("Oops! I did it again");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            Graph graph = new Graph(n * 2);
            for (int i = 0; i < n; i++) {
                graph.getNotAdded().add(i + 1);
                graph.getEdges().put(i + 1, new LinkedList<>());
            }
            StringTokenizer tokenizer;
            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int from = Integer.parseInt(tokenizer.nextToken());
                int to = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());
                if (from != to) {
                    graph.getEdges().get(from).add(new Edge(to, weight));
                    graph.getEdges().get(to).add(new Edge(from, weight));
                }
            }
            try {
                System.out.println(graph.findMst());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
