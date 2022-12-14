/*
 * https://contest.yandex.ru/contest/23815/run-report/72633500/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Находим центральный элемент. Сравниваем его с искомым, если равны, то возвращаем индекс.
 * Если после сравнения выясняем, что размер массива равен 1 или 0, то возвращаем -1, так как элемент отсутствует.
 * Иначе узнаем в какой половине массива находится искомый элемент.
 * Далее рекурсивно вызываем поиск сокращая промежуток в массиве.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Так как массив является отсортированным, мы можем использовать бинарный поиск. Проблема заключается в том, что смещен стартовый элемент.
 * Если искомый элемент больше центрального и при этом центральный элемент больше правого или искомый меньше правого, то искать нужно в правой половине.
 * Если искомый больше центрального, но центральный меньше правого и искомый больше правого, то искать нужно в левой части.
 * Если искомый меньше централього, а центральный меньше левого или искомый больше левого, то искать нужно в левой части.
 * Если искомый меньше централього, а центральный больше левого и искомый меньше левого, то искать нужно в правой части.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность данного алгоритма поиска O(logn), так как это такой же бинарный поиск по отсортированному массиву.
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Алгоритм поиска использует дополнитульную память на стек рекурсивных вызовов. O(logn)
 * */
public class Solution {
    public static int brokenSearch(int[] arr, int k) {
        return find(arr, 0, arr.length, k);
    }

    public static int find(int[] a, int left, int right, int k) {
        int mid = left + (right - left) / 2;
        if (a[mid] == k) {
            return mid;
        }
        if (right - left < 2) {
            return -1;
        }
        if (k > a[mid]) {
            if (a[mid] > a[right-1] || k <= a[right-1]) {
                return find(a, mid + 1, right, k);
            } else {
                return find(a, left, mid, k);
            }
        } else {
            if (a[mid] < a[left] || k >= a[left]) {
                return find(a, left, mid, k);
            } else {
                return find(a, mid + 1, right, k);
            }
        }
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }
}
