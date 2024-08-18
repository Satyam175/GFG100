package Stacks;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String exp = "1-(     -2)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPostfix(exp));
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static int infixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> characterStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ' ')continue;;
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                characterStack.push(c);
            } else if (c == ')') {
                while (!characterStack.isEmpty() && characterStack.peek() != '(') {
                    postfix.append(characterStack.pop());
                }
                characterStack.pop();
            } else {
                while (!characterStack.isEmpty() && precedence(c) <= precedence(characterStack.peek())) {
                    postfix.append(characterStack.pop());
                }
                characterStack.push(c);
            }
        }
        while (!characterStack.isEmpty()) {
            postfix.append(characterStack.pop());
        }
        if (postfix.toString().matches("\\d+")) return Integer.parseInt(postfix.toString());
//        calculate postfix
        Stack<Integer> stack = new Stack<>();
        for (char ch : postfix.toString().toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            }else if (!Character.isWhitespace(ch)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }
}
