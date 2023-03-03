package Sprint_6.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * https://contest.yandex.ru/contest/25070/run-report/81657604/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Использован алгоритм поиска в глубину.
 * Хранение производится в HashMap, где ключом является номер стартовой вершины, а значением список инцидентных вершин. В качестве списка используется ArrayList, т.к. операций перебора элементов гораздо больше, чем операций добавления.
 * Так же задана начальная вместимость всех контейнеров, чтобы не терять время на клонирование элементов при переполнении внутреннего массива.
 * С помощью алгоритма DFS нужно найти цикл в графе. Чтобы это удобно сделать, входные данные были представлены как B - маршрут из i вершины в j, а R - маршрут из j вершины в i.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * При поиске в глубину перебираются все доступные вершины окрашенные в белый цвет, при первом посещении вершины она красится в серый.
 * После обработки всех доступных вершин, текущая врешина красится в черный.
 * Если вершина чёрная, от неё нет пути до текущей вершины, ведь мы красим узел в чёрный после того, как все доступные из неё вершины уже обработаны. А текущая вершина ещё не обработана.
 * Если среди инцидентных вершин находится окрашенная в серый цвет вершина, то делаем вывод, что цикл в графе есть и прекращаем поиск.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Каждую вершину мы посещаем один раз. То есть сложность как минимум O(V). Для каждого узла производится проход по всем смежным с ним вершинам.
 * Сложность этого прохода зависит от того, как быстро мы можем получить этот список соседних вершин.
 * Так как граф представлен списками смежности, то перебрать все смежные вершины можно за время, пропорциональное числу этих вершин. Фактически мы перебираем рёбра, исходящие из вершины.
 * Поскольку алгоритм обрабатывает все вершины, ему придётся пройтись по всем спискам смежности. Это эквивалентно тому, чтобы пройти по каждому ребру по одному разу, что займёт O(E). Получим, что итоговая сложность алгоритма O(V + E).
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Нужно хранить массив цветов состоящий из N элементов. N - количество вершин.
 * Для хранения вершин и представления ребер нужно n2-n памяти -> O(N).
 * */
public class B {

    enum Color {
        WHITE,
        GRAY,
        BLACK;
    }

    static class Graph {
        public Color[] colors;
        public HashMap<Integer, ArrayList<Integer>> edges;

        public Graph(int initialCapacity) {
            colors = new Color[initialCapacity + 1];
            for (int i = 0; i < initialCapacity + 1; i++) {
                colors[i] = Color.WHITE;
                edges.put(i, new ArrayList<>(initialCapacity));
            }
        }

        public HashMap<Integer, ArrayList<Integer>> getEdges() {
            return edges;
        }

        public void mainDfs() throws Exception {
            for (Integer start : edges.keySet()){
                if (colors[start] == Color.WHITE) {
                    dfs(start);
                }
            }
        }
        public void dfs(int start) throws Exception {
            colors[start] = Color.GRAY;
            if (edges.get(start) != null) {
                for (Integer end : edges.get(start)) {
                    if (colors[end] == Color.WHITE) {
                        dfs(end);
                    }
                    if (colors[end] == Color.GRAY) {
                        throw new Exception("NO");
                    }
                }
            }
            colors[start] = Color.BLACK;
        }
    }




    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Graph graph = new Graph(n);
            for (int i = 1; i < n; i++) {
                String line = reader.readLine();
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == 'B') {
                        graph.getEdges().get(i).add(i + j + 1);
                    } else {
                        graph.getEdges().get(i + j + 1).add(i);
                    }
                }
            }
            String output = "YES";
            try {
                graph.mainDfs();
            } catch (Exception e) {
                output = e.getMessage();
            }
            System.out.println(output);
        }
    }
}
