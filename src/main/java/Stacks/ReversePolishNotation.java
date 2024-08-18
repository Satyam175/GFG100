package Stacks;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] arr = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(arr));

    }

    public static int evalRPN(String[] tokens) {
        java.util.Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (c.equals("+") || c.equals("*") || c.equals("-") || c.equals("/")) {
                if (stack.size() < 2) {
                    continue;
                } else {
                    int second = stack.pop();
                    int first = stack.pop();
                    if(c.equals("+")){
                        stack.push(first + second);
                    }
                    if(c.equals("-")){
                        stack.push(first - second);
                    }
                    if(c.equals("*")){
                        stack.push(first * second);
                    }
                    if(c.equals("/")){
                        stack.push(first / second);
                    }
                }
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }


    /*
        public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid RPN expression");
                }
                int second = stack.pop();
                int first = stack.pop();
                stack.push(applyOperator(token, first, second));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression");
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    */
}
