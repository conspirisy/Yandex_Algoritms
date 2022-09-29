package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* https://contest.yandex.ru/contest/22781/run-report/70910846/
*
* -- ПРИНЦИП РАБОТЫ --
* Я реализовал алгоритм на кольцевом буфере. При добавлении элемента в голову очереди, элемент вставляется в массив
* по индексу head, предварительно сдвинув этот индекс в сторону возрастания. При добавлении элемента в хвост очереди,
* элемент вставляется в массив по индексу tail, предварительно сдвинув этот индекс в сторону убывания. Если очередь пуста,
* то индексы head и tail указывают на один и тот же элемент в массиве, как и при наличии всего одного элемента в очереди.
* -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
* Из описания алгоритма следует, что чем раньше элемент добавился в очередь, тем раньше он будет из неё извлечён.
* В случае двусторонней очереди на кольцевом буфере мы можем добавлять элементы с обоих концов, пока указатели не будут
* смотреть на один и тот же элемент. Добавляя элементы в конец очереди, указатель будет сдвигаться в одну сторону,
* а добавляя в начало очереди, указатель будет двигаться в противоположную сторону.
* -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* Добавление в очередь стоит O(1), так как не нужно изменять размер массива и достаточно просто поместить элемент по индексу.
* Извлечение из очереди стоит O(1), так как не нужно изменять размер массива и достаточно просто извлечть элемент по индексу.
* -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* Очередь, содержащая n элементов, будет потреблять n памяти.
* */
public class Final_A_Dequeue {

    //хранение в int требует парсинга строки, что занимает время и программа не укладывается в лимит на 12 тысячных секунды
    //других вариантов оптимизации я не вижу
    private String[] queue;

    private int maxSize;
    private int head;
    private int tail;
    private int size;

    public Final_A_Dequeue (int maxSize) {
        this.maxSize = maxSize;
        this.queue = new String[maxSize];
        head = tail = 0;
    }

    public void push_front(String x) {
        if (size >= maxSize) {
            throw new RuntimeException("error");
        } else {
            if (size == 0) {
                head = tail;
            } else {
                head = (head + 1) % maxSize;
            }
            queue[head] = x;
            size++;
        }
    }

    public void push_back(String x) {
        if (size >= maxSize) {
            throw new RuntimeException("error");
        } else {
            if (size == 0) {
                tail = head;
            } else {
                tail = tail == 0 ? maxSize - 1 : tail - 1;
            }
            queue[tail] = x;
            size++;
        }
    }

    public String pop_front() {
        if (size == 0) {
            throw new RuntimeException("error");
        } else {
            String result = queue[head];
            head = head == 0 ? maxSize - 1 : head - 1;
            size--;
            return result;
        }
    }

    public String pop_back() {
        if (size == 0) {
            throw new RuntimeException("error");
        } else {
            String result = queue[tail];
            tail = (tail + 1) % maxSize;
            size--;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int countCommands = Integer.parseInt(reader.readLine());
            int maxSize = Integer.parseInt(reader.readLine());
            Final_A_Dequeue queue = new Final_A_Dequeue(maxSize);
            for (int i = 0; i < countCommands; i++) {
                StringTokenizer command = new StringTokenizer(reader.readLine());
                String token = command.nextToken();
                try {
                    switch (token) {
                        case "push_front":
                            queue.push_front(command.nextToken());
                            break;
                        case "push_back":
                            queue.push_back(command.nextToken());
                            break;
                        case "pop_front":
                            System.out.println(queue.pop_front());
                            break;
                        case "pop_back":
                            System.out.println(queue.pop_back());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
