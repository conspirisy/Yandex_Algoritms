package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
* https://contest.yandex.ru/contest/22781/run-report/70824034/
*
* -- ПРИНЦИП РАБОТЫ --
* Считываем строку и преобразуем ее в StringTokenizer, чтобы удобнее было ее разделить на операнды и операции.
* В цикле считываем токен из строки и проверяем чему он равен. Если числу, то добавляем его в стэк.
* Если операции, то парсим вид операции, достаем последние два элемента из стэка и проводим над ними эту операцию,
* результат помещаем обратно в стэк. По окончанию токенов в строке выводим резльтат, достав последний элемент из стэка.
* -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
* Если складывать элементы в стэк, то храниться они будут по принципу LIFO, что позволяет правильно работать с последними
* помещенными в стэк числами, а так же хранить результат выполнения операций.
* -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* Добавление в стэк стоит O(1), извлечение из очереди стоит O(1), и операция стоит O(1).
* -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* В худшем случае, если в строке не будет операций, а только числа, программма будет потреблять O(n) памяти,
* для хранения каждого числа в стэке. Из-за отсутствия операций, числа извлекаться не будут.
* В среднем случае, нужно будет хранить два первых введенных числа и затем только одно - результат операции.
* */
public class Final_B_PolskaCalculatora {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer input = new StringTokenizer(reader.readLine());
            Stack<Integer> numbers = new Stack<>();
            while (input.countTokens() > 0) {
                String symbol = input.nextToken();
                if (symbol.equals("+")) {
                    numbers.push(numbers.pop() + numbers.pop());
                    continue;
                }
                if (symbol.equals("-")) {
                    int b = numbers.pop();
                    int a = numbers.pop();
                    numbers.push(a - b);
                    continue;
                }
                if (symbol.equals("*")) {
                    numbers.push(numbers.pop() * numbers.pop());
                    continue;
                }
                if (symbol.equals("/")) {
                    int b = numbers.pop();
                    int a = numbers.pop();
                    numbers.push(Math.floorDiv(a, b));
                    continue;
                }
                numbers.push(Integer.parseInt(symbol));
            }
            System.out.println(numbers.pop());
        }
    }
}
