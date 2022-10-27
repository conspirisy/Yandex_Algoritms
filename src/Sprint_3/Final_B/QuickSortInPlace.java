package Sprint_3.Final_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://contest.yandex.ru/contest/23815/run-report/72862818/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Подаем на вход функции массив и индексы, указывающие на левый и правый концы массива. Берем опорный элемент.
 * Затем сравниваем элементы в массиве с опорным. Элементы в левой части должны быть меньше опорного, а в правой больше.
 * Когда найдем элементы неудовлетворяющие условиям, меняем их местами. Продолжаем сравнения пока левая граница не перейдет за правую.
 * Далее рекурсивно запускаем сортировку для левой и правой половин.
 * Для хранения элементов используется класс Node, для сравнения реализована функция compare.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * После каждого прохода по отрезку массива можно с уверенностью утверждать, что в левой его половине будут находиться
 * элементы меньшие опорного, а в правой большие. Значит, относительно опрного элемента массив отсортирован.
 * Теперь нужно отсортировать получившиеся половины относительно другого опрного элемента из их промежутка.
 * Таким образом массив будет сортироваться пока промежуток не будет состоять из двух элементов. В таком случае один
 * из элементов будет считаться опорным и либо произойдет перестановка, либо порядок сохранится.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность данного алгоритма сортировки может быть разной и зависит от выбора опорного элемента.
 * В худшем случае сложность будет квадратичной. При отсортированом массиве и амом первом элементе в качестве опорного.
 * На практике алгоритм работает со сложностью O(nlogn). Для этого нужно выбирать опорный элемент случайным образом.
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Для массива из n элементов алгоритм сортировки будет потреблять констатное количество дополнительной памяти.
 * */
public class QuickSortInPlace {

    static class Participant {
        String name;
        int completedTasks;
        int penalty;

        Participant(String name, int completedTasks, int penalty) {
            this.name = name;
            this.completedTasks = completedTasks;
            this.penalty = penalty;
        }

        public String toString() {
            return name;
        }
        int compare(Participant node) {
            if (completedTasks != node.completedTasks) {
                return Integer.compare(completedTasks, node.completedTasks);
            } else if (node.penalty != penalty) {
                return Integer.compare(node.penalty, penalty);
            } else {
                return node.name.compareTo(name);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Participant[] arr = new Participant[n];
            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                arr[i] = new Participant(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            }
            quickSort(arr, 0, arr.length - 1);
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void quickSort(Participant[] arr, int left, int right) {
        Participant temp;
        int i = left, j = right;
        Participant pivot = arr[left + (right - left) / 2];
        while (i <= j) {
            while (arr[i].compare(pivot) > 0) {
                i++;
            }
            while (arr[j].compare(pivot) < 0) {
                j--;
            }
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }
        if (left < j) {
            quickSort(arr, left, j);
        }
        if (i < right) {
            quickSort(arr, i, right);
        }
    }
}


