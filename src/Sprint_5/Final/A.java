package Sprint_5.Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * https://contest.yandex.ru/contest/24810/run-report/80516927/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Принцип работы заключается в том, что дерево хранится в массиве. Корневой элемент дерева хранится в ячейке с индексом 1;
 * Для индекса i каждой яйчеки потомки находятся в ячейках с индексами i * 2 и i * 2 + 1;
 * Чтобы извлекать элементы из дерева упорядоченным образом, нужно всегда брать элемент из ячейки с индексом 1;
 * В освободившуюся ячейку нужно перенести элемент из последней занятой ячейки в массиве;
 * Затем нужно привести дерево к упорядоченному виду с помощью просеивания перенесенного элемента вниз.
 * При заполнении массива, элемент добавляется в последнюю свободную ячейку, а потом просеивается вверх.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * индекс родителя узла i равен i/2
 * индекс левого потомка узла i равен 2 * i
 * индекс правого потомка узла i равен 2 * i + 1
 * Благодаря такой структуре хранения дерева, по номеру дочернего узла можно определить номер его родителя, а по номеру родителя — индексы его потомков, если они существуют
 * Ключ в любой вершине не меньше (если куча для максимума), чем значения её потомков. Это свойство гарантирует, что в вершине находится самый приоритетный элемент
 * Как следует из свойств кучи, самый приоритетный элемент всегда находится на вершине, и его можно получить из массива по индексу 1
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Так как при вставке мы на каждом уровне проводим только одно сравнение элемента, а куча у нас имеет высоту log2N, то вставка происходит за O(logN).
 * Так как при удалении мы на каждом уровне дерева проводим не более двух сравнений элемента, а куча у нас имеет высоту log2N, то удаление происходит за O(logN).
 *  -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Пространственная сложность O(1). Понадобится хранить одну кучу из элементов, и один отсортированный массив.
 * */
public class A {

    public static class Node implements Comparable<Node> {
        private String login;
        private int count;
        private int penalty;

        public Node(String[] inputString) {
            this.login = inputString[0];
            this.count = Integer.parseInt(inputString[1]);
            this.penalty = Integer.parseInt(inputString[2]);
        }

        public Node(String login, int count, int penalty) {
            this.login = login;
            this.count = count;
            this.penalty = penalty;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPenalty() {
            return penalty;
        }

        public void setPenalty(int penalty) {
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Node node) {
            if (count != node.count) {
                return Integer.compare(count, node.count);
            } else if (node.penalty != penalty) {
                return Integer.compare(node.penalty, penalty);
            } else {
                return node.login.compareTo(login);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] array = new String[n];
            for (int i = 0; i < n; i++) {
                array[i] = reader.readLine();
            }
            System.out.println(heapSort(array));
        }
    }

    public static StringBuilder heapSort(String[] array) {
        ArrayList<Node> heap = new ArrayList<>(array.length);
        heap.add(null);
        for (int i = 0; i < array.length; i++) {
            heapAdd(heap, new Node(array[i].split(" ")));
        }
        StringBuilder output = new StringBuilder();
        while (heap.size() > 1) {
            output.append(popMax(heap).getLogin()).append("\n");
        }
        return output;
    }

    public static Node popMax(ArrayList<Node> heap) {
        Node result = heap.get(1);
        Node swap = heap.remove(heap.size() - 1);
        if (heap.size() != 1) {
            heap.set(1, swap);
            siftDown(heap, 1);
        }
        return result;
    }

    public static void siftDown(ArrayList<Node> heap, int index) {
        int left = 2 * index;
        int right = 2 * index + 1;

        if (heap.size() <= left) {
            return;
        }
        int indexLargest;
        if (right < heap.size() && heap.get(left).compareTo(heap.get(right)) < 0) {
            indexLargest = right;
        } else {
            indexLargest = left;
        }
        if (heap.get(index).compareTo(heap.get(indexLargest)) < 0) {
            Node temp = heap.get(index);
            heap.set(index, heap.get(indexLargest));
            heap.set(indexLargest, temp);
            siftDown(heap, indexLargest);
        }
    }

    public static void heapAdd(ArrayList<Node> heap, Node key) {
        int index = heap.size();
        heap.add(index, key);
        siftUp(heap, index);
    }

    public static void siftUp(ArrayList<Node> heap, int index) {
        if (index == 1) return;
        int parentIndex = index / 2;
        if (heap.get(parentIndex).compareTo(heap.get(index)) < 0) {
            Node temp = heap.get(index);
            heap.set(index, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            siftUp(heap, parentIndex);
        }
    }
}
