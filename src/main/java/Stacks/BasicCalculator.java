package Stacks;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {
        java.util.Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1; // 1 for positive, -1 for negative

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                sign = 1; // update sign for the next number
                num = 0; // reset num
            } else if (c == '-') {
                result += sign * num;
                sign = -1; // update sign for the next number
                num = 0; // reset num
            } else if (c == '(') {
                stack.push(result); // push the result before entering parentheses
                stack.push(sign); // push the sign before entering parentheses
                result = 0; // reset result for the expression inside parentheses
                sign = 1; // reset sign for the expression inside parentheses
            } else if (c == ')') {
                result += sign * num; // calculate the result within parentheses
                result *= stack.pop(); // multiply by the sign before entering parentheses
                result += stack.pop(); // add the result before entering parentheses
                num = 0; // reset num
            }
        }

        // Add the last number to the result
        result += sign * num;

        return result;
    }
}
