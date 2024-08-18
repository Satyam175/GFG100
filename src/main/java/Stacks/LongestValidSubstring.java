package Stacks;

import java.util.Stack;

public class LongestValidSubstring {
    public static void main(String[] args) {

        System.out.println(maxLength("())(())"));
    }

    public static int maxLength(String S) {
        // Create a stack to keep track of the indices of opening parentheses
        Stack<Integer> stack = new Stack<>();

        // Initialize the stack with a dummy index to handle edge cases
        stack.push(-1);

        // Initialize the variable to store the maximum length of valid parentheses substring
        int max = 0;

        // Iterate through each character in the input string
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // If the character is an opening parenthesis
            if (c == '(') {
                stack.push(i); // Push the index of the opening parenthesis onto the stack
            } else { // If the character is a closing parenthesis
                stack.pop(); // Pop the top index from the stack

                // If the stack is not empty, update the max length
                // The length is calculated as the difference between the current index and the index on the top of the stack
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    // If the stack is empty, push the current index onto the stack to mark the new starting point
                    stack.push(i);
                }
            }
        }

        // The final result is the maximum length of valid parentheses substring
        return max;
    }
}
