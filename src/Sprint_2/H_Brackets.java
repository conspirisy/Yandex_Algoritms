package Sprint_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class H_Brackets {

    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            boolean result = true;
            for (int i = 0; i < input.length(); i++) {
                var bracket = input.charAt(i);
                if (bracket == ')' || bracket == ']' || bracket == '}') {
                    if (stack.empty()) {
                        result = false;
                        break;
                    }
                    if (bracket == ')' && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    if (bracket == ']' && stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                    if (bracket == '}' && stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }
                    result = false;
                    break;
                } else {
                    stack.push(bracket);
                }
            }
            if (!stack.empty()) {
                result = false;
            }
            System.out.println(result ? "True" : "False");
        }
    }
}
