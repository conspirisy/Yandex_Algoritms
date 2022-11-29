package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://contest.yandex.ru/contest/24414/run-report/76851915/
 *
 * -- ПРИНЦИП РАБОТЫ --
 * Хеш таблица содержит сущность Entry, состоящую из ключа и значения, а так же из ссылок на следующую и предшествующую сущность Entry.
 * Индекс в таблице вычислется умножением хеша ключа на размер таблицы.
 * Метод put помещает новую сущность в таблицу, если по ключу в таблице ничего не нашлось. Если нашлось, то сравниваются ключи.
 * Для равных ключей, у сущности заменяется значение. Если ключи разные, то новая сущность помещается в переменную next, либо перебирется весь
 * список сущнойстей и новая помещается в конец списка.
 * Метод get возвращает сущность если по индексу нашлась непуста ячейка и ключи совпали, если ячейка пустая, либо в связном списке не нашлось сущности
 * с совпадающим ключом, возвращается -1.
 * Метод delete действует аналогично остальным. При удалении элемента из связного списка ссылки на соседние сущности переставляются.
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Требование к хеш таблице, о том, что множество ключей должно быть уникальным, соблюдено, согласно описанию методов get, put, delete.
 * Индекс таблицы вычислется умножением хеша ключа на размер таблицы, размер таблицы выбран достаточно большим по условию задачи и является простым числом,
 * что дает равномерное распределение сущностей по таблице.
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность операций get, put, delete в среднем и лучшем случае будет O(1 + α)  α = N/M - коэффициент заполненности таблицы, так как распределение ключей будет равномерным.
 * Однако, можно подобрать такую последовательность ключей, что будут возникать колизии и в одну ячейку может попасть несколько сущностей.
 * В таком случае сложность будет O(n), так как нужно будет перебирать весь связный список в ячейке.
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Пространственная сложность операций get, put, delete составляет O(1). Пространственная сложность всей программы будет O(n).
 * */
public class Final_B {

    static class Entry {
        int key;
        int value;
        Entry next;

        Entry (int k, int v) {
            key = k;
            value = v;
        }
    }

    static class MyHashTable {
        int capacity = 100003;
        Entry[] hashTable = new Entry[capacity];

        int getIndex(int k) {
            return k % hashTable.length;
        }


        void put(int k, int v) {
            int index = getIndex(k);
            if (hashTable[index] == null) {
                hashTable[index] = new Entry(k, v);
            } else {
                Entry e = hashTable[index];
                while (true) {
                    if (e.key == k) {
                        e.value = v;
                        break;
                    }
                    if (e.next == null) {
                        e.next = new Entry(k, v);
                        break;
                    } else {
                        e = e.next;
                    }
                }
            }
        }

        int get(int k) {
            int index = getIndex(k);
            if (hashTable[index] == null) {
                return -1;
            } else {
                Entry e = hashTable[index];
                while (true) {
                    if (e.key == k) {
                        return e.value;
                    }
                    if (e.next == null) {
                        return -1;
                    } else {
                        e = e.next;
                    }
                }
            }
        }

        int delete(int k) {
            int index = getIndex(k);
            if (hashTable[index] == null) {
                return -1;
            } else {
                Entry e = hashTable[index];
                if (e.key == k) {
                    hashTable[index] = e.next;
                    return e.value;
                } else {
                    while(true) {
                        if (e.next == null) {
                            return -1;
                        }
                        Entry prev = e;
                        e = e.next;
                        if (e.key == k) {
                            prev.next = e.next;
                            return e.value;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] command;
            StringBuilder output = new StringBuilder();
            MyHashTable hashTable = new MyHashTable();
            for (int i = 0; i < n; i++) {
                command = reader.readLine().split(" ");
                if (command[0].equals("get")) {
                    int result = hashTable.get(Integer.parseInt(command[1]));
                    output.append(result != -1 ? result : "None").append("\n");
                }
                if (command[0].equals("put")) {
                    hashTable.put(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                }
                if (command[0].equals("delete")) {
                    int result = hashTable.delete(Integer.parseInt(command[1]));
                    output.append(result != -1 ? result : "None").append("\n");
                }
            }
            System.out.println(output);
        }
    }

}
